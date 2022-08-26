package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDomicilioDTO;

public interface PersonaDomicilioDAO 
{
	
	//public boolean insert(PersonaDomicilioDTO domicilio);

	//public boolean delete(PersonaDomicilioDTO domicilio_a_eliminar);

	//public boolean edit(PersonaDomicilioDTO domicilio_a_editar);
	
	public List<PersonaDomicilioDTO> readAll();
}
