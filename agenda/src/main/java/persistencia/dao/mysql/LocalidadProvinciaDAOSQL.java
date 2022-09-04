package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import dto.LocalidadProvinciaDTO;
import persistencia.conexion.Conexion;

import persistencia.dao.interfaz.LocalidadProvinciaDAO;

public class LocalidadProvinciaDAOSQL implements LocalidadProvinciaDAO {
	//private static final String insert = "INSERT INTO localidad (idlocalidad, nombrlocalidad,idprovincia, idpais) VALUES(?, ?, ?, ?)";
//	private static final String delete = "DELETE FROM localidad WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidad left join provincia on localidad.idprovincia = provincia.idprovincia left join pais on localidad.idpais = pais.idpais";
//	private static final String edit = "UPDATE localidad SET nombre=?,idProvincia=?, idpais=? WHERE idlocalidad = ?";

	public List<LocalidadProvinciaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<LocalidadProvinciaDTO> localidadesProvincia = new ArrayList<LocalidadProvinciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				localidadesProvincia.add(getLocalidadProvinciaDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localidadesProvincia;
	}

	private LocalidadProvinciaDTO getLocalidadProvinciaDTO(ResultSet resultSet) throws SQLException {
		int idLocal = resultSet.getInt("idlocalidad");
		String nombre = resultSet.getString("nombrelocalidad");
		int idProv = resultSet.getInt("idprovincia");
		int idpais = resultSet.getInt("idpais");
		String nombreProv = resultSet.getString("nombreProvincia");
		String nombrePais = resultSet.getString("nombrePais");

		return new LocalidadProvinciaDTO(idLocal, nombre, idProv, idpais, nombreProv, nombrePais);
	}

}
