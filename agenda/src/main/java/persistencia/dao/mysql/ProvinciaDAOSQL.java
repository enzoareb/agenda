package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProvinciaDTO;
import persistencia.conexion.Conexion;
//import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.ProvinciaDAO;


public class ProvinciaDAOSQL implements ProvinciaDAO
{
	private static final String insert = "INSERT INTO provincia (idProvincia, nombreProvincia) VALUES(?, ?)";
	private static final String delete = "DELETE FROM provincia WHERE idProvincia = ?";
	private static final String readall = "SELECT * FROM provincia";
	private static final String edit = "UPDATE provincia SET nombreprovincia=? WHERE idProvincia = ?";
	private static final String findById = "SELECT * FROM provincia WHERE idProvincia = ?";

	public boolean insert(ProvinciaDTO provincia)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, provincia.getNombreProvincia());
			//statement.setInt(2, provincia.getIdProvincia());
			//statement.setInt(3, localidad.getIdPais());
	
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
	
	public boolean delete(ProvinciaDTO provincia_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(provincia_a_eliminar.getIdProvincia()));
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
	
	public List<ProvinciaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				provincias.add(getProvinciaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provincias;
	}
	
	private ProvinciaDTO getProvinciaDTO(ResultSet resultSet) throws SQLException
	{
		int idProv = resultSet.getInt("idProvincia");
		String nombre = resultSet.getString("nombreProvincia");
	//	int idProv = resultSet.getInt("idprovincia");
	//	int idpais = resultSet.getInt("idpais");

		return new ProvinciaDTO(idProv,nombre);
	}


	//agrego funcion para editar localidad
	public boolean edit(ProvinciaDTO provincia_a_editar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExitoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);

		//	statement.setString(4, Integer.toString(provincia_a_editar.getIdLocalidad()));
			statement.setString(1, provincia_a_editar.getNombreProvincia());
			statement.setString(2, Integer.toString(provincia_a_editar.getIdProvincia()));
			//statement.setString(3, Integer.toString(provincia_a_editar.getIdPais()));

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

	public ProvinciaDTO findById(int idProv)
	{
		PreparedStatement statement;
		ResultSet resultSet; 
		ProvinciaDTO provinciaDTO = null;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findById);
			statement.setString(1, Integer.toString(idProv));
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				provinciaDTO = getProvinciaDTO(resultSet);
				//localidades.add(getLocalidadDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provinciaDTO;
	}

}


