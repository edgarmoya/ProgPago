package dao;

import entidades.Cliente;
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
public class ClienteDAO {

    private ConexionPg pg = new ConexionPg();

    // Método para agregar cliente
    public int agregarCliente(Cliente cliente) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT add_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?::bit(1))";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cliente.getCod_cliente());
                stmt.setString(2, cliente.getNombre());
                stmt.setString(3, cliente.getOrganismo());
                stmt.setString(4, cliente.getNit());
                stmt.setString(5, cliente.getReeup());
                stmt.setString(6, cliente.getCorreo());
                stmt.setString(7, cliente.getDireccion());
                stmt.setString(8, cliente.getTelefono());
                stmt.setString(9, "1");
                
                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();

                res.next();
                result = res.getInt(1);
            } catch (PSQLException e) {
                System.out.println("Error al agregar cliente " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }

    // Listar todos los clientes ACTIVOS de la bd
    public ArrayList<Cliente> listaClientesActivos() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Cliente> clientes = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM lista_clientes_activos()";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Cliente c = new Cliente();
                    c.setCod_cliente(rs.getString("cod_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setOrganismo(rs.getString("organismo"));
                    c.setNit(rs.getString("nit"));
                    c.setReeup(c.reeupConGuiones(rs.getString("reeup")));
                    c.setCorreo(rs.getString("correo"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setTelefono(rs.getString("telefono"));
                    clientes.add(c);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar los clientes activos: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return clientes;
    }
    
    // Listar TODOS los clientes de la bd
    public ArrayList<Cliente> listaTodosClientes() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Cliente> clientes = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM lista_todos_clientes()";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Cliente c = new Cliente();
                    c.setCod_cliente(rs.getString("cod_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setOrganismo(rs.getString("organismo"));
                    c.setNit(rs.getString("nit"));
                    c.setReeup(c.reeupConGuiones(rs.getString("reeup")));
                    c.setCorreo(rs.getString("correo"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setActivo(rs.getByte("activo"));
                    clientes.add(c);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar todos los clientes: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return clientes;
    }
      
    // Obtener datos del cliente a partir del código
    public Cliente getCliente(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        Cliente c = new Cliente();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM cliente WHERE cod_cliente = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    c.setCod_cliente(rs.getString("cod_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setOrganismo(rs.getString("organismo"));
                    c.setNit(rs.getString("nit"));
                    c.setReeup(c.reeupConGuiones(rs.getString("reeup")));
                    c.setCorreo(rs.getString("correo"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setTelefono(rs.getString("telefono"));
                }
            } catch (PSQLException e) {
                System.out.println("Error al obtener cliente: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return c;
    }
    
    // Actualizar cliente a partir del código
    public int editarCliente(String cod, Cliente cliente) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT edit_cliente(?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cliente.getCod_cliente());
                stmt.setString(2, cliente.getNombre());
                stmt.setString(3, cliente.getOrganismo());
                stmt.setString(4, cliente.getNit());
                stmt.setString(5, cliente.getReeup());
                stmt.setString(6, cliente.getCorreo());
                stmt.setString(7, cliente.getDireccion());
                stmt.setString(8, cliente.getTelefono());
                stmt.setString(9, cod);

                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();
                res.next();
                result = res.getInt(1);
            } catch (PSQLException e) {
                System.out.println("Error al actualizar cliente " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Eliminar cliente a partir del codigo, si tiene programaciones solo inactivar
    public int eliminarCliente(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT delete_cliente(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();
                res.next();
                result = res.getInt(1);
                conn.commit();        
            } catch (PSQLException e) {
                System.out.println("Error al eliminar cliente " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Obtener si el cliente se encuentra en uso a partir del codigo
    public int useCliente(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT use_cliente(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                
                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
    
            } catch (PSQLException e) {
                System.out.println("Error al obtener si el cliente está en uso: " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Activar cliente a partir del código
    public int activarCliente(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = -1;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT activate_cliente(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();
                res.next();
                result = res.getInt(1);
                conn.commit();
            } catch (PSQLException e) {
                System.out.println("Error al activar cliente " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Obtener si el cliente está activo o no
    public int isActivo(String cod) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT activo FROM cliente WHERE cod_cliente=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cod);               

                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
                
            } catch (PSQLException e) {
                System.out.println("Error al comprobar si el cliente es activo" + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
}
