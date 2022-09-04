package persistencia.dao.interfaz;

import java.util.List;

import dto.DeporteDTO;

public interface DeporteDAO {
	public boolean insert(DeporteDTO deporte);

	public boolean delete(int id_deporte_a_eliminar);

	public boolean edit(DeporteDTO deporte_a_editar);

	public List<DeporteDTO> readAll();

	public DeporteDTO findById(int idDeporte);
}
