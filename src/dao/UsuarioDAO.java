package dao;
import ppago.ConexionPg;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class UsuarioDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarUsuario (Usuario usuario) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert usuario values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getContrasenna());
            stmt.setBoolean(4, usuario.isActivo());
            
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
}
