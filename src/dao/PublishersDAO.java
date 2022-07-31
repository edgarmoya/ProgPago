package dao;

import entidades.Publishers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ppago.ConexionPg;

 /**
 * @author Edgar Moya
 */
public class PublishersDAO {
    private ConexionPg conexion = new ConexionPg();
    
    public boolean addPublisher(Publishers p) throws SQLException, ClassNotFoundException{
        boolean add = false;
        Connection conn = conexion.conectar();
        
        try {
            String query = "insert into publishers values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, p.getPub_id());
            stmt.setString(2, p.getPub_name());
            stmt.setString(3, p.getCity());
            stmt.setString(4, p.getState());
            stmt.setString(5, p.getCountry());
            stmt.setString(6, p.getTrial780());
            
            int cant = stmt.executeUpdate();
            add = (cant > 0);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: "+e.getMessage());
        }finally{
            conn.close();
        }
        
        return add;
    }
}
