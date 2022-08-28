package dto;



public class LocalidadProvinciaDTO 
{
	private int idLocalidad;
	private String nombre;
	private int idProvincia;
	private  int idPais;
	
	private String nombreProvincia;
	private String nombrePais; 

	public LocalidadProvinciaDTO(int idLocalidad, String nombre, int idProvincia, int idPais, String nombreProvincia,String nombrePais)
	{
		this.idLocalidad = idLocalidad;
		this.nombre = nombre;
		this.idProvincia = idProvincia;
		this.idPais = idPais;
		this.nombreProvincia = nombreProvincia;
		this.nombrePais= nombrePais;
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

	public String getNombreProvincia() {
		return nombreProvincia;
	}


	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	
	public String getNombrePais() {
		return nombrePais;
	}


	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	

	
}
