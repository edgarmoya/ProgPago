package entidades;

import excepciones.FaltanDatosException;
import excepciones.LongitudException;

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
    
    // Validar TODO
    public boolean isValido() throws FaltanDatosException, LongitudException {
        // Validar datos no nulos
        String p = ""+cod_ejercicio;
        if (p.isEmpty() || ejercicio.isEmpty()) {
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
        if (cod_ejercicio <= 1000 && ejercicio.length() <= 30) {
            return true;
        }
        return false;
    }
  

    @Override
    public String toString() {
        return "Ejercicio{" + "cod_ejercicio=" + cod_ejercicio + ", ejercicio=" + ejercicio + '}';
    }
    
    
}
