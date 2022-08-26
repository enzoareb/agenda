/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.PersonaDomicilioDAO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	public PersonaDAO createPersonaDAO() 
	{
			return new PersonaDAOSQL();
	}

	public DomicilioDAO createDomicilioDAO() 
	{
			return new DomicilioDAOSQL();
	}

	public LocalidadDAO createLocalidadDAO() 
	{
			return new LocalidadDAOSQL();
	}

	public PersonaDomicilioDAO createPersonaDomicilioDAO() 
	{
			return new PersonaDomicilioDAOSQL();
	}


	public TipoContactoDAO createTipoContactoDAO()
	{
			return new TipoContactoDAOSQL();
	}
}
