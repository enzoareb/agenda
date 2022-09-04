package dto;

public class DomicilioDTO {
    private int idDomicilio;
    private int idPersona;
    private String calle;
    private String altura;
    private String piso;
    private String depto;
    private int idLocalidad;

    public DomicilioDTO(int idDomicilio, int idPersona, String calle, String altura, String piso, String depto,
            int IdLocalidad) {
        this.idPersona = idPersona;
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.idLocalidad = IdLocalidad;

    }

    public int getidPersona() {
        return idPersona;
    }

    public void setidPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getidDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @Override
    public String toString() {
        return calle + " " + altura;
    }

}
