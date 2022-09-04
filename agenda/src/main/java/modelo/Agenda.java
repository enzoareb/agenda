package modelo;

import java.util.List;

import dto.DeporteDTO;
import dto.DomicilioDTO;
import dto.EquipoDTO;
import dto.LocalidadDTO;
import dto.LocalidadProvinciaDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;
import dto.ProvinciaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DeporteDAO;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.EquipoDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.LocalidadProvinciaDAO;
import persistencia.dao.interfaz.PaisDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.PersonaDomicilioDAO;
import persistencia.dao.interfaz.ProvinciaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class Agenda {
	private PersonaDAO personaDAO;
	private DomicilioDAO domicilioDAO;
	private LocalidadDAO localidadDAO;
	private PersonaDomicilioDAO personadomicilioDAO;
	private TipoContactoDAO tipocontactoDao;
	private DeporteDAO deporteDAO;
	private EquipoDAO equipoDAO;
	private LocalidadProvinciaDAO localidadprovinciaDAO;
	private ProvinciaDAO provinciaDAO;
	private PaisDAO paisDAO;

	public Agenda(DAOAbstractFactory metodo_persistencia) {
		this.personaDAO = metodo_persistencia.createPersonaDAO();
		this.domicilioDAO = metodo_persistencia.createDomicilioDAO();
		this.localidadDAO = metodo_persistencia.createLocalidadDAO();
		this.tipocontactoDao = metodo_persistencia.createTipoContactoDAO();
		this.deporteDAO = metodo_persistencia.createDeporteDAO();
		this.equipoDAO = metodo_persistencia.createEquipoDAO();
		this.personadomicilioDAO = metodo_persistencia.createPersonaDomicilioDAO();
		this.localidadprovinciaDAO = metodo_persistencia.createLocalidadProvinciaDAO();
		this.provinciaDAO = metodo_persistencia.createProvinciaDAO();
		this.paisDAO = metodo_persistencia.createPaisDAO();
	}

	// persona
	public void agregarPersona(PersonaDTO nuevaPersona) {
		this.personaDAO.insert(nuevaPersona);
	}

	public void borrarPersona(int id_persona_a_eliminar) {
		this.personaDAO.delete(id_persona_a_eliminar);
	}

	public List<PersonaDTO> obtenerPersonas() {
		return this.personaDAO.readAll();
	}

	public void editarPersona(PersonaDTO persona_a_editar) {
		this.personaDAO.edit(persona_a_editar);
	}

	public PersonaDTO findPersonaById(int idPersona) {
		return this.personaDAO.findById(idPersona);
	}

	// domicilio
	public void agregarDomicilio(DomicilioDTO nuevoDomicilio) {
		this.domicilioDAO.insert(nuevoDomicilio);
	}

	public void borrarDomicilio(int id_domicilio_a_eliminar) {
		this.domicilioDAO.delete(id_domicilio_a_eliminar);
	}

	public List<DomicilioDTO> obtenerDomicilio() {
		return this.domicilioDAO.readAll();
	}

	public void editarDomicilio(DomicilioDTO domicilio_a_editar) {
		this.domicilioDAO.edit(domicilio_a_editar);
	}

	public DomicilioDTO findDomicilioById(int idPersona) {
		return this.domicilioDAO.findById(idPersona);
	}

	// Localidad
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad) {
		this.localidadDAO.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(int id_localidad_a_eliminar) {
		this.localidadDAO.delete(id_localidad_a_eliminar);
	}

	public List<LocalidadDTO> obtenerLocalidad() {
		return this.localidadDAO.readAll();
	}

	public void editarLocalidad(LocalidadDTO localidad_a_editar) {
		this.localidadDAO.edit(localidad_a_editar);
	}

	public LocalidadDTO findLocalidadById(int idLocalidad) {
		return this.localidadDAO.findById(idLocalidad);
	}

	// tipo de cntacto
	public void agregarTipoContacto(TipoContactoDTO nuevoTipoContacto) {
		this.tipocontactoDao.insert(nuevoTipoContacto);
	}

	public List<TipoContactoDTO> obtenerTipoContacto() {
		return this.tipocontactoDao.readAll();
	}

	public void editarTipoContacto(TipoContactoDTO tipo_a_editar) {
		this.tipocontactoDao.edit(tipo_a_editar);
	}

	public void borrarTipoContacto(int tipo_a_eliminar) {
		this.tipocontactoDao.delete(tipo_a_eliminar);
	}

	public TipoContactoDTO findTipoContactoById(int idTipoContacto) {
		return this.tipocontactoDao.findById(idTipoContacto);
	}

	// deporte
	public void agregarDeporte(DeporteDTO nuevoDeporte) {
		this.deporteDAO.insert(nuevoDeporte);
	}

	public void borrarDeporte(int deporte_a_eliminar) {
		this.deporteDAO.delete(deporte_a_eliminar);
	}

	public List<DeporteDTO> obtenerDeporte() {
		return this.deporteDAO.readAll();
	}

	public void editarDeporte(DeporteDTO deporte_a_editar) {
		this.deporteDAO.edit(deporte_a_editar);
	}

	public DeporteDTO findDeporteById(int idDeporte) {
		return this.deporteDAO.findById(idDeporte);
	}

	// equipo
	public void agregarEquipo(EquipoDTO nuevoEquipo) {
		this.equipoDAO.insert(nuevoEquipo);
	}

	public void borrarEquipo(int id_equipo_a_eliminar) {
		this.equipoDAO.delete(id_equipo_a_eliminar);
	}

	public List<EquipoDTO> obtenerEquipo() {
		return this.equipoDAO.readAll();
	}

	public void editarEquipo(EquipoDTO equipo_a_editar) {
		this.equipoDAO.edit(equipo_a_editar);
	}

	public EquipoDTO findEquipoById(int idEquipo) {
		return this.equipoDAO.findById(idEquipo);
	}

	// personas domicilio
	public List<PersonaDomicilioDTO> obtenerPersonasDomicilio() {
		return this.personadomicilioDAO.readAll();
	}

	// localidad provincia
	public List<LocalidadProvinciaDTO> obtenerLocalidadProvincia() {
		return this.localidadprovinciaDAO.readAll();
	}

	// provincia
	public List<ProvinciaDTO> obtenerProvincia() {
		return this.provinciaDAO.readAll();
	}

	public ProvinciaDTO findProvById(int idProv) {
		return this.provinciaDAO.findById(idProv);
	}

	// pais
	public List<PaisDTO> obtenerPais() {
		return this.paisDAO.readAll();
	}

	public PaisDTO findPaisById(int idPais) {
		return this.paisDAO.findById(idPais);
	}

}
