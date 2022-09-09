package entidades;

import excepciones.FaltanDatosException;
import excepciones.LongitudException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lester
 */
public class Moneda {
    private String siglas;
    private String nombre;
    private byte activo;

    public Moneda() {
    }

    public Moneda(String siglas, String nombre, byte activo) {
        this.setSiglas(siglas);
        this.setNombre(nombre);
        this.setActivo(activo);
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }
    
    // Validar TODO
    public boolean isValido() throws FaltanDatosException, LongitudException {
        // Validar datos no nulos
        if (siglas.isEmpty() || nombre.isEmpty()) {
            throw new FaltanDatosException("Compruebe los campos requeridos(*) antes de continuar.");
        }
        // Validar longitud
        if (!validLength()) {
            throw new LongitudException("Compruebe la longitud de los campos antes de continuar.");
        }

        return true;
    }

    // Validar longitud de los campos
    private boolean validLength() {
        if (siglas.length() == 3 && nombre.length() <= 30) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Moneda{" + "siglas=" + siglas + ", nombre=" + nombre + ", activo=" + activo + '}';
    }
  
}
