package entidades;

/**
 *
 * @author Lester
 */
public class Moneda {
    private String siglas;
    private String nombre;

    public Moneda() {
    }

    public Moneda(String siglas, String nombre) {
        this.setSiglas(siglas);
        this.setNombre(nombre);
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

    @Override
    public String toString() {
        return "Moneda{" + "siglas=" + siglas + ", nombre=" + nombre + '}';
    }
    
    
}
