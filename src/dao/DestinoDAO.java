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
            String sql = "insert into destino values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, destino.getId_destino());
            stmt.setDouble(2, destino.getImporte());
            stmt.setString(3, destino.getNombre());
            stmt.setInt(4, destino.getId_prog());
            
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
