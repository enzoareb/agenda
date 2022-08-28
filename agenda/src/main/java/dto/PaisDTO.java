package dto;



public class PaisDTO 
{
	private int idPais;
	private String nombrePais;
	//private int idProvincia;
	//private  int idPais;



	public PaisDTO(int idPais, String nombrePais)
	{
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	//	this.idProvincia = idProvincia;
	//	this.idPais = idPais;
	}


	public int getIdPais() {
		return idPais;
	}


	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}


	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}



	/* 
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
