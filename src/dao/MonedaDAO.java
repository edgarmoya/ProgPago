package dao;

import entidades.Moneda;
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
public class MonedaDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    // Método para agregar moneda
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

            } catch (PSQLException e){
                System.out.println("Error al agregar moneda "+e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage()); 
            } finally{
                conn.close();
            }
        }
        return fueAgregado;
    }
    
    // Listar todas las monedas ACTIVAS de la bd
    public ArrayList<Moneda> listaMonedasActivas() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
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
            } catch (PSQLException e) {
                System.out.println("Error al mostrar las monedas activas: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage()); 
            } finally {
                conn.close();
            }
        }
        return monedas;
    }
    
    // Listar TODAS las monedas de la bd
    public ArrayList<Moneda> listaTodasMonedas() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Moneda> monedas = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM moneda ORDER BY siglas";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Moneda m = new Moneda();
                    m.setSiglas(rs.getString("siglas"));
                    m.setNombre(rs.getString("nombre"));
                    m.setActivo(rs.getByte("activo"));
                    monedas.add(m);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar todas las monedas: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage()); 
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
            } catch (PSQLException e) {
                System.out.println("Error al obtener moneda: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());     
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

            } catch (PSQLException e) {
                System.out.println("Error al actualizar moneda " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isUpdate;
    }
    
     // Eliminar moneda a partir de las siglas
    // Si tiene programaciones solo inactivar
    public boolean eliminarMoneda(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isDelete = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL delete_moneda(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                isDelete = true;
            } catch (PSQLException e) {
                System.out.println("Error al eliminar moneda " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isDelete;
    }
    
    // Obtener si la moneda se encuentra en uso a partir del codigo
    public int useMoneda(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT use_moneda(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                
                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
    
            } catch (PSQLException e) {
                System.out.println("Error al obtener si la moneda está en uso: " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Activar moneda a partir del código
    public boolean activarMoneda(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean activado;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL activate_moneda(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                activado = true;
            } catch (PSQLException e) {
                System.out.println("Error al activar moneda " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return activado;
    }
    
    // Obtener si la moneda está activa o no
    public int isActivo(String cod) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT activo FROM moneda WHERE siglas=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cod);               

                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
                
            } catch (PSQLException e) {
                System.out.println("Error al comprobar si la moneda es activa" + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
}

