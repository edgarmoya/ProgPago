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
import org.postgresql.util.PSQLException;
import ppago.ConexionPg;

/**
 *
 * @author Lester
 */
public class EjercicioDAO {

    private ConexionPg pg = new ConexionPg();

    // Agregar ejercicio
    public boolean agregarEjercicio(Ejercicio ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL add_ejercicio(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ejercicio.getEjercicio());

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                fueAgregado = true;
            } catch (PSQLException e) {
                System.out.println("Error al agregar ejercicio " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());
            } finally {
                conn.close();
            }
        }
        return fueAgregado;
    }

    // Listar todos los ejercicios de la bd
    public ArrayList<Ejercicio> listaEjercicios() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
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
            } catch (PSQLException e) {
                System.out.println("Error al mostrar los ejercicios: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());
            } finally {
                conn.close();
            }
        }
        return ejercicios;
    }
    
      
    // Listar todos los períodos de la bd del ejercicio correspondiente
    public ArrayList<Periodo> listaPeriodos(String ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
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
            } catch (PSQLException e) {
                System.out.println("Error al mostrar los períodos: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());
            } finally {
                conn.close();
            }
        }
        return periodos;
    }
    
    // Obtener datos del ejercicio a partir del código
    public Ejercicio getEjercicio(String ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        Ejercicio ej = new Ejercicio();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM ejercicio WHERE ejercicio = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ejercicio);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    ej.setCod_ejercicio(rs.getInt("cod_ejercicio"));
                    ej.setEjercicio(rs.getString("ejercicio"));
                    ej.setFecha_inicio(rs.getDate("fecha_inicio"));
                    ej.setFecha_fin(rs.getDate("fecha_fin"));
                }
            } catch (PSQLException e) {
                System.out.println("Error al obtener ejercicio: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return ej;
    }
    
    // Actualizar ejercicio a partir del código
    public boolean editarEjercicio(String cod, Ejercicio ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isUpdate = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL edit_ejercicio(?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(cod));
                stmt.setString(2, ejercicio.getEjercicio());

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                isUpdate = true;

            } catch (PSQLException e) {
                System.out.println("Error al actualizar ejercicio " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isUpdate;
    }
    
    // Actualizar ejercicio a partir del código
    public boolean eliminarEjercicio(String ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isDelete = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL delete_ejercicio(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ejercicio);

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                isDelete = true;
            } catch (PSQLException e) {
                System.out.println("Error al eliminar ejercicio " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isDelete;
    }
}
