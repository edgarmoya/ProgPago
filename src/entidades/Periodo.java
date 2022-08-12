
package entidades;

/**
 *
 * @author Lester
 */
public class Periodo {
    private String id_periodo;
    private double importe;
    private String nombre;
    private String id_destino;

    public Periodo() {
    }

    public Periodo(String id_periodo, double importe, String nombre, String id_destino) {
        this.setId_periodo(id_periodo);
        this.setImporte(importe);
        this.setNombre(nombre);
        this.setId_destino(id_destino);
    }

    public String getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(String id_periodo) {
        this.id_periodo = id_periodo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_destino() {
        return id_destino;
    }

    public void setId_destino(String id_destino) {
        this.id_destino = id_destino;
    }

    @Override
    public String toString() {
        return "Periodo{" + "id_periodo=" + id_periodo + ", importe=" + importe + ", nombre=" + nombre + ", id_destino=" + id_destino + '}';
    }
    
    
}
