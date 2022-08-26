package dto;

public class DomicilioDTO {
    private int idDomicilio;
    private int idPersona;
    private String calle;
    private String altura;
    private String piso;
    private String depto;
    private int localidad;
    private String tipocontacto;

    public DomicilioDTO(int idDomicilio,int idPersona,String calle, String altura, String piso, String depto, int localidad,String tipocontacto) {
        this.idPersona = idPersona;
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.localidad = localidad;
        this.tipocontacto = tipocontacto;
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

    public int getLocalidad() {
        return localidad;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return calle+" "+altura;
    }

    public String gettipoContacto() {
        return tipocontacto;
    }

    public void setTipoContacto(String tipocontacto) {
        this.tipocontacto = tipocontacto;
    }

    

}
