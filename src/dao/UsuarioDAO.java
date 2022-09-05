package dao;

import entidades.Usuario;
import excepciones.ConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ppago.ConexionPg;

/**
 *
 * @author Lester
 */
public class UsuarioDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    public boolean agregarUsuario (Usuario usuario) throws SQLException, ClassNotFoundException {  
        boolean fueAgregado = false;
        Connection conn = pg.getConnection();
        try{
            String sql = "INSERT INTO usuario VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getContrasenna());
            stmt.setByte(4, usuario.getActivo());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar usuario "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
    
    /**
     * Obtener un usuario con el nombre y apellidos para mostrar en el Header
     * @param username usuario a buscar
     * @return datos del usuario 
     * @throws ConnectionException
     * @throws SQLException 
     */
    public Usuario getNomb_Apell(String username) throws ConnectionException, SQLException{
        Usuario u = new Usuario();
        Connection conn = pg.getConnection();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT nombre, apellidos FROM usuario WHERE usuario=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if(rs.next()){
                    u.setUsuario(username);
                    u.setNombre(rs.getString("nombre"));
                    u.setApellidos(rs.getString("apellidos"));
                }else{
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
    
    public boolean updatePassword(String username, String pass_actual, String pass_nueva) throws ConnectionException, SQLException{
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
                if(rs.next()){                   
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
}
