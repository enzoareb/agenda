package dto;



public class PersonaDomicilioDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String email;
	private String fechaCumpleaños;
	private int iddireccion;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private int idlocalidad;
	private String localidad;
	private String deporte;
	private String equipo;

	private String tipocontacto;




	//public PersonaDomicilioDTO(int idPersona, String nombre, String telefono,String email, String fechaCumpleaños, int iddireccion, String calle, String altura, String piso, String depto, String localidad)
	public PersonaDomicilioDTO(int idPersona, String nombre, String telefono,String email, String fechaCumpleaños, String calle, String altura, String piso, String depto, String localidad,String tipocontacto,String deporte,String equipo)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechaCumpleaños= fechaCumpleaños;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.localidad = localidad;
		this.tipocontacto = tipocontacto;
		this.deporte = deporte;
		this.equipo = equipo;
	
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

	public int getIdDireccion() 
	{
		return this.iddireccion;
	}

	public void setIdDomicilio(int iddireccion) 
	{
		this.iddireccion = iddireccion;
	}

	public String getCalle() 
	{
		return this.calle;
	}

	public void setCalle(String calle) 
	{
		this.calle = calle;
	}

	public String getAltura() 
	{
		return this.altura;
	}

	public void setAltura(String altura) 
	{
		this.altura = altura;
	}

	public String getPiso() 
	{
		return this.piso;
	}

	public void setPiso(String piso) 
	{
		this.piso = piso;
	}

	public String getDepto() 
	{
		return this.depto;
	}

	public void setDepto(String depto) 
	{
		this.depto = depto;
	}


	
	public int getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}


	public String getTipocontacto() {
		return tipocontacto;
	}

	public void setTipocontacto(String tipocontacto) {
		this.tipocontacto = tipocontacto;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	

	
}
