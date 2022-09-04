package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.ProvinciaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ProvinciaDAO;

public class ProvinciaDAOSQL implements ProvinciaDAO {
	private static final String readall = "SELECT * FROM provincia";
	private static final String findById = "SELECT * FROM provincia WHERE idProvincia = ?";

	public List<ProvinciaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				provincias.add(getProvinciaDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provincias;
	}

	private ProvinciaDTO getProvinciaDTO(ResultSet resultSet) throws SQLException {
		int idProv = resultSet.getInt("idProvincia");
		String nombre = resultSet.getString("nombreProvincia");

		return new ProvinciaDTO(idProv, nombre);
	}

	public ProvinciaDTO findById(int idProv) {
		PreparedStatement statement;
		ResultSet resultSet;
		ProvinciaDTO provinciaDTO = null;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(findById);
			statement.setString(1, Integer.toString(idProv));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				provinciaDTO = getProvinciaDTO(resultSet);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provinciaDTO;
	}

}
