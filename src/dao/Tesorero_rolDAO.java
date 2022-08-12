package dao;
import ppago.ConexionPg;
import entidades.Tesorero_rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class Tesorero_rolDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarTesorero_rol (Tesorero_rol tesorero_rol) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into tesorero_rol values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tesorero_rol.getId_rol());
            stmt.setString(2, tesorero_rol.getId_tesorero());
            
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
