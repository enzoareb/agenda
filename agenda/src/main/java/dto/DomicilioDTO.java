package dto;

public class DomicilioDTO {
    private int idDomicilio;
    private String calle;
    private String altura;
    private String piso;
    private String depto;
 //   private String localidad;

    public DomicilioDTO(int idDomicilio,String calle, String altura, String piso, String depto) {
     
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
      //  this.localidad = localidad;
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

    @Override
    public String toString() {
        return calle+" "+altura;
    }

    

    

}
