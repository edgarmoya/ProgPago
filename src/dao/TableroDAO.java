package dao;

import entidades.Destino;
import entidades.Periodo;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;
import ppago.ConexionPg;

/**
 *
 * @author Edgar Moya
 */
public class TableroDAO {
    
    private ConexionPg pg = new ConexionPg();
    
    // retornar una lista con los destinos dado un cliente y un ejercicio
    public ArrayList<Destino> progXcliente(String cliente, String ejercicio) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Destino> destinos = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * from progxcliente(?::id4, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);             
                stmt.setString(1, cliente);
                stmt.setString(2, ejercicio);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Destino d = new Destino();
                    d.setId_destino(rs.getString(1));
                    d.setNombre(rs.getString(2));
                    destinos.add(d);
                }
            } catch (PSQLException e) {
                System.out.println("Error al obtener los destinos: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return destinos;
    }
    
    
    // retornar una lista con los periodos y el importe dado un cliente, un ejercicio y un destino
    public ArrayList<Periodo> progXcliente_desglose(String cliente, String ejercicio, String destino) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Periodo> periodos = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * from progxcliente_desglose(?::id4, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);             
                stmt.setString(1, cliente);
                stmt.setString(2, ejercicio);
                stmt.setString(3, destino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Periodo p = new Periodo();
                    p.setNombre(rs.getString(1));
                    p.setImporte(rs.getDouble(2));
                    periodos.add(p);
                }
            } catch (PSQLException e) {
                System.out.println("Error al obtener los desgloses: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return periodos;
    }

}
