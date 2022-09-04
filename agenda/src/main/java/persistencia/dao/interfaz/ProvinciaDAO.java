package persistencia.dao.interfaz;

import java.util.List;
import dto.ProvinciaDTO;

public interface ProvinciaDAO 
{
	
	public boolean insert(ProvinciaDTO domicilio);

	public boolean delete(ProvinciaDTO domicilio_a_eliminar);

	public boolean edit(ProvinciaDTO domicilio_a_editar);
	
	public List<ProvinciaDTO> readAll();

	public ProvinciaDTO findById(int idProv);
}
