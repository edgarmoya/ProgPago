package entidades;

import excepciones.CorreoException;
import excepciones.FaltanDatosException;
import excepciones.LongitudException;
import java.io.InputStream;
import java.io.Serializable;
import utiles.CorreoUtil;

/**
 *
 * @author Edgar Moya
 */
public class Organizacion implements Serializable {
    
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private transient InputStream logo;
    
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
    
    // Validar TODO
    public boolean isValido() throws FaltanDatosException, LongitudException, CorreoException {
        // Validar datos no nulos
        if (codigo.isEmpty() || nombre.isEmpty()) {
            throw new FaltanDatosException("Compruebe los campos requeridos(*) antes de continuar.");
        }
        // Validar longitud
        if (!validLength()) {
            throw new LongitudException("Compruebe la longitud de los campos antes de continuar.");
        }      
        // Validar correo
        if (!CorreoUtil.isCorreo(correo)) {
            throw new CorreoException("Correo electrónico no válido, verifique antes de continuar.");
        }

        return true;
    }
    
    
    // Validar longitud de los campos
    private boolean validLength() {
        if (codigo.length() <= 4 && nombre.length() <= 50 && direccion.length() <= 100
                && telefono.length() <= 15 && correo.length() <= 50) {
            return true;
        }
        return false;
    }
}
