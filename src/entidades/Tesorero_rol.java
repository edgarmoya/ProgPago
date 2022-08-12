package entidades;

/**
 *
 * @author Lester
 */
public class Tesorero_rol {
    private int id_rol;
    private String id_tesorero;

    public Tesorero_rol() {
    }

    public Tesorero_rol(int id_rol, String id_tesorero) {
        this.setId_rol(id_rol);
        this.setId_tesorero(id_tesorero);
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getId_tesorero() {
        return id_tesorero;
    }

    public void setId_tesorero(String id_tesorero) {
        this.id_tesorero = id_tesorero;
    }

    @Override
    public String toString() {
        return "Tesorero_rol{" + "id_rol=" + id_rol + ", id_tesorero=" + id_tesorero + '}';
    }
    
    
}
