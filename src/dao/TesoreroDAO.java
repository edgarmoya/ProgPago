package dao;
import ppago.ConexionPg;
import entidades.Tesorero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class TesoreroDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarTesorero (Tesorero tesorero) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into tesorero values (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tesorero.getUsuario());
            stmt.setString(2, tesorero.getNombre());
            stmt.setString(3, tesorero.getContrasenna());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar tesorero "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
