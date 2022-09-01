package entidades;

/**
 *
 * @author Lester
 */
public class Usuario_rol {
    private int id_rol;
    private String id_usuario;

    public Usuario_rol() {
    }

    public Usuario_rol(int id_rol, String id_usuario) {
        this.setId_rol(id_rol);
        this.setId_usuario(id_usuario);
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Usuario_rol{" + "id_rol=" + id_rol + ", id_usuario=" + id_usuario + '}';
    }
    
    
}
