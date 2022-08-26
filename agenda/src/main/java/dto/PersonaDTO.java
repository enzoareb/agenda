package dto;



public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private DomicilioDTO domicilio;
	private String email;
	private String fechaCumpleaños;
	private int idcontacto;


	public PersonaDTO(int idPersona, String nombre, String telefono,String email, String fechaCumpleaños,int idcontacto)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	
		this.email = email;
		this.fechaCumpleaños= fechaCumpleaños;
		this.idcontacto = idcontacto;
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

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}

	public int getIdcontacto() {
		return idcontacto;
	}

	public void setIdcontacto(int idcontacto) {
		this.idcontacto = idcontacto;
	}


	
	

	
}
