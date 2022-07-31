package ppago;

import entidades.Tesorero;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JOptionPane;

public class Login {

    //faltaria validar en el login el maximo de caracteres permitidos en la bd, puede que se valide cuando el admin agregar un nuevo usuario
    


    //Método para validar el usuario y contraseña 
    public static boolean validarUser(ConexionPg connPg, Tesorero t) throws SQLException, ConnectionException, FaltanDatosException {
        if (!t.getUsuario().isEmpty() && !t.getContrasenna().isEmpty()) {
            Connection conn = connPg.getConexion();
            if (conn != null) {
                try {
                    //Query para obtener la cantidad de tesoreros donde ese usuario coincida con la contraseña
                    String query = "SELECT COUNT(*) AS cant FROM tesorero WHERE usuario = ? AND contrasenna = crypt(?, contrasenna)";                   
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, t.getUsuario());
                    stmt.setString(2, t.getContrasenna());
                    ResultSet res = stmt.executeQuery();

                    //Comprobar si se ingresa la master password
                    if (t.getUsuario().equals(connPg.getUsuario())
                            && t.getContrasenna().equals(connPg.getPassword())) {
                        //Se cierra la conexion solo cuando es un tesorero  válido
                        //En caso de no serlo no se puede cerrar porque se puede seguir intentando loguear
                        conn.close();
                        return true;
                    }

                    //Comprobar si se encuentra en la tabla tesorero
                    //Si la cantidad es igual a 1 entonces si se ha encontrado
                    res.next();
                    if (res.getInt("cant") == 1) {
                        //Se cierra la conexion solo cuando es un tesorero  válido
                        //En caso de no serlo no se puede cerrar porque se puede seguir intentando loguear
                        conn.close();
                        return true;
                    }

                } catch (Exception e) {
                    //Para en caso de que ocurra una excepcion en la consulta
                    JOptionPane.showMessageDialog(null, "Error al obtener información de la base de datos seleccionada." + e.getMessage());
                }
            } else {
                throw new ConnectionException("No existe una conexión con la base de datos.");
            }
        } else {
            throw new FaltanDatosException("Complete todos los campos antes de continuar.");
        }
        return false;
    }

    /**
     * Método utilizado en la conexión a la base de datos Para validar que la
     * base de datos seleccionada es correcta Se verifica que el nombre de las
     * tablas es el correcto (Se le puede añadir otra validación)
     *
     * @param username
     * @param password
     * @param servidor
     * @param bd
     * @return True si es correcta y False en caso que no lo sea
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static boolean validarBD(String username, String password, String servidor, String bd) throws ClassNotFoundException, SQLException, IOException, ConnectionException, FaltanDatosException {
        List<String> lista = Arrays.asList("rol", "tesorero_rol", "tesorero", "cliente", "programacion", "ejercicio", "tipofinan", "moneda", "destino", "periodo");
        if (!username.isEmpty() && !password.isEmpty() && servidor != null && bd != null) {
            ConexionPg c = new ConexionPg(username, password, servidor, bd);
            Connection conn = c.conectar();

            if (conn != null) {
                try {
                    //Query para obtener el nombre de todas las tablas de la bd seleccionada
                    String query = "SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    ResultSet res = stmt.executeQuery();

                    //Guardar en una lista todas las tablas
                    while (res.next()) {
                        if (!lista.contains(res.getString("table_name"))) {
                            return false;
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al obtener información de la base de datos seleccionada.");
                } finally {
                    conn.close();
                }

                //Se guarda la conexion establecida en un fichero binario
                c.guardar(c);
                return true;
            } else {
                throw new ConnectionException("No existe una conexión con la base de datos.");
            }
        } else {
            throw new FaltanDatosException("Complete todos los campos antes de continuar.");
        }
    }

    //Obtener lista dcon todas las base de datos 
    public static ArrayList<String> getListaBD(String user, String pass, String host) throws SQLException, ClassNotFoundException {
        ConexionPg c = new ConexionPg(user, pass, host, "");
        Connection conn = c.conectar();
        ArrayList<String> lista = new ArrayList<>();

        if (conn != null) {
            try {
                String query = "SELECT datname FROM pg_database";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet res = stmt.executeQuery();

                while (res.next()) {
                    if (!res.getString("datname").equals("template0") && !res.getString("datname").equals("template1")) {
                        lista.add(res.getString("datname"));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener información de la base de datos.");
            } finally {
                conn.close();
            }
        }
        return lista;
    }

    /**
     * @return lista de servidores disponibles
     * @throws UnknownHostException
     * @throws SocketException
     */
    public static ArrayList<String> getServidores() throws UnknownHostException, SocketException {
        ArrayList<String> lista = new ArrayList<>();
        lista.add(getLocalHost());

        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            Enumeration<InetAddress> direcciones = iface.getInetAddresses();

            while (direcciones.hasMoreElements()) {
                InetAddress direccion = direcciones.nextElement();
                if (direccion instanceof Inet4Address && !direccion.isLoopbackAddress()) {
                    String res = direccion.getHostAddress();
                    lista.add(InetAddress.getByName(res).getHostName());
                }
            }
        }
        return lista;
    }

    /**
     * Siempre devuelve localhost
     *
     * @return String con el localhost de la computadora
     */
    public static String getLocalHost() {
        InetAddress local = InetAddress.getLoopbackAddress();
        String localhost = local.getHostName();
        return localhost;
    }

}
