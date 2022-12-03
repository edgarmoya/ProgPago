package dao;

import ppago.ConexionPg;
import entidades.Programacion;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;

/**
 *
 * @author Lester
 */
public class ProgramacionDAO {

    private ConexionPg pg = new ConexionPg();

    // agregar programación
    public int agregarProgramacion(Programacion prog, String[] destinos, String[] importes) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        int result = -1;
        Connection conn = pg.getConnection();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                Array arrayDestinos = conn.createArrayOf("varchar", destinos);
                Array arrayImportes = conn.createArrayOf("numeric", importes);

                String sql = "SELECT add_programacion(?, ?, ?::id4, ?::siglasd, ?::bit, ?::id4, ?::id4, ?, ?::numeric[])";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDate(1, prog.getFecha());
                stmt.setString(2, prog.getObservacion());
                stmt.setString(3, prog.getTipofinan());
                stmt.setString(4, prog.getMoneda());
                stmt.setString(5, "0");
                stmt.setString(6, prog.getCliente());
                stmt.setString(7, prog.getEjercicio());
                stmt.setArray(8, arrayDestinos);
                stmt.setArray(9, arrayImportes);

                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();

                res.next();
                result = res.getInt(1);
            } catch (PSQLException e) {
                System.out.println("Error al agregar programación: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());
            } finally {
                conn.close();
            }
        }
        return result;
    }   
    
    // Listar todas las programaciones confirmadas de la bd
    public ArrayList<Programacion> listaProgramacionesConfirmadas() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Programacion> programaciones = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM listar_programacion_confirmada(1::boolean)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Programacion p = new Programacion();
                    p.setId_prog(rs.getInt("id_prog"));
                    p.setEjercicio(rs.getString("anno"));
                    p.setTipofinan(rs.getString("tipo"));
                    p.setCliente(rs.getString("cliente"));
                    p.setMoneda(rs.getString("moneda"));
                    p.setImporte(rs.getDouble("importe"));
                    p.setEstado(rs.getByte("estado"));
                    programaciones.add(p);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar las programaciones confirmadas: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return programaciones;
    }
    
    // Listar TODAS las programaciones de la bd
    public ArrayList<Programacion> listaTodasProgramaciones() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Programacion> programaciones = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM listar_programacion_confirmada(0::boolean)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                   //Preparar los datos
                    Programacion p = new Programacion();
                    p.setId_prog(rs.getInt("id_prog"));
                    p.setEjercicio(rs.getString("anno"));
                    p.setTipofinan(rs.getString("tipo"));
                    p.setCliente(rs.getString("cliente"));
                    p.setMoneda(rs.getString("moneda"));
                    p.setImporte(rs.getDouble("importe"));
                    p.setEstado(rs.getByte("estado"));
                    programaciones.add(p);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar todas las programaciones: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return programaciones;
    }
    
    // Obtener datos de la programacion a partir del código
    /*public Programacion getProgramacion(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        Programacion p = new Programacion();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM cliente WHERE cod_cliente = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    c.setCod_cliente(rs.getString("cod_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setOrganismo(rs.getString("organismo"));
                    c.setNit(rs.getString("nit"));
                    c.setReeup(c.reeupConGuiones(rs.getString("reeup")));
                    c.setCorreo(rs.getString("correo"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setTelefono(rs.getString("telefono"));
                }
            } catch (PSQLException e) {
                System.out.println("Error al obtener cliente: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return c;
    }
    
    // Actualizar cliente a partir del código
    public boolean editarProgramacion(String cod, Programacion prog, String[] destinos, String[] importes) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isUpdate = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "UPDATE cliente SET cod_cliente=? ,nombre=?, organismo=?, nit=?, reeup=?, correo=?, direccion=?, telefono=? WHERE cod_cliente=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cliente.getCod_cliente());
                stmt.setString(2, cliente.getNombre());
                stmt.setString(3, cliente.getOrganismo());
                stmt.setString(4, cliente.getNit());
                stmt.setString(5, cliente.getReeup());
                stmt.setString(6, cliente.getCorreo());
                stmt.setString(7, cliente.getDireccion());
                stmt.setString(8, cliente.getTelefono());
                stmt.setString(9, cod);

                //ejecutamos la sentencia
                int cantidad = stmt.executeUpdate();
                isUpdate = (cantidad > 0);

            } catch (PSQLException e) {
                System.out.println("Error al actualizar cliente " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isUpdate;
    }*/
}
