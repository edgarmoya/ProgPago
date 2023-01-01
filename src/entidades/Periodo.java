package entidades;

import java.sql.Date;

/**
 *
 * @author Lester
 */
public class Periodo {
    
    private String nombre;
    private Date fecha_inicio; 
    private Date fecha_fin; 
    private double importe;
    private double acumulado;

    public Periodo() {
    }

    public Periodo(String nombre, Date fecha_inicio, Date fecha_fin, double importe, double acumulado) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.importe = importe;
        this.acumulado = acumulado;
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

    public double getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(double acumulado) {
        this.acumulado = acumulado;
    }

    @Override
    public String toString() {
        return "Periodo{" + "nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", importe=" + importe + '}';
    }
      
}
