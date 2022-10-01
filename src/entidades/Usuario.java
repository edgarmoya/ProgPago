package entidades;

import excepciones.FaltanDatosException;
import excepciones.IdentificadorException;
import excepciones.LongitudException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lester
 */
public class Usuario {
    private String identificador;
    private String nombre;
    private String apellidos;
    private String contrasenna;
    private String roles;
    private byte inicio;
    private byte activo;

    public Usuario() {
    } 

    public Usuario(String identificador, String nombre, String apellidos, String contrasenna, String roles, byte inicio, byte activo) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenna = contrasenna;
        this.roles = roles;
        this.inicio = inicio;
        this.activo = activo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }

    public byte getInicio() {
        return inicio;
    }

    public void setInicio(byte inicio) {
        this.inicio = inicio;
    }  
    
    // Validar TODO
    public boolean isValido() throws FaltanDatosException, LongitudException, IdentificadorException {
        // Validar datos no nulos
        if (identificador.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || contrasenna.isEmpty()) {
            throw new FaltanDatosException("Compruebe los campos requeridos(*) antes de continuar.");
        }
        // Validar longitud
        if (!validLength()) {
            throw new LongitudException("Compruebe la longitud de los campos antes de continuar.");
        }
        // Validar identificador
        if (!validIdentificador(identificador)) {
            throw new IdentificadorException("Compruebe el identificador, solo puede contener punto(.) y guión bajo(_) como caracteres especiales.");
        }
        return true;
    }
    
    // Validar TODO
    public boolean isEditValido() throws FaltanDatosException, LongitudException, IdentificadorException {
        // Validar datos no nulos
        if (identificador.isEmpty() || nombre.isEmpty() || apellidos.isEmpty()) {
            throw new FaltanDatosException("Compruebe los campos requeridos(*) antes de continuar.");
        }
        // Validar longitud
        if (!validLength()) {
            throw new LongitudException("Compruebe la longitud de los campos antes de continuar.");
        }
        // Validar identificador
        if (!validIdentificador(identificador)) {
            throw new IdentificadorException("Compruebe el identificador, solo puede contener punto(.) y guión bajo(_) como caracteres especiales.");
        }
        return true;
    }
    
    // Validar longitud de los campos
    private boolean validLength() {
        if (identificador.length() <= 20 && nombre.length() <= 40 && apellidos.length() <= 40) {
            return true;
        }
        return false;
    }
    
    // Validar el idetificador del usuario
    public boolean validIdentificador(String identificador) {
        Pattern patron = Pattern.compile("^[a-zA-Z0-9]+([_.]?[a-zA-Z0-9])*$");
        Matcher comparar = patron.matcher(identificador);
        return comparar.find();  
    }

    @Override
    public String toString() {
        return "Usuario{" + "identificador=" + identificador + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contrasenna=" + contrasenna + ", inicio=" + inicio + ", activo=" + activo + '}';
    }
     
}

