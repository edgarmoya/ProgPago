package dao;
import ppago.ConexionPg;
import entidades.Destino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class DestinoDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarDestino (Destino destino) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into destino values (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, destino.getId_destino());
            stmt.setString(2, destino.getNombre());
            stmt.setByte(3, destino.getActivo());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar destino "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
