package dao;

import entidades.Destino;
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
public class DestinoDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    public boolean agregarDestino (Destino destino) throws SQLException, ClassNotFoundException, ConnectionException, BDException {      
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try{
                String sql = "INSERT INTO destino VALUES (?,?,?::bit(1))";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, destino.getId_destino());
                stmt.setString(2, destino.getNombre());
                stmt.setString(3, "1");

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                fueAgregado = (cantidad > 0);

            } catch (Exception e){
                System.out.println("Error al agregar destino "+e.getMessage());
                throw new BDException(e.getMessage());   
            } finally{
                conn.close();
            }
        }
        return fueAgregado;
    }
    
    // Listar todos los destinos de la bd
    public ArrayList<Destino> listaDestinosActivos() throws SQLException, ClassNotFoundException, ConnectionException {
        Connection conn = pg.getConnection();
        ArrayList<Destino> destinos = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM destino WHERE activo='1' ORDER BY id_destino";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Destino d = new Destino();
                    d.setId_destino(rs.getString("id_destino"));
                    d.setNombre(rs.getString("nombre"));
                    destinos.add(d);
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar los destinos activos: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return destinos;
    }
    
    // Obtener datos del destino a partir del código
    public Destino getDestino(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        Destino d = new Destino();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM destino WHERE id_destino = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    d.setId_destino(rs.getString("id_destino"));
                    d.setNombre(rs.getString("nombre"));
                }
            } catch (Exception e) {
                System.out.println("Error al obtener destino: " + e.getMessage());
                throw new BDException(e.getMessage());     
            } finally {
                conn.close();
            }
        }
        return d;
    }
    
    // Actualizar destino a partir del código
    public boolean actualizarDestino(String cod, Destino destino) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isUpdate = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "UPDATE destino SET id_destino=? ,nombre=? WHERE id_destino=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, destino.getId_destino());
                stmt.setString(2, destino.getNombre());
                stmt.setString(3, cod);

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                isUpdate = (cantidad > 0);

            } catch (Exception e) {
                System.out.println("Error al actualizar destino " + e.getMessage());
                throw new BDException(e.getMessage());             
            } finally {
                conn.close();
            }
        }
        return isUpdate;
    }
}
