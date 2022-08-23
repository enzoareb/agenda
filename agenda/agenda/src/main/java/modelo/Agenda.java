package modelo;

import java.util.List;

import dto.DomicilioDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private DomicilioDAO domicilio;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
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

	public void editarPersona(DomicilioDTO domicilio_a_editar)
	{
		this.domicilio.edit(domicilio_a_editar);
	}
	
}
