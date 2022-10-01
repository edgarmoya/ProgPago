package dao;

import entidades.Cliente;
import entidades.Usuario;
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
public class UsuarioDAO {

    private ConexionPg pg = new ConexionPg();

    public boolean agregarUsuario(Usuario usuario, boolean admin, boolean tesorero, boolean consultor) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {   
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL add_usuario(?, ?, ?, ?, ?::bit(1), ?::bit(1), ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);              
                stmt.setString(1, usuario.getIdentificador());
                stmt.setString(2, usuario.getNombre());
                stmt.setString(3, usuario.getApellidos());
                stmt.setString(4, usuario.getContrasenna());
                stmt.setString(5, "0");  // al crearse nunca a iniciado
                stmt.setString(6, "1");  // al crearse es siempre activo
                stmt.setBoolean(7, admin);
                stmt.setBoolean(8, tesorero);
                stmt.setBoolean(9, consultor);

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                fueAgregado = true;
            } catch (PSQLException e) {
                System.out.println("Error al agregar usuario: " + e.getServerErrorMessage().getMessage());
                // No ejecutar transacción
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return fueAgregado;
    }

    /**
     * Obtener un usuario con el nombre y apellidos para mostrar en el Header
     * Se obtiene también los roles del usuario
     * @param username usuario a buscar
     * @return datos del usuario
     * @throws ConnectionException
     * @throws SQLException
     */
    public Usuario getNomb_Apell_Roles(String username) throws ConnectionException, SQLException {
        Usuario u = new Usuario();
        Connection conn = pg.getConnection();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM getNombApellRoles(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    u.setIdentificador(username);
                    u.setNombre(rs.getString("nombre"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setRoles(rs.getString("roles"));
                }

            } catch (Exception e) {
                System.out.println("Error al obtener datos del usuario: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return u;
    }

    // Actualizar contraseña
    public boolean updatePassword(String username, String pass_actual, String pass_nueva) throws ConnectionException, SQLException {
        boolean update = false;
        Connection conn = pg.getConnection();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT public.cambiar_contrasena(?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, pass_actual);
                stmt.setString(3, pass_nueva);

                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                int result = 0;
                if (rs.next()) {
                    result = (rs.getInt("cambiar_contrasena"));
                }
                update = (result == 1);
            } catch (Exception e) {
                System.out.println("Error al actualizar contraseña del usuario: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return update;
    }

    // Listar todos los usuarios activos de la bd
    public ArrayList<Usuario> listaUsuariosActivos() throws SQLException, ClassNotFoundException, ConnectionException {
        Connection conn = pg.getConnection();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM lista_usuarios_activos()";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Usuario u = new Usuario();
                    u.setIdentificador(rs.getString("identificador"));
                    u.setNombre(rs.getString("nombre"));
                    u.setRoles(rs.getString("roles"));
                    usuarios.add(u);
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar los usuarios activos: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return usuarios;
    }
    
    // Obtener datos del usuario a partir del identificador
    public Usuario getUsuario(String identificador) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        Usuario u = new Usuario();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM get_usuario(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, identificador);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    u.setIdentificador(rs.getString("identificador"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setRoles(rs.getString("roles"));                  
                }
            } catch (Exception e) {
                System.out.println("Error al obtener usuario: " + e.getMessage());
                throw new BDException(e.getMessage());     
            } finally {
                conn.close();
            }
        }
        return u;
    }
    
    // Actualizar usuario a partir del identificador
    public boolean editarUsuario(Usuario usuario, boolean admin, boolean tesorero, boolean consultor) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isUpdate = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL edit_usuario(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getIdentificador());
                stmt.setString(2, usuario.getNombre());
                stmt.setString(3, usuario.getApellidos());
                stmt.setString(4, usuario.getContrasenna());
                stmt.setBoolean(5, admin);
                stmt.setBoolean(6, tesorero);
                stmt.setBoolean(7, consultor);

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                isUpdate = true;

            } catch (PSQLException e) {
                System.out.println("Error al actualizar usuario " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isUpdate;
    }
}
