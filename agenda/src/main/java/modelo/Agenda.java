package modelo;

import java.util.List;

import dto.DeporteDTO;
import dto.DomicilioDTO;
import dto.EquipoDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DeporteDAO;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.EquipoDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.PersonaDomicilioDAO;
import persistencia.dao.interfaz.TipoContactoDAO;


public class Agenda 
{
	private PersonaDAO personaDAO;	
	private DomicilioDAO domicilioDAO;
	private LocalidadDAO localidadDAO;
	private PersonaDomicilioDAO personadomicilio;
	private TipoContactoDAO tipocontactoDao;
	private DeporteDAO deporteDAO;
	private EquipoDAO equipoDAO;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.personaDAO = metodo_persistencia.createPersonaDAO();
		this.domicilioDAO = metodo_persistencia.createDomicilioDAO();
		this.localidadDAO = metodo_persistencia.createLocalidadDAO();
		this.tipocontactoDao = metodo_persistencia.createTipoContactoDAO();
		this.deporteDAO = metodo_persistencia.createDeporteDAO();
		this.equipoDAO = metodo_persistencia.createEquipoDAO();
		this.personadomicilio = metodo_persistencia.createPersonaDomicilioDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.personaDAO.insert(nuevaPersona);
	}

	public void borrarPersona(int id_persona_a_eliminar) 
	{
		this.personaDAO.delete(id_persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.personaDAO.readAll();		
	}

	public void editarPersona(PersonaDTO persona_a_editar)
	{
		this.personaDAO.edit(persona_a_editar);
	}

    public void agregarDomicilio(DomicilioDTO nuevoDomicilio) {
		this.domicilioDAO.insert(nuevoDomicilio);
    }

	public void borrarDomicilio(int id_domicilio_a_eliminar) 
	{
		this.domicilioDAO.delete(id_domicilio_a_eliminar);
	}
	
	public List<DomicilioDTO> obtenerDomicilio()
	{
		return this.domicilioDAO.readAll();		
	}

	public void editarDomicilio(DomicilioDTO domicilio_a_editar)
	{
		this.domicilioDAO.edit(domicilio_a_editar);
	}

	// Localidad
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidadDAO.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.localidadDAO.delete(localidad_a_eliminar);
	}
	
	public List<LocalidadDTO> obtenerLocalidad()
	{
		return this.localidadDAO.readAll();		
	}

	public void editarLocalidad(LocalidadDTO localidad_a_editar)
	{
		this.localidadDAO.edit(localidad_a_editar);
	}

	public void agregarTipoContacto(TipoContactoDTO nuevoTipoContacto)
	{
		this.tipocontactoDao.insert(nuevoTipoContacto);
	}

	public void borrarTipoContacto(TipoContactoDTO tipo_a_eliminar) 
	{
		this.tipocontactoDao.delete(tipo_a_eliminar);
	}
	
	public List<TipoContactoDTO> obtenerTipoContacto()
	{
		return this.tipocontactoDao.readAll();		
	}

	public void editarTipoContacto(TipoContactoDTO tipo_a_editar)
	{
		this.tipocontactoDao.edit(tipo_a_editar);
	}
	
	public Integer findDomicilioByIdPerson(int idpersona){
		return this.domicilioDAO.findDomicilioByIdPerson(idpersona);
	}

	public void agregarDeporte(DeporteDTO nuevoDeporte)
	{
		this.deporteDAO.insert(nuevoDeporte);
	}

	public void borrarDeporte(int deporte_a_eliminar) 
	{
		this.deporteDAO.delete(deporte_a_eliminar);
	}
	
	public List<DeporteDTO> obtenerDeporte()
	{
		return this.deporteDAO.readAll();		
	}

	public void editarDeporte(DeporteDTO deporte_a_editar)
	{
		this.deporteDAO.edit(deporte_a_editar);
	}

	public void agregarEquipo(EquipoDTO nuevoEquipo)
	{
		this.equipoDAO.insert(nuevoEquipo);
	}

	public void borrarEquipo(int id_equipo_a_eliminar) 
	{
		this.equipoDAO.delete(id_equipo_a_eliminar);
	}
	
	public List<EquipoDTO> obtenerEquipo()
	{
		return this.equipoDAO.readAll();		
	}

	public void editarEquipo(EquipoDTO equipo_a_editar)
	{
		this.equipoDAO.edit(equipo_a_editar);
	}

	public List<PersonaDomicilioDTO> obtenerPersonasDomicilio()
	{
		return this.personadomicilio.readAll();		
	}
}
