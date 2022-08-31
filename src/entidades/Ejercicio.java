package entidades;

/**
 *
 * @author Lester
 */
public class Ejercicio {
    private int cod_ejercicio;
    private String ejercicio;

    public Ejercicio() {
    }

    public Ejercicio(int cod_ejercicio, String ejercicio) {
        this.setCod_ejercicio(cod_ejercicio);
        this.setEjercicio(ejercicio);
    }

    public int getCod_ejercicio() {
        return cod_ejercicio;
    }

    public void setCod_ejercicio(int cod_ejercicio) {
        this.cod_ejercicio = cod_ejercicio;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    @Override
    public String toString() {
        return "Ejercicio{" + "cod_ejercicio=" + cod_ejercicio + ", ejercicio=" + ejercicio + '}';
    }
    
    
}
