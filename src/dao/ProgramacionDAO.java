package dao;
import ppago.ConexionPg;
import entidades.Programacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
/**
 *
 * @author Lester
 */
public class ProgramacionDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarProgramacion (Programacion programacion) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into programacion values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, programacion.getId_prog());
            stmt.setDouble(2, programacion.getImporte());
            stmt.setLocalDateTime(3, programacion.getFecha());
            stmt.setString(4, programacion.getComentario());
            stmt.setString(5, programacion.getId_cliente());
            stmt.setInt(6, programacion.getId_anno());
            stmt.setString(7, programacion.getId_tipo());
            stmt.setString(8, programacion.getId_siglas());
            stmt.setString(9, programacion.getId_usuario());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar programacion "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}