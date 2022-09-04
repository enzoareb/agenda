package dto;

public class DeporteDTO {
    private int idDeporte;
    private String nombre;

    public DeporteDTO(int idDeporte, String nombre) {
        this.idDeporte = idDeporte;
        this.nombre = nombre;
    }

    public int getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        this.idDeporte = idDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
