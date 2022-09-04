package persistencia.dao.interfaz;

import java.util.List;
import dto.ProvinciaDTO;

public interface ProvinciaDAO {
	public List<ProvinciaDTO> readAll();

	public ProvinciaDTO findById(int idProv);
}
