package dto;

public class Domicilio {
    private int idPersona;
    private String calle;
    private String altura;
    private String piso;
    private String depto;
    private String localidad;

    public Domicilio(int idPersona,String calle, String altura, String piso, String depto, String localidad) {
        this.idPersona = idPersona;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.localidad = localidad;
    }

    public int getidPersona() {
        return idPersona;
    }

    public void setidPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    

}
