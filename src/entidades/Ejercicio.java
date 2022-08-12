package entidades;

/**
 *
 * @author Lester
 */
public class Ejercicio {
    private int anno;
    private String descripcion;

    public Ejercicio() {
    }

    public Ejercicio(int anno, String descripcion) {
        this.setAnno(anno);
        this.setDescripcion(descripcion);
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Ejercicio{" + "anno=" + anno + ", descripcion=" + descripcion + '}';
    }
    
    
}
