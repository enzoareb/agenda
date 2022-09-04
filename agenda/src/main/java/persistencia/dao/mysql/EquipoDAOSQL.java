package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EquipoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.EquipoDAO;

public class EquipoDAOSQL implements EquipoDAO{

    private static final String insert = "INSERT INTO equipos(idEquipo, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM equipos WHERE idEquipo = ?";
	private static final String readall = "SELECT * FROM equipos";
	private static final String edit = "UPDATE equipos SET nombre=? WHERE idEquipo = ?";
	private static final String findById = "SELECT * FROM equipos WHERE idEquipo = ? ";

	public boolean insert(EquipoDTO equipo)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, equipo.getIdEquipo());
			statement.setString(2, equipo.getNombre());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(int id_equipo_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(id_equipo_a_eliminar));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<EquipoDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<EquipoDTO> equipos = new ArrayList<EquipoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				equipos.add(getEquipoDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return equipos;
	}
	
	private EquipoDTO getEquipoDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idEquipo");
		String nombre = resultSet.getString("nombreEquipo");

		return new EquipoDTO(id, nombre);
	}

	public boolean edit(EquipoDTO equipo_a_editar)
	{
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean isEditExitoso = false;
			
			try
			{
			statement = conexion.prepareStatement(edit);

			statement.setString(1, equipo_a_editar.getNombre());
			statement.setInt(2, equipo_a_editar.getIdEquipo());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isEditExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	
	
		
		return isEditExitoso;
	}

	public EquipoDTO findById(int idEquipo)
	{
		PreparedStatement statement;
		ResultSet resultSet; 
		EquipoDTO equipoDTO = null;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findById);
			statement.setString(1, Integer.toString(idEquipo));
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				equipoDTO = getEquipoDTO(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return equipoDTO;
	}
}
