package entidades;

/**
 *
 * @author Lester
 */
public class TipoFinan {
    private String cod_tipo;
    private String descripcion;

    public TipoFinan() {
    }

    public TipoFinan(String cod_tipo, String descripcion) {
        this.setCod_tipo(cod_tipo);
        this.setDescripcion(descripcion);
    }

    public String getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(String cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoFinan{" + "cod_tipo=" + cod_tipo + ", descripcion=" + descripcion + '}';
    }
    
    
}
