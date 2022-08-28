package dto;



public class ProvinciaDTO 
{
	private int idProvincia;
	private String nombreProvincia;
	//private int idProvincia;
	//private  int idPais;


	public ProvinciaDTO(int idProvincia, String nombreProvincia)
	{
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
	//	this.idProvincia = idProvincia;
	//	this.idPais = idPais;
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

/* 
	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	
	public int getIdLocalidad() 
	{
		return this.idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) 
	{
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	*/
	

	
}
