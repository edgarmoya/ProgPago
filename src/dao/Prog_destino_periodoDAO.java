package dao;
import ppago.ConexionPg;
import entidades.Prog_destino_periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class Prog_destino_periodoDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarProg_destino_periodo (Prog_destino_periodo prog_destino_periodo) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into prog_destino_periodo values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, prog_destino_periodo.getId_prog());
            stmt.setString(2, prog_destino_periodo.getId_destino());
            stmt.setInt(3, prog_destino_periodo.getId_periodo());
            stmt.setDouble(4, prog_destino_periodo.getImporte());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar prog_destino_periodo "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
