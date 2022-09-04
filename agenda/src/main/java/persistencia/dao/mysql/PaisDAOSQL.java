package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PaisDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PaisDAO;

public class PaisDAOSQL implements PaisDAO {

	private static final String readall = "SELECT * FROM pais";
	private static final String findById = "SELECT * FROM pais WHERE idPais = ?";

	public List<PaisDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<PaisDTO> paises = new ArrayList<PaisDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				paises.add(getPaisDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paises;
	}

	private PaisDTO getPaisDTO(ResultSet resultSet) throws SQLException {
		int idPais = resultSet.getInt("idpais");
		String nombre = resultSet.getString("nombrepais");
		return new PaisDTO(idPais, nombre);
	}

	public PaisDTO findById(int idPais) {
		PreparedStatement statement;
		ResultSet resultSet;
		PaisDTO paisDTO = null;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(findById);
			statement.setString(1, Integer.toString(idPais));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				paisDTO = getPaisDTO(resultSet);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paisDTO;
	}
}
