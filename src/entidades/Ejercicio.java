package entidades;

import excepciones.FaltanDatosException;
import excepciones.LongitudException;
import java.sql.Date;

/**
 *
 * @author Lester
 */
public class Ejercicio {
    
    private int cod_ejercicio;
    private String ejercicio;
    private Date fecha_inicio; 
    private Date fecha_fin; 

    public Ejercicio() {
    }

    public Ejercicio(int cod_ejercicio, String ejercicio, Date fecha_inicio, Date fecha_fin) {
        this.cod_ejercicio = cod_ejercicio;
        this.ejercicio = ejercicio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
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
    
    // Validar TODO
    public boolean isValido() throws FaltanDatosException, LongitudException {
        // Validar datos no nulos
        if (ejercicio.isEmpty()) {
            throw new FaltanDatosException("Compruebe los campos requeridos(*) antes de continuar.");
        }
        // Validar longitud
        if (!validLength()) {
            throw new LongitudException("Compruebe la longitud de los campos antes de continuar.");
        }

        return true;
    }

    // Validar longitud de los campos
    private boolean validLength() {
        if (ejercicio.length() <= 4) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ejercicio{" + "cod_ejercicio=" + cod_ejercicio + ", ejercicio=" + ejercicio + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + '}';
    }
    
}
