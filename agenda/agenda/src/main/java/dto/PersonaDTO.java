package dto;



public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	//private Domicilio domicilio;
	private String email;
	private String fechaCumpleaños;

	public PersonaDTO(int idPersona, String nombre, String telefono,String email, String fechaCumpleaños)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	//	this.domicilio = domicilio;
		this.email = email;
		this.fechaCumpleaños= fechaCumpleaños;
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaCumpleaños() {
		return fechaCumpleaños;
	}

	public void setFechaCumpleaños(String fechaCumpleaños) {
		this.fechaCumpleaños = fechaCumpleaños;
	}

	

	
}
