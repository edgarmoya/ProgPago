
package entidades;

import java.sql.Date;

/**
 *
 * @author Lester
 */
public class Periodo {
    
    private int id_periodo;
    private String nombre;
    private int id_ejercicio;
    private Date fecha_inicio; 
    private Date fecha_fin; 

    public Periodo() {
    }

    public Periodo(int id_periodo, String nombre, int id_ejercicio, Date fecha_inicio, Date fecha_fin) {
        this.id_periodo = id_periodo;
        this.nombre = nombre;
        this.id_ejercicio = id_ejercicio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
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
    
    @Override
    public String toString() {
        return "Periodo{" + "id_periodo=" + id_periodo + ", nombre=" + nombre + ", id_ejercicio=" + id_ejercicio + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + '}';
    }
   
}
