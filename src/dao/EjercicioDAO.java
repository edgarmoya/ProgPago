package dao;

import entidades.Ejercicio;
import entidades.Periodo;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ppago.ConexionPg;

/**
 *
 * @author Lester
 */
public class EjercicioDAO {

    private ConexionPg pg = new ConexionPg();

    public boolean agregarEjercicio(Ejercicio ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "CALL public.add_ejercicio(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ejercicio.getEjercicio());

                //ejecutamos la sentencia
                stmt.execute();
                fueAgregado = true;
            } catch (Exception e) {
                System.out.println("Error al agregar ejercicio " + e.getMessage());
                throw new BDException(e.getMessage());
            } finally {
                conn.close();
            }
        }
        return fueAgregado;
    }

    // Listar todos los ejercicios de la bd
    public ArrayList<Ejercicio> listaEjercicios() throws SQLException, ClassNotFoundException, ConnectionException {
        Connection conn = pg.getConnection();
        ArrayList<Ejercicio> ejercicios = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM ejercicio ORDER BY ejercicio DESC";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Ejercicio e = new Ejercicio();
                    e.setCod_ejercicio(rs.getInt("cod_ejercicio"));
                    e.setEjercicio(rs.getString("ejercicio"));
                    e.setFecha_inicio(rs.getDate("fecha_inicio"));
                    e.setFecha_fin(rs.getDate("fecha_fin"));
                    ejercicios.add(e);
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar los ejercicios: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return ejercicios;
    }
    
    
    // Listar todos los periodos de la bd del ejercicio correspondiente
    public ArrayList<Periodo> listaPeriodos(String ejercicio) throws SQLException, ClassNotFoundException, ConnectionException {
        Connection conn = pg.getConnection();
        ArrayList<Periodo> periodos = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM lista_periodos(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ejercicio);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Periodo p = new Periodo();
                    p.setNombre(rs.getString("mes"));
                    p.setFecha_inicio(rs.getDate("inicio"));
                    p.setFecha_fin(rs.getDate("fin"));
                    periodos.add(p);
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar los periodos: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return periodos;
    }
}
