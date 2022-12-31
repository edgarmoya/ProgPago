package entidades;

import java.sql.Date;

/**
 *
 * @author Lester
 */
public class Programacion {
    
    private int id_prog;
    private Date fecha;
    private String observacion;
    private Cliente cliente;
    private Ejercicio ejercicio;
    private TipoFinan tipofinan;
    private Moneda moneda;
    private Usuario usuario;
    private byte estado;
    private double importe;

    public Programacion() {
    }

    public Programacion(int id_prog, Date fecha, String observacion, Cliente cliente, Ejercicio ejercicio, TipoFinan tipofinan, Moneda moneda, Usuario usuario, byte estado, double importe) {
        this.id_prog = id_prog;
        this.fecha = fecha;
        this.observacion = observacion;
        this.cliente = cliente;
        this.ejercicio = ejercicio;
        this.tipofinan = tipofinan;
        this.moneda = moneda;
        this.usuario = usuario;
        this.estado = estado;
        this.importe = importe;
    }   

    public int getId_prog() {
        return id_prog;
    }

    public void setId_prog(int id_prog) {
        this.id_prog = id_prog;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public TipoFinan getTipofinan() {
        return tipofinan;
    }

    public void setTipofinan(TipoFinan tipofinan) {
        this.tipofinan = tipofinan;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Programacion{" + "id_prog=" + id_prog + ", fecha=" + fecha + ", observacion=" + observacion + ", cliente=" + cliente + ", ejercicio=" + ejercicio + ", tipofinan=" + tipofinan + ", moneda=" + moneda + ", usuario=" + usuario + ", estado=" + estado + ", importe=" + importe + '}';
    }

}
