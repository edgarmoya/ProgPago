package entidades;

/**
 *
 * @author Lester
 */
public class Cliente {
    private String cod_cliente;
    private String nombre;
    private String nid;
    private String reeup;
    private String direccion;
    private String organismo;
    private String correo;
    private boolean activo;

    public Cliente() {
    }

    public Cliente(String cod_cliente, String nombre, String nid, String reeup, String direccion, String organismo, String correo, boolean activo) {
        this.setCod_cliente(cod_cliente);
        this.setNombre(nombre);
        this.setNid(nid);
        this.setReeup(reeup);
        this.setDireccion(direccion);
        this.setOrganismo(organismo);
        this.setCorreo(correo);
        this.setActivo(activo);
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

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getReeup() {
        return reeup;
    }

    public void setReeup(String reeup) {
        this.reeup = reeup;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOrganismo() {
        return organismo;
    }

    public void setOrganismo(String organismo) {
        this.organismo = organismo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cod_cliente=" + cod_cliente + ", nombre=" + nombre + ", nid=" + nid + ", reeup=" + reeup + ", direccion=" + direccion + ", organismo=" + organismo + ", correo=" + correo + ", activo=" + activo + '}';
    }
    
    
}
