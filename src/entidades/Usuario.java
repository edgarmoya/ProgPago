package entidades;

/**
 *
 * @author Lester
 */
public class Usuario {
    private String usuario;
    private String nombre;
    private String contrasenna;
    private byte activo;

    public Usuario() {
    }
    
    public Usuario(String usuario, String contrasenna, byte activo) {
        this.usuario = usuario;
        this.nombre = "";
        this.contrasenna = contrasenna;
        this.activo = activo;
    }

    public Usuario(String usuario, String nombre, String contrasenna, byte activo) {
        this.setUsuario(usuario);
        this.setNombre(nombre);
        this.setContrasenna(contrasenna);
        this.setActivo(activo);
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

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", nombre=" + nombre + ", contrasenna=" + contrasenna + ", activo=" + activo + '}';
    }

    
}

