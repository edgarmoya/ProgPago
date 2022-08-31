package entidades;

/**
 *
 * @author Lester
 */
public class Destino {
    private String id_destino;
    private String nombre;
    private boolean activo;

    public Destino() {
    }

    public Destino(String id_destino, String nombre) {
        this.setId_destino(id_destino);
        this.setNombre(nombre);
        this.setActivo(activo);
    }

    public String getId_destino() {
        return id_destino;
    }

    public void setId_destino(String id_destino) {
        this.id_destino = id_destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Destino{" + "id_destino=" + id_destino + ", nombre=" + nombre + ", activo=" + activo + '}';
    }

}
