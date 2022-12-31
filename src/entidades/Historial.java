package entidades;

/**
 *
 * @author Edgar Moya
 */
public class Historial {

    private String usuario;
    private String fecha;
    private String operacion;
    
    public Historial(){      
    }

    public Historial(String usuario, String fecha, String operacion) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.operacion = operacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        return "Historial{" + "usuario=" + usuario + ", fecha=" + fecha + ", operacion=" + operacion + '}';
    }

}
