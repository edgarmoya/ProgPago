package dao;
import ppago.ConexionPg;
import entidades.Programacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            stmt.setDate(2, programacion.getFecha());
            stmt.setString(3, programacion.getComentario());
            stmt.setString(4, programacion.getId_cliente());
            stmt.setInt(5, programacion.getId_ejercicio());
            stmt.setString(6, programacion.getId_tipo());
            stmt.setString(7, programacion.getId_siglas());
            stmt.setString(8, programacion.getId_usuario());
            stmt.setBoolean(9, programacion.isEstado());
            
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
    
    /*
    De esta manera se agregaría el date al postgresql
    Date date = new Date();
    java.sql.Date datesql = new java.sql.Date(date.getTime()); 
    */    
}
