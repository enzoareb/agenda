package persistencia.dao.interfaz;

import java.util.List;

//import dto.LocalidadDTO;
import dto.LocalidadProvinciaDTO;

public interface LocalidadProvinciaDAO 
{
	
	//public boolean insert(LocalidadProvinciaDTO domicilio);

	//public boolean delete(LocalidadProvinciaDTO domicilio_a_eliminar);

	//public boolean edit(LocalidadProvinciaDTO domicilio_a_editar);
	
	public List<LocalidadProvinciaDTO> readAll();
}
