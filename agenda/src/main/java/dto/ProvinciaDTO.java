package dto;

public class ProvinciaDTO {
	private int idProvincia;
	private String nombreProvincia;

	public ProvinciaDTO(int idProvincia, String nombreProvincia) {
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;

	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

}
