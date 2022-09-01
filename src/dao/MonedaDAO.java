package dao;
import ppago.ConexionPg;
import entidades.Moneda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class MonedaDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarMoneda (Moneda moneda) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into moneda values (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, moneda.getSiglas());
            stmt.setString(2, moneda.getNombre());
             stmt.setByte(3, moneda.getActivo());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar moneda "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
