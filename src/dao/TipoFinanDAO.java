package dao;
import ppago.ConexionPg;
import entidades.TipoFinan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class TipoFinanDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarTipoFinan (TipoFinan tipofinan) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into tipofinan values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipofinan.getCod_tipo());
            stmt.setString(2, tipofinan.getDescripcion());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar tipofinan "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
