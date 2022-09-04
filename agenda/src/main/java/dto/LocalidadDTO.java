package dto;

public class LocalidadDTO {
	private int idLocalidad;
	private String nombre;
	private int idProvincia;
	private int idPais;

	public LocalidadDTO(int idLocalidad, String nombre, int idProvincia, int idPais) {
		this.idLocalidad = idLocalidad;
		this.nombre = nombre;
		this.idProvincia = idProvincia;
		this.idPais = idPais;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
