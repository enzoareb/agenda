package modelo;

import java.util.List;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.PersonaDomicilioDAO;
import persistencia.dao.interfaz.TipoContactoDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private DomicilioDAO domicilio;
	private LocalidadDAO localidad;
	private PersonaDomicilioDAO personadomicilio;
	private TipoContactoDAO tipocontacto;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.domicilio = metodo_persistencia.createDomicilioDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
		this.personadomicilio = metodo_persistencia.createPersonaDomicilioDAO();
		this.tipocontacto = metodo_persistencia.createTipoContactoDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(int id_persona_a_eliminar) 
	{
		this.persona.delete(id_persona_a_eliminar);
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

	public void borrarDomicilio(int id_domicilio_a_eliminar) 
	{
		this.domicilio.delete(id_domicilio_a_eliminar);
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
/* */
	
	//// 
	public void agregarPersonaDomicilio(PersonaDomicilioDTO nuevaPersonaDomicilio)
	{
		//this.personadomicilio.insert(nuevaPersonaDomicilio);
	}

	public void borrarPersonaDomicilio(PersonaDomicilioDTO personadomicilio_a_eliminar) 
	{
		//this.personadomicilio.delete(personadomicilio_a_eliminar);
	}
	
	public List<PersonaDomicilioDTO> obtenerPersonasDomicilio()
	{
		return this.personadomicilio.readAll();		
	}

	public void editarPersonaDomicilio(PersonaDomicilioDTO personadomicilio_a_editar)
	{
		//this.personadomicilio.edit(personadomicilio_a_editar);
	}

	// TipoContacto
	public void agregarTipoContacto(TipoContactoDTO nuevoTipoContacto)
	{
		this.tipocontacto.insert(nuevoTipoContacto);
	}

	public void borrarTipoContacto(TipoContactoDTO tipo_a_eliminar) 
	{
		this.tipocontacto.delete(tipo_a_eliminar);
	}
	
	public List<TipoContactoDTO> obtenerTipoContacto()
	{
		return this.tipocontacto.readAll();		
	}

	public void editarTipoContacto(TipoContactoDTO tipo_a_editar)
	{
		this.tipocontacto.edit(tipo_a_editar);
	}
	
	public Integer findDomicilioByIdPerson(int idpersona){
		return this.domicilio.findDomicilioByIdPerson(idpersona);
	}
}
