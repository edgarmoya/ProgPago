package dao;

import entidades.Cliente;
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
public class ClienteDAO {

    private ConexionPg pg = new ConexionPg();

    public boolean agregarCliente(Cliente cliente) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean fueAgregado = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,?::bit(1))";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cliente.getCod_cliente());
                stmt.setString(2, cliente.getNombre());
                stmt.setString(3, cliente.getOrganismo());
                stmt.setString(4, cliente.getNit());
                stmt.setString(5, cliente.getReeup());
                stmt.setString(6, cliente.getCorreo());
                stmt.setString(7, cliente.getDireccion());
                stmt.setString(8, cliente.getTelefono());
                stmt.setString(9, "1");

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                fueAgregado = (cantidad > 0);

            } catch (Exception e) {
                System.out.println("Error al agregar cliente " + e.getMessage());
                throw new BDException(e.getMessage());             
            } finally {
                conn.close();
            }
        }
        return fueAgregado;
    }

    // Listar todos los clientes de la bd
    public ArrayList<Cliente> listaClientesActivos() throws SQLException, ClassNotFoundException, ConnectionException {
        Connection conn = pg.getConnection();
        ArrayList<Cliente> clientes = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM cliente WHERE activo='1' ORDER BY cod_cliente";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Cliente c = new Cliente();
                    c.setCod_cliente(rs.getString("cod_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setOrganismo(rs.getString("organismo"));
                    c.setNit(rs.getString("nit"));
                    c.setReeup(c.reeupConGuiones(rs.getString("reeup")));
                    c.setCorreo(rs.getString("correo"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setTelefono(rs.getString("telefono"));
                    clientes.add(c);
                }
            } catch (Exception e) {
                System.out.println("Error al mostrar los clientes activos: " + e.getMessage());
            } finally {
                conn.close();
            }
        }
        return clientes;
    }
}
