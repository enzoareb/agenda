package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDomicilioDAO;
import dto.PersonaDomicilioDTO;

public class PersonaDomicilioDAOSQL implements PersonaDomicilioDAO {

	private static final String readall = "SELECT * FROM personas left join domicilio on personas.idPersona = domicilio.idPersona left join tipocontacto on personas.idContacto = tipocontacto.idtipocontacto left join localidad on domicilio.localidad = localidad.idlocalidad left join deportes on personas.idDeporte = deportes.idDeporte left join equipos on personas.idEquipo = equipos.idEquipo";

	public List<PersonaDomicilioDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<PersonaDomicilioDTO> personasdomicilio = new ArrayList<PersonaDomicilioDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				personasdomicilio.add(getPersonaDomicilioDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personasdomicilio;
	}

	private PersonaDomicilioDTO getPersonaDomicilioDTO(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		String fechaCumpleaños = resultSet.getString("Cumpleaños");
		String calle = resultSet.getString("calle");
		String altura = resultSet.getString("altura");
		String piso = resultSet.getString("piso");
		String depto = resultSet.getString("depto");
		String local = resultSet.getString("nombrelocalidad");
		String tipocontacto = resultSet.getString("nombretipo");

		String deporte = resultSet.getString("nombreDeporte");
		String equipo = resultSet.getString("nombreEquipo");

		return new PersonaDomicilioDTO(id, nombre, tel, email, fechaCumpleaños, calle, altura, piso, depto, local,
				tipocontacto, deporte, equipo);

	}

}
