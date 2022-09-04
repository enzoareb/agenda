package dto;

public class TipoContactoDTO {
	private int idTipoContacto;
	private String nombreTipo;

	public TipoContactoDTO(int idTipoContacto, String nombreTipo) {
		this.idTipoContacto = idTipoContacto;
		this.nombreTipo = nombreTipo;

	}

	public int getIdTipoContacto() {
		return idTipoContacto;
	}

	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

}
