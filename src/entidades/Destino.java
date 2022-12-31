package entidades;

import excepciones.FaltanDatosException;
import excepciones.LongitudException;

/**
 *
 * @author Lester
 */
public class Destino {

    private String id_destino;
    private String nombre;
    private byte activo;

    public Destino() {
    }

    public Destino(String id_destino, String nombre, byte activo) {
        this.id_destino = id_destino;
        this.nombre = nombre;
        this.activo = activo;
    }

    public String getId_destino() {
        return id_destino;
    }

    public void setId_destino(String id_destino) {
        this.id_destino = id_destino;
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
        if (id_destino.isEmpty() || nombre.isEmpty()) {
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
        if (id_destino.length() <= 4 && nombre.length() <= 30) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Destino{" + "id_destino=" + id_destino + ", nombre=" + nombre + ", activo=" + activo + '}';
    }

}
