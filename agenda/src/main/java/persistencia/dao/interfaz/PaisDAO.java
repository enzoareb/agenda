package persistencia.dao.interfaz;

import java.util.List;

import dto.PaisDTO;

public interface PaisDAO 
{
	
	public boolean insert(PaisDTO domicilio);

	public boolean delete(PaisDTO domicilio_a_eliminar);

	public boolean edit(PaisDTO domicilio_a_editar);
	
	public List<PaisDTO> readAll();

	public PaisDTO findById(int idPais);
}
