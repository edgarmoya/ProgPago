package entidades;

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

    @Override
    public String toString() {
        return "Moneda{" + "siglas=" + siglas + ", nombre=" + nombre + ", activo=" + activo + '}';
    }
  
}
