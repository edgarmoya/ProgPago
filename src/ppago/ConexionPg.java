package ppago;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Edgar Moya
 */
public class ConexionPg implements Serializable {

    private transient Connection conexion;    //transient porque "Connection" no es Serializable
    private String usuario;
    private String password;
    private String bd;
    private String host;
    private String puerto;
    private String url;

    public ConexionPg() {
        usuario = "";
        password = "";
        bd = "";
        host = "";
        puerto = "";
        url = "jdbc:postgresql://" + host + ":" + puerto + "/" + bd;
    }

    public ConexionPg(String u, String pw, String h, String b) {
        usuario = u;
        password = pw;
        host = h;
        bd = b;
        puerto = "5432";
        url = "jdbc:postgresql://" + host + ":" + puerto + "/" + bd;
    }

    public Connection conectar() throws ClassNotFoundException, SQLException {
        String CONTROLADOR_JDBC_POSTGRES = "org.postgresql.Driver";
        Class.forName(CONTROLADOR_JDBC_POSTGRES);
        conexion = DriverManager.getConnection(url, usuario, password);
        return conexion;
    }

    public void guardar(ConexionPg conn) throws IOException {
        ObjectOutputStream fs = new ObjectOutputStream(new FileOutputStream("connection.ppgo"));
        fs.writeObject(conn);
        fs.close();
    }

    //Cargar datos de un fichero binario
    public ConexionPg cargar() throws IOException, ClassNotFoundException {
        ObjectInputStream fs = new ObjectInputStream(new FileInputStream("connection.ppgo"));
        ConexionPg conn = (ConexionPg) fs.readObject();
        fs.close(); 
        
        return conn;
    }
        

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
