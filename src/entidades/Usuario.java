package entidades;

/**
 *
 * @author Lester
 */
public class Usuario {
    private String usuario;
    private String nombre;
    private String contrasenna;
    private boolean activo;

    public Usuario() {
    }
    
    public Usuario(String usuario, String contrasenna, boolean activo) {
        this.usuario = usuario;
        this.nombre = "";
        this.contrasenna = contrasenna;
        this.activo = activo;
    }

    public Usuario(String usuario, String nombre, String contrasenna) {
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", nombre=" + nombre + ", contrasenna=" + contrasenna + ", activo=" + activo + '}';
    }

    
}

