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
    public Programacion getProgramacion(int codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        Programacion p = new Programacion();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "    ";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, codigo);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    p.setCliente(rs.getString("cliente"));
                    p.setEjercicio(rs.getString("anno"));
                    p.setMoneda(rs.getString("moneda"));
                    p.setTipofinan(rs.getString("tipo"));
                    p.setFecha(rs.getDate("fecha"));
                    p.setObservacion(rs.getString("observacion"));
                }
            } catch (PSQLException e) {
                System.out.println("Error al obtener programación: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return p;
    }
    
    // Actualizar programacion a partir del código
    public int editarProgramacion(int cod, Programacion prog, String[] destinos, String[] importes) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result = 0;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                Array arrayDestinos = conn.createArrayOf("varchar", destinos);
                Array arrayImportes = conn.createArrayOf("numeric", importes);
                String sql = "SELECT edit_programacion(?, ?, ?::id4, ?::siglasd, ?::bit, ?::id4, ?::id4, ?, ?::numeric[],?)";
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
                stmt.setInt(10,cod);

                //ejecutamos la sentencia
                ResultSet res = stmt.executeQuery();

                res.next();
                result = res.getInt(1);
                
            } catch (PSQLException e) {
                System.out.println("Error al actualizar programación " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Eliminar cliente a partir del codigo
    // Si tiene programaciones solo inactivar
   /* public boolean eliminarCliente(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean isDelete = false;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL delete_cliente(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                isDelete = true;
            } catch (PSQLException e) {
                System.out.println("Error al eliminar cliente " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return isDelete;
    }
    
    // Obtener si el cliente se encuentra en uso a partir del codigo
    public int useCliente(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT use_cliente(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);
                
                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
    
            } catch (PSQLException e) {
                System.out.println("Error al obtener si el cliente está en uso: " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());     
            } finally {
                conn.close();
            }
        }
        return result;
    }
    
    // Activar cliente a partir del código
    public boolean activarCliente(String codigo) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        boolean activado;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "CALL activate_cliente(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, codigo);               

                //ejecutamos la sentencia
                stmt.execute();
                conn.commit();
                activado = true;
            } catch (PSQLException e) {
                System.out.println("Error al activar cliente " + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return activado;
    }
    
    // Obtener si el cliente está activo o no
    public int isActivo(String cod) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        int result;
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                // Tratar las instrucciones como bloques
                conn.setAutoCommit(false);
                String sql = "SELECT activo FROM cliente WHERE cod_cliente=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cod);               

                //ejecutamos la sentencia
                ResultSet rs = stmt.executeQuery();
                conn.commit();
                rs.next();
                result = rs.getInt(1);
                
            } catch (PSQLException e) {
                System.out.println("Error al comprobar si el cliente es activo" + e.getMessage());
                conn.rollback();
                throw new BDException(e.getServerErrorMessage().getMessage());             
            } finally {
                conn.close();
            }
        }
        return result;
    }*/
}
