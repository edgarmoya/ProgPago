package dao;

import entidades.Destino;
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
public class DestinoDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    public int agregarDestino (Destino destino) throws SQLException, ClassNotFoundException, ConnectionException, BDException {      
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try{
                String sql = "SELECT add_destino(?, ?, ?::bit(1))";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, destino.getId_destino());
                stmt.setString(2, destino.getNombre());
                stmt.setString(3, "1");
                
                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();

                res.next();
                result = res.getInt(1);
            } catch (PSQLException e){
                System.out.println("Error al agregar destino "+e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());  
            } finally{
                conn.close();
            }
        }
        return result;
    }
    
    // Listar todos los destinos ACTIVOS de la bd
    public ArrayList<Destino> listaDestinosActivos() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Destino> destinos = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM lista_destinos_activos()";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Destino d = new Destino();
                    d.setId_destino(rs.getString("id_destino"));
                    d.setNombre(rs.getString("nombre"));
                    destinos.add(d);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar los destinos activos: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage()); 
            } finally {
                conn.close();
            }
        }
        return destinos;
    }
    
    // Listar TODOS los destinos de la bd
    public ArrayList<Destino> listaTodosDestinos() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Destino> destinos = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM lista_todos_destinos()";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Destino d = new Destino();
                    d.setId_destino(rs.getString("id_destino"));
                    d.setNombre(rs.getString("nombre"));
                    d.setActivo(rs.getByte("activo"));
                    destinos.add(d);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar todos los destinos: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
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
            } catch (PSQLException e) {
                System.out.println("Error al obtener destino: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return d;
    }
    
    // Actualizar destino a partir del código
    public int actualizarDestino(String cod, Destino destino) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT edit_destino(?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, destino.getId_destino());
                stmt.setString(2, destino.getNombre());
                stmt.setString(3, cod);
                
                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();

                res.next();
                result = res.getInt(1);
            } catch (PSQLException e) {
                System.out.println("Error al actualizar destino " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Eliminar destino a partir del codigo, si tiene programaciones solo inactivar
    public int eliminarDestino(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT delete_destino(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();
                res.next();
                result = res.getInt(1);
                conn.commit();   
            } catch (PSQLException e) {
                System.out.println("Error al eliminar destino " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Obtener si el destino se encuentra en uso a partir del codigo
    public int useDestino(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT use_destino(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                
                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
    
            } catch (PSQLException e) {
                System.out.println("Error al obtener si el destino está en uso: " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Activar destino a partir del código
    public int activarDestino(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT activate_destino(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();
                res.next();
                result = res.getInt(1);
                conn.commit();
            } catch (PSQLException e) {
                System.out.println("Error al activar destino " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Obtener si el destino está activo o no
    public int isActivo(String cod) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT activo FROM destino WHERE id_destino=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cod);               

                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
                
            } catch (PSQLException e) {
                System.out.println("Error al comprobar si el destino es activo" + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
}
