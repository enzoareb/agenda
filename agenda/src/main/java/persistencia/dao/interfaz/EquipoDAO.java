package persistencia.dao.interfaz;

import java.util.List;

import dto.EquipoDTO;

public interface EquipoDAO {
    
    public boolean insert(EquipoDTO equipo);

	public boolean delete(int id_equipo_a_eliminar);

	public boolean edit(EquipoDTO equipo_a_editar);
	
	public List<EquipoDTO> readAll();
}
