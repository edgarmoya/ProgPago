package entidades;

/**
 * @author Edgar Moya
 */
public class Tesorero {
    
    String usuario;
    String nombre;
    String contrasenna;

    public Tesorero(String usuario, String nombre, String contrasenna) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasenna = contrasenna;
    }

    public Tesorero(String usuario, String contrasenna) {
        this.usuario = usuario;
        this.nombre = "";
        this.contrasenna = contrasenna;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
    
    
}
