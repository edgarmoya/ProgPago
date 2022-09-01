package dao;
import ppago.ConexionPg;
import entidades.Usuario_rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class Usuario_rolDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarUsuario_rol (Usuario_rol usuario_rol) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into usuario_rol values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario_rol.getId_rol());
            stmt.setString(2, usuario_rol.getId_usuario());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar tesorero_rol "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
