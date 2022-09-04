package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.DeporteDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DeporteDAO;

public class DeporteDAOSQL implements DeporteDAO {

	private static final String insert = "INSERT INTO deportes(idDeporte, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM deportes WHERE idDeporte = ?";
	private static final String readall = "SELECT * FROM deportes";
	private static final String edit = "UPDATE deportes SET nombre=? WHERE idDeporte = ?";
	private static final String findById = "SELECT * FROM deportes WHERE idDeporte = ? ";

	public boolean insert(DeporteDTO deporte) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, deporte.getIdDeporte());
			statement.setString(2, deporte.getNombre());

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

	public boolean delete(int id_deporte_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(id_deporte_a_eliminar));
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	public List<DeporteDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<DeporteDTO> deportes = new ArrayList<DeporteDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				deportes.add(getDeporteDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deportes;
	}

	private DeporteDTO getDeporteDTO(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("idDeporte");
		String nombre = resultSet.getString("nombreDeporte");

		return new DeporteDTO(id, nombre);
	}

	public boolean edit(DeporteDTO deporte_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExitoso = false;

		try {
			statement = conexion.prepareStatement(edit);

			statement.setString(1, deporte_a_editar.getNombre());
			statement.setInt(2, deporte_a_editar.getIdDeporte());

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

	public DeporteDTO findById(int idDeporte) {
		PreparedStatement statement;
		ResultSet resultSet;
		DeporteDTO deporteDTO = null;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(findById);
			statement.setString(1, Integer.toString(idDeporte));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				deporteDTO = getDeporteDTO(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deporteDTO;
	}
}