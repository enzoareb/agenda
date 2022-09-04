package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDomicilioDTO;

public interface PersonaDomicilioDAO {
	public List<PersonaDomicilioDTO> readAll();
}
