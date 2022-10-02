package dao;

import entidades.TipoFinan;
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
public class TipoFinanDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    // Agregar tipo de financiamiento
    public boolean agregarTipoFinan (TipoFinan tipofinan) throws SQLException, ClassNotFoundException, ConnectionException, BDException {      
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try{
                String sql = "INSERT INTO tipofinan VALUES (?,?,?::bit)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, tipofinan.getCod_tipo());
                stmt.setString(2, tipofinan.getDescripcion());
                stmt.setString(3, "1");

                // ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                fueAgregado = (cantidad > 0);

            } catch (PSQLException e){
                System.out.println("Error al agregar tipo de financiamiento "+e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());
            } finally{
                conn.close();
            }
        }
        return fueAgregado;
    }
    
    // Listar todos los tipos de financiamiento ACTIVOS de la bd
    public ArrayList<TipoFinan> listaTipoFinanActivos() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<TipoFinan> tipofinans = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM tipofinan WHERE activo='1' ORDER BY cod_tipo";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    TipoFinan tf = new TipoFinan();
                    tf.setCod_tipo(rs.getString("cod_tipo"));
                    tf.setDescripcion(rs.getString("descripcion"));
                    tipofinans.add(tf);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar los tipos de financiamientos activos: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());
            } finally {
                conn.close();
            }
        }
        return tipofinans;
    }
    
    // Listar TODOS los tipos de financiamiento de la bd
    public ArrayList<TipoFinan> listaTodoTipoFinan() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<TipoFinan> tipofinans = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM tipofinan ORDER BY cod_tipo";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    TipoFinan tf = new TipoFinan();
                    tf.setCod_tipo(rs.getString("cod_tipo"));
                    tf.setDescripcion(rs.getString("descripcion"));
                    tf.setActivo(rs.getByte("activo"));
                    tipofinans.add(tf);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar todos los tipos de financiamientos: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());
            } finally {
                conn.close();
            }
        }
        return tipofinans;
    }
    
    // Obtener datos del tipo de financiamiento a partir del código
    public TipoFinan getTipoFinan(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        TipoFinan tf = new TipoFinan();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM tipofinan WHERE cod_tipo = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    tf.setCod_tipo(rs.getString("cod_tipo"));
                    tf.setDescripcion(rs.getString("descripcion"));
                }
            } catch (PSQLException e) {
                System.out.println("Error al obtener tipo de financiamiento: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return tf;
    }
    
    // Actualizar tipo de financiamiento a partir del código
    public boolean editarTipoFinan(String cod, TipoFinan tipofinan) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isUpdate = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "UPDATE tipofinan SET cod_tipo=? , descripcion=? WHERE cod_tipo=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, tipofinan.getCod_tipo());
                stmt.setString(2, tipofinan.getDescripcion());
                stmt.setString(3, cod);

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                isUpdate = (cantidad > 0);

            } catch (PSQLException e) {
                System.out.println("Error al actualizar tipo de financiamiento " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isUpdate;
    }
    
    // Eliminar tipo de financiamiento a partir del codigo
    // Si se encuentra en programaciones solo inactivar
    public boolean eliminarTipoFinan(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isDelete = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL delete_tipofinan(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                isDelete = true;
            } catch (PSQLException e) {
                System.out.println("Error al eliminar tipo de financiamiento " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isDelete;
    }
    
    // Obtener si el tipo de financiamiento se encuentra en uso a partir del codigo
    public int useTipoFinan(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT use_tipofinan(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                
                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
    
            } catch (PSQLException e) {
                System.out.println("Error al obtener si el tipo de financiamiento está en uso: " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Activar tipo de financiamiento a partir del código
    public boolean activarTipoFinan(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean activado;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL activate_tipofinan(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                activado = true;
            } catch (PSQLException e) {
                System.out.println("Error al activar tipo de financiamiento " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return activado;
    }
    

    // Obtener si el tipo de financiamiento está activo o no
    public int isActivo(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT activo FROM tipofinan WHERE cod_tipo=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
                
            } catch (PSQLException e) {
                System.out.println("Error al comprobar si el tipo de financiamiento es activo " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
}
