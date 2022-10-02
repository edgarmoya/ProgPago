package entidades;

import excepciones.FaltanDatosException;
import excepciones.LongitudException;

/**
 *
 * @author Lester
 */
public class TipoFinan {
    
    private String cod_tipo;
    private String descripcion;
    private Byte activo;

    public TipoFinan() {
    }

    public TipoFinan(String cod_tipo, String descripcion) {
        this.setCod_tipo(cod_tipo);
        this.setDescripcion(descripcion);
    }

    public String getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(String cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte getActivo() {
        return activo;
    }

    public void setActivo(Byte activo) {
        this.activo = activo;
    }
    
    // Validar TODO
    public boolean isValido() throws FaltanDatosException, LongitudException {
        // Validar datos no nulos
        if (cod_tipo.isEmpty() || descripcion.isEmpty()) {
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
        if (cod_tipo.length() <= 4 && descripcion.length() <= 100) {
            return true;
        }
        return false;
    } 

    @Override
    public String toString() {
        return "TipoFinan{" + "cod_tipo=" + cod_tipo + ", descripcion=" + descripcion + ", activo=" + activo + '}';
    }
 
}
