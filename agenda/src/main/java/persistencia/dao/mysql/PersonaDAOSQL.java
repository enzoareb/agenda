package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO {
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, email, Cumpleaños,idcontacto,idDeporte,idEquipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String edit = "UPDATE personas SET nombre=?, telefono=?, email=?, Cumpleaños=?, idcontacto=?, idDeporte=?, idEquipo=? WHERE idPersona = ?";
	private static final String findById = "SELECT * FROM personas WHERE idPersona = ?";

	public boolean insert(PersonaDTO persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setString(5, persona.getFechaCumpleaños());
			statement.setInt(6, persona.getIdcontacto());
			statement.setInt(7, persona.getIdDeporte());
			statement.setInt(8, persona.getIdEquipo());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isInsertExitoso;
	}

	public boolean delete(int id_persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(id_persona_a_eliminar));
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	public List<PersonaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				personas.add(getPersonaDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}

	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		String fechaCumpleaños = resultSet.getString("Cumpleaños");
		int idContacto = resultSet.getInt("idcontacto");
		int idDeporte = resultSet.getInt("idDeporte");
		int idEquipo = resultSet.getInt("idEquipo");

		return new PersonaDTO(id, nombre, tel, email, fechaCumpleaños, idContacto, idDeporte, idEquipo);
	}

	public boolean edit(PersonaDTO persona_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExitoso = false;

		try {
			statement = conexion.prepareStatement(edit);

			statement.setString(1, persona_a_editar.getNombre());
			statement.setString(2, persona_a_editar.getTelefono());
			statement.setString(3, persona_a_editar.getEmail());
			statement.setString(4, persona_a_editar.getFechaCumpleaños());
			statement.setInt(5, persona_a_editar.getIdcontacto());
			statement.setInt(6, persona_a_editar.getIdDeporte());
			statement.setInt(7, persona_a_editar.getIdEquipo());
			statement.setInt(8, persona_a_editar.getIdPersona());

			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isEditExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isEditExitoso;
	}

	public PersonaDTO findById(int idPersona) {
		PreparedStatement statement;
		ResultSet resultSet;
		PersonaDTO personaDTO = null;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(findById);
			statement.setString(1, Integer.toString(idPersona));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				personaDTO = getPersonaDTO(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personaDTO;
	}
}
