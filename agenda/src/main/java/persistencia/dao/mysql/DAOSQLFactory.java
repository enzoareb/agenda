/**
 * 
 */
package persistencia.dao.mysql;

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

public class DAOSQLFactory implements DAOAbstractFactory {
	/*
	 * (non-Javadoc)
	 * 
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	public PersonaDAO createPersonaDAO() {
		return new PersonaDAOSQL();
	}

	public DomicilioDAO createDomicilioDAO() {
		return new DomicilioDAOSQL();
	}

	public LocalidadDAO createLocalidadDAO() {
		return new LocalidadDAOSQL();
	}

	public PersonaDomicilioDAO createPersonaDomicilioDAO() {
		return new PersonaDomicilioDAOSQL();
	}

	public TipoContactoDAO createTipoContactoDAO() {
		return new TipoContactoDAOSQL();
	}

	@Override
	public DeporteDAO createDeporteDAO() {

		return new DeporteDAOSQL();
	}

	@Override
	public EquipoDAO createEquipoDAO() {

		return new EquipoDAOSQL();
	}

	public LocalidadProvinciaDAO createLocalidadProvinciaDAO() {
		return new LocalidadProvinciaDAOSQL();
	}

	public ProvinciaDAO createProvinciaDAO() {
		return new ProvinciaDAOSQL();
	}

	public PaisDAO createPaisDAO() {
		return new PaisDAOSQL();
	}
}
