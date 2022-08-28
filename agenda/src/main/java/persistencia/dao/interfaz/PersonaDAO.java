package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDTO;

public interface PersonaDAO 
{
	
	public boolean insert(PersonaDTO persona);

	public boolean delete(int id_persona_a_eliminar);

	public boolean edit(PersonaDTO persona_a_editar);
	
	public List<PersonaDTO> readAll();

	
}
