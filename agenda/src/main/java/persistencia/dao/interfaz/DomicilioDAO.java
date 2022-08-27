package persistencia.dao.interfaz;

import java.util.List;

import dto.DomicilioDTO;

public interface DomicilioDAO 
{
	
	public boolean insert(DomicilioDTO domicilio);

	public boolean delete(int id_domicilio_a_eliminar);

	public boolean edit(DomicilioDTO domicilio_a_editar);
	
	public List<DomicilioDTO> readAll();

	public Integer findDomicilioByIdPerson(int idPersona);
}
