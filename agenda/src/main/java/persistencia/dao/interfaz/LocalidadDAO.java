package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;

public interface LocalidadDAO 
{
	
	public boolean insert(LocalidadDTO domicilio);

	public boolean delete(LocalidadDTO domicilio_a_eliminar);

	public boolean edit(LocalidadDTO domicilio_a_editar);
	
	public List<LocalidadDTO> readAll();
}
