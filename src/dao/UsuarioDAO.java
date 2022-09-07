package dao;

import entidades.Usuario;
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
public class UsuarioDAO {

    private ConexionPg pg = new ConexionPg();

    public boolean agregarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {               
                String sql = "INSERT INTO usuario VALUES(?, ?, ?, crypt(?, gen_salt('md5')), ?::bit(1), ?::bit(1))";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getIdentificador());
                stmt.setString(2, usuario.getNombre());
                stmt.setString(3, usuario.getApellidos());
                stmt.setString(4, usuario.getContrasenna());
                stmt.setString(5, "0");
                stmt.setString(6, "1");

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                fueAgregado = (cantidad > 0);

            } catch (Exception e) {
                System.out.println("Error al agregar usuario " + e.getMessage());
                throw new BDException(e.getMessage());   
            } finally {
                conn.close();
            }
        }
        return fueAgregado;
    }

    /**
     * Obtener un usuario con el nombre y apellidos para mostrar en el Header
     *
     * @param username usuario a buscar
     * @return datos del usuario
     * @throws ConnectionException
     * @throws SQLException
     */
    public Usuario getNomb_Apell(String username) throws ConnectionException, SQLException {
        Usuario u = new Usuario();
        Connection conn = pg.getConnection();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT nombre, apellidos FROM usuario WHERE identificador=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    u.setIdentificador(username);
                    u.setNombre(rs.getString("nombre"));
                    u.setApellidos(rs.getString("apellidos"));
                } else {
                    // Si no es un usuario, es el administrador
                    u.setNombre("Administrador");
                    u.setApellidos(username);
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
                System.out.println("Error actualizar contraseña del usuario: " + e.getMessage());
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
                String sql = "SELECT * FROM public.lista_usuarios_activos()";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Usuario u = new Usuario();
                    u.setIdentificador(rs.getString("identificador"));
                    u.setNombre(rs.getString("nombre"));
                    // se guarda los roles en los apellidos temporalmente para mostrarlo
                    u.setApellidos(rs.getString("roles"));
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
}
