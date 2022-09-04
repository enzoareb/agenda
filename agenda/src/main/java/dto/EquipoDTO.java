package dto;

public class EquipoDTO {
    private int idEquipo;
    private String nombre;

    public EquipoDTO(int idEquipo, String nombre) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
