package dao;
import ppago.ConexionPg;
import entidades.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class RolDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarRol (Rol rol) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into rol values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rol.getId_rol());
            stmt.setString(2, rol.getNombre());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar rol "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
