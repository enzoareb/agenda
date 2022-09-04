package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	public PersonaDAO createPersonaDAO();

	public DomicilioDAO createDomicilioDAO();

	public LocalidadDAO createLocalidadDAO();

	public PersonaDomicilioDAO createPersonaDomicilioDAO();

	public TipoContactoDAO createTipoContactoDAO();

	public DeporteDAO createDeporteDAO();

	public EquipoDAO createEquipoDAO();

	public LocalidadProvinciaDAO createLocalidadProvinciaDAO();

	public ProvinciaDAO createProvinciaDAO();

	public PaisDAO createPaisDAO();
}
