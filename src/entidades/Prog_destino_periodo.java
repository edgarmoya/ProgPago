package entidades;

/**
 *
 * @author Lester
 */
public class Prog_destino_periodo {
    private int id_prog;
    private String id_destino;
    private int id_periodo;
    private double importe;

    public Prog_destino_periodo() {
    }

    public Prog_destino_periodo(int id_prog, String id_destino, int id_periodo, double importe) {
        this.setId_prog(id_prog);
        this.setId_destino(id_destino);
        this.setId_periodo(id_periodo);
        this.setImporte(importe);
    }

    public int getId_prog() {
        return id_prog;
    }

    public void setId_prog(int id_prog) {
        this.id_prog = id_prog;
    }

    public String getId_destino() {
        return id_destino;
    }

    public void setId_destino(String id_destino) {
        this.id_destino = id_destino;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Prog_destino_periodo{" + "id_prog=" + id_prog + ", id_destino=" + id_destino + ", id_periodo=" + id_periodo + ", importe=" + importe + '}';
    }
    
    
}
