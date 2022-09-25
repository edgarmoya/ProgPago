package dao;

import entidades.Moneda;
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
public class MonedaDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    public boolean agregarMoneda (Moneda moneda) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try{
                String sql = "INSERT INTO moneda VALUES (?,?,?::bit(1))";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, moneda.getSiglas());
                stmt.setString(2, moneda.getNombre());
                stmt.setString(3, "1");

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                fueAgregado = (cantidad > 0);

            } catch (Exception e){
                System.out.println("Error al agregar moneda "+e.getMessage());
                throw new BDException(e.getMessage()); 
            } finally{
                conn.close();
            }
        }
        return fueAgregado;
    }
    
    // Listar todas las monedas de la bd
    public ArrayList<Moneda> listaMonedasActivas() throws SQLException, ClassNotFoundException, ConnectionException {
        Connection conn = pg.getConnection();
        ArrayList<Moneda> monedas = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM moneda WHERE activo='1' ORDER BY siglas";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Moneda m = new Moneda();
                    m.setSiglas(rs.getString("siglas"));
                    m.setNombre(rs.getString("nombre"));
                    monedas.add(m);
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar las monedas activas: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return monedas;
    }
    
    // Obtener datos de la moneda a partir de la siglas
    public Moneda getMoneda(String siglas) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        Moneda m = new Moneda();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM moneda WHERE siglas = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, siglas);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    m.setSiglas(rs.getString("siglas"));
                    m.setNombre(rs.getString("nombre"));
                }
            } catch (Exception e) {
                System.out.println("Error al obtener moneda: " + e.getMessage());
                throw new BDException(e.getMessage());     
            } finally {
                conn.close();
            }
        }
        return m;
    }
    
    // Actualizar moneda a partir de la sigla
    public boolean actualizarMoneda(String sig, Moneda moneda) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isUpdate = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "UPDATE moneda SET siglas=? ,nombre=? WHERE siglas=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, moneda.getSiglas());
                stmt.setString(2, moneda.getNombre());
                stmt.setString(3, sig);

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                isUpdate = (cantidad > 0);

            } catch (Exception e) {
                System.out.println("Error al actualizar moneda " + e.getMessage());
                throw new BDException(e.getMessage());             
            } finally {
                conn.close();
            }
        }
        return isUpdate;
    }
}

