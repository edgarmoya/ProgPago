package entidades;

/**
 *
 * @author Lester
 */
public class Destino {
    private String id_destino;
    private double importe;
    private String nombre;
    private int id_prog;

    public Destino() {
    }

    public Destino(String id_destino, double importe, String nombre, int id_prog) {
        this.setId_destino(id_destino);
        this.setImporte(importe);
        this.setNombre(nombre);
        this.setId_prog(id_prog);
    }

    public String getId_destino() {
        return id_destino;
    }

    public void setId_destino(String id_destino) {
        this.id_destino = id_destino;
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

    public int getId_prog() {
        return id_prog;
    }

    public void setId_prog(int id_prog) {
        this.id_prog = id_prog;
    }

    @Override
    public String toString() {
        return "Destino{" + "id_destino=" + id_destino + ", importe=" + importe + ", nombre=" + nombre + ", id_prog=" + id_prog + '}';
    }
    
    
}
