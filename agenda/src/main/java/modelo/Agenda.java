package modelo;

import java.util.List;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private DomicilioDAO domicilio;
	private LocalidadDAO localidad;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.domicilio = metodo_persistencia.createDomicilioDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}

	public void editarPersona(PersonaDTO persona_a_editar)
	{
		this.persona.edit(persona_a_editar);
	}

	// Para domicilio
    public void agregarDomicilio(DomicilioDTO nuevoDomicilio) {
		this.domicilio.insert(nuevoDomicilio);
    }

	public void borrarDomicilio(DomicilioDTO domicilio_a_eliminar) 
	{
		this.domicilio.delete(domicilio_a_eliminar);
	}
	
	public List<DomicilioDTO> obtenerDomicilio()
	{
		return this.domicilio.readAll();		
	}

	public void editarDomicilio(DomicilioDTO domicilio_a_editar)
	{
		this.domicilio.edit(domicilio_a_editar);
	}

	// Localidad
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.localidad.delete(localidad_a_eliminar);
	}
	
	public List<LocalidadDTO> obtenerLocalidad()
	{
		return this.localidad.readAll();		
	}

	public void editarLocalidad(LocalidadDTO localidad_a_editar)
	{
		this.localidad.edit(localidad_a_editar);
	}
	
}
