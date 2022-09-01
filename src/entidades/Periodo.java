
package entidades;

/**
 *
 * @author Lester
 */
public class Periodo {
    private int id_periodo;
    private String nombre;
    private int id_ejercicio;

    public Periodo() {
    }

    public Periodo(int id_periodo, String nombre, int id_ejercicio) {
        this.setId_periodo(id_periodo);
        this.setNombre(nombre);
        this.setId_ejercicio(id_ejercicio);
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_ejercicio() {
        return id_ejercicio;
    }

    public void setId_ejercicio(int id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }

    @Override
    public String toString() {
        return "Periodo{" + "id_periodo=" + id_periodo + ", nombre=" + nombre + ", id_ejercicio=" + id_ejercicio + '}';
    }
    
}
