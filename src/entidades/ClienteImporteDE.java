
package entidades;

/**
 *
 * @author Lester
 */
public class ClienteImporteDE {
    
    private String cod_cliente;
    private String nombre;
    private double importe;

    public ClienteImporteDE() {
    }

    public ClienteImporteDE(String cod_cliente, String nombre, double importe) {
        this.cod_cliente = cod_cliente;
        this.nombre = nombre;
        this.importe = importe;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
