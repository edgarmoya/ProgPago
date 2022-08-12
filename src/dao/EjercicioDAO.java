package dao;
import ppago.ConexionPg;
import entidades.Ejercicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class EjercicioDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarEjercicio (Ejercicio ejercicio) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into ejercicio values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ejercicio.getAnno());
            stmt.setString(2, ejercicio.getDescripcion());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar ejercicio "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
