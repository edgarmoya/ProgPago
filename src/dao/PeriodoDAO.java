package dao;
import ppago.ConexionPg;
import entidades.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class PeriodoDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarPeriodo (Periodo periodo) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into periodo values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, periodo.getId_periodo());
            stmt.setDouble(2, periodo.getImporte());
            stmt.setString(3, periodo.getNombre());
            stmt.setString(4, periodo.getId_destino());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar periodo "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
