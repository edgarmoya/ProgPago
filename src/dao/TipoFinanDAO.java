package dao;

import entidades.TipoFinan;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ppago.ConexionPg;
/**
 *
 * @author Lester
 */
public class TipoFinanDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    public boolean agregarTipoFinan (TipoFinan tipofinan) throws SQLException, ClassNotFoundException, ConnectionException, BDException {      
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try{
                String sql = "INSERT INTO tipofinan VALUES (?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, tipofinan.getCod_tipo());
                stmt.setString(2, tipofinan.getDescripcion());

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                fueAgregado = (cantidad > 0);

            } catch (Exception e){

                System.out.println("Error al agregar tipo de financiamiento "+e.getMessage());
                throw new BDException(e.getMessage());
            } finally{
                conn.close();
            }
        }
        return fueAgregado;
    }
    
    // Listar todos los tipos de financiamiento de la bd
    public ArrayList<TipoFinan> listaTipoFinans() throws SQLException, ClassNotFoundException, ConnectionException {
        Connection conn = pg.getConnection();
        ArrayList<TipoFinan> tipofinans = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM tipofinan ORDER BY cod_tipo";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    TipoFinan tf = new TipoFinan();
                    tf.setCod_tipo(rs.getString("cod_tipo"));
                    tf.setDescripcion(rs.getString("descripcion"));
                    tipofinans.add(tf);
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar los tipos de financiamientos: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return tipofinans;
    }
}
