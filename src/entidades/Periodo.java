package entidades;

import java.sql.Date;

/**
 *
 * @author Lester
 */
public class Periodo {
    
    private int id_periodo;
    private String nombre;
    private Date fecha_inicio; 
    private Date fecha_fin; 
    private double importe;

    public Periodo() {
    }

    public Periodo(int id_periodo, String nombre, Date fecha_inicio, Date fecha_fin, double importe) {
        this.id_periodo = id_periodo;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.importe = importe;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Periodo{" + "id_periodo=" + id_periodo + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", importe=" + importe + '}';
    }
      
}
