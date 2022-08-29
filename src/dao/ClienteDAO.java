package dao;
import ppago.ConexionPg;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lester
 */
public class ClienteDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean agregarCliente (Cliente cliente) throws SQLException, ClassNotFoundException {
        
        boolean fueAgregado = false;
        Connection conn = conexion.conectar();
        try{
            String sql = "insert into cliente values (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getCod_cliente());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getNit());
            stmt.setString(4, cliente.getReeup());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getOrganismo());
            stmt.setString(7, cliente.getCorreo());
            stmt.setBoolean(8, cliente.isActivo());
            
            //ejecutamos la sentencia
            int cantidad = stmt.executeUpdate();
            
            fueAgregado = (cantidad > 0);
            
        } catch (Exception e){
            
            System.out.println("Error al agregar cliente "+e.getMessage());
        } finally{
            conn.close();
        }
        
        return fueAgregado;
    }
}
