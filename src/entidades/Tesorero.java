package entidades;

/**
 *
 * @author Lester
 */
public class Tesorero {
    private String usuario;
    private String nombre;
    private String contrasenna;

    public Tesorero() {
    }
    
    public Tesorero(String usuario, String contrasenna) {
        this.usuario = usuario;
        this.nombre = "";
        this.contrasenna = contrasenna;
    }

    public Tesorero(String usuario, String nombre, String contrasenna) {
        this.setUsuario(usuario);
        this.setNombre(nombre);
        this.setContrasenna(contrasenna);
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

    @Override
    public String toString() {
        return "Tesorero{" + "usuario=" + usuario + ", nombre=" + nombre + ", contrasenna=" + contrasenna + '}';
    }
    
    
}

