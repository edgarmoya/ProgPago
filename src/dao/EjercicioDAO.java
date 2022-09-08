package dao;

import entidades.Ejercicio;
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
    
    public boolean agregarEjercicio (Ejercicio ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        }else {
            try{
                String sql = "insert into ejercicio values (default,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ejercicio.getEjercicio());

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                fueAgregado = (cantidad > 0);
            
            } catch (Exception e){
            
            System.out.println("Error al agregar ejercicio "+e.getMessage());
            throw new BDException(e.getMessage());  
        } finally{
            conn.close();
            }
        }
        return fueAgregado;
    }
    // Listar todos los clientes de la bd
        public ArrayList<Ejercicio> listaEjercicios() throws SQLException, ClassNotFoundException, ConnectionException {
            Connection conn = pg.getConnection();
            ArrayList<Ejercicio> ejercicios = new ArrayList<>();
            if (conn == null) {
                throw new ConnectionException("No se pudo establecer conexión con la base de datos");
            } else {
                try {
                    String sql = "SELECT * FROM ejercicio ORDER BY cod_ejercicio";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        //Preparar los datos
                        Ejercicio e = new Ejercicio();
                        e.setCod_ejercicio(rs.getInt("cod_ejercicio"));
                        e.setEjercicio(rs.getString("ejercicio"));
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
}

