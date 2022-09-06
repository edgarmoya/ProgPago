package entidades;

import java.sql.Date;
/**
 *
 * @author Lester
 */
public class Programacion {
    private int id_prog;
    private Date fecha;
    private String comentario;
    private String id_cliente;
    private int id_ejercicio;
    private String id_tipo;
    private String id_siglas;
    private String id_usuario;
    private byte estado;

    public Programacion() {
    }

    public Programacion(int id_prog, Date fecha, String comentario, String id_cliente, int id_ejercicio, String id_tipo, String id_siglas, String id_usuario, byte estado) {
        this.setId_prog(id_prog);
        this.setFecha(fecha);
        this.setComentario(comentario);
        this.setId_cliente(id_cliente);
        this.setId_ejercicio(id_ejercicio);
        this.setId_tipo(id_tipo);
        this.setId_siglas(id_siglas);
        this.setId_usuario(id_usuario);
        this.setEstado(estado);
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_ejercicio() {
        return id_ejercicio;
    }

    public void setId_ejercicio(int id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }

    public String getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(String id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getId_siglas() {
        return id_siglas;
    }

    public void setId_siglas(String id_siglas) {
        this.id_siglas = id_siglas;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Programacion{" + "id_prog=" + id_prog + ", fecha=" + fecha + ", comentario=" + comentario + ", id_cliente=" + id_cliente + ", id_ejercicio=" + id_ejercicio + ", id_tipo=" + id_tipo + ", id_siglas=" + id_siglas + ", id_usuario=" + id_usuario + ", estado=" + estado + '}';
    }
     
}
