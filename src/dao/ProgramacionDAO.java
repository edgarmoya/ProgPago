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

    /*
    De esta manera se agregaría el date al postgresql
    Date date = new Date();
    java.sql.Date datesql = new java.sql.Date(date.getTime()); 
     */
    
    
    // Listar todas las programaciones confirmadas de la bd
    public ArrayList<Programacion> listaProgramacionesConfirmadas() throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Programacion> programaciones = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT listar_programacion_confirmada(1::boolean)";
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
                String sql = "SELECT listar_programacion_confirmada(0::boolean)";
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
}
