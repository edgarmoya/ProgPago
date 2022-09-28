package entidades;

import java.io.InputStream;

/**
 *
 * @author Edgar Moya
 */
public class Organizacion {
    
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private InputStream logo;
    
    public Organizacion(){
        
    }

    public Organizacion(String codigo, String nombre, String direccion, String telefono, String correo, InputStream logo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.logo = logo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public InputStream getLogo() {
        return logo;
    }

    public void setLogo(InputStream logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Organizacion{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", logo=" + logo + '}';
    }  
    
}
