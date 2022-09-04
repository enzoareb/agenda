package persistencia.dao.interfaz;

import java.util.List;
import dto.TipoContactoDTO;

public interface TipoContactoDAO {

	public boolean insert(TipoContactoDTO domicilio);

	public boolean delete(int tipo_a_eliminar);

	public boolean edit(TipoContactoDTO domicilio_a_editar);

	public List<TipoContactoDTO> readAll();

	public TipoContactoDTO findById(int idTipoContacto);
}
