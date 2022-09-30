package dao;

import entidades.Organizacion;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.postgresql.util.PSQLException;
import ppago.ConexionPg;

/**
 *
 * @author Edgar Moya
 */
public class OrganizacionDAO {

    private ConexionPg pg = new ConexionPg();

    // Agregar o actualizar organización, dependiendo si existía
    public boolean agregarOrganizacion(Organizacion organizacion, boolean nLogo, int longBytes) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL add_organizacion(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, organizacion.getCodigo());
                stmt.setString(2, organizacion.getNombre());
                stmt.setString(3, organizacion.getDireccion());
                stmt.setString(4, organizacion.getTelefono());
                stmt.setString(5, organizacion.getCorreo());
                stmt.setBoolean(6, nLogo);
                stmt.setBinaryStream(7, organizacion.getLogo(), longBytes);

                // ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                fueAgregado = true;
            } catch (PSQLException ex) {
                System.out.println("Error al agregar organización: " + ex.getServerErrorMessage().getMessage());
                // No ejecutar transacción
                conn.rollback();
                throw new BDException(ex.getServerErrorMessage().getMessage());
            } finally {
                conn.close();
            }
        }
        return fueAgregado;
    }     

    // Obtener datos de la organización guardada
    public Organizacion obtenerOrganizacion() throws SQLException, ClassNotFoundException, ConnectionException, BDException{
        Organizacion o = new Organizacion();
        Connection conn = pg.getConnection();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {          
            try {
                String sql = "SELECT * FROM organizacion LIMIT 1";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {                    
                    o.setCodigo(rs.getString("codigo"));
                    o.setNombre(rs.getString("nombre"));
                    o.setDireccion(rs.getString("direccion"));
                    o.setTelefono(rs.getString("telefono"));
                    o.setCorreo(rs.getString("correo"));
                    o.setLogo(rs.getBinaryStream("logo"));
                }
            } catch (PSQLException ex) {
                System.out.println("Error al obtener datos de la organización: " + ex.getServerErrorMessage().getMessage());
                throw new BDException(ex.getServerErrorMessage().getMessage());  
            }finally {
                conn.close();
            }          
        }
        return o;
    }
        
}
