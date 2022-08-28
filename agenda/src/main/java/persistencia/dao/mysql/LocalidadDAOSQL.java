package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;


public class LocalidadDAOSQL implements LocalidadDAO
{
	private static final String insert = "INSERT INTO localidad (idlocalidad, nombrelocalidad,idprovincia, idpais) VALUES(?, ?, ?, ?)";
	private static final String delete = "DELETE FROM localidad WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidad";
	private static final String edit = "UPDATE localidad SET nombrelocalidad=?,idProvincia=?, idpais=? WHERE idlocalidad = ?";
	
	public boolean insert(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1,localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombre());
			statement.setInt(3, localidad.getIdProvincia());
			statement.setInt(4, localidad.getIdPais());
	
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
	
	public boolean delete(int id_localidad_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(id_localidad_a_eliminar));
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


		
	public List<LocalidadDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidades.add(getLocalidadDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidades;
	}
	
	private LocalidadDTO getLocalidadDTO(ResultSet resultSet) throws SQLException
	{
		int idLocal = resultSet.getInt("idlocalidad");
		String nombre = resultSet.getString("nombrelocalidad");
		int idProv = resultSet.getInt("idprovincia");
		int idpais = resultSet.getInt("idpais");

		return new LocalidadDTO(idLocal,nombre,idProv,idpais);
	}


	//agrego funcion para editar localidad
	public boolean edit(LocalidadDTO localidad_a_editar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExitoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);

			statement.setString(4, Integer.toString(localidad_a_editar.getIdLocalidad()));
			statement.setString(1, localidad_a_editar.getNombre());
			statement.setString(2, Integer.toString(localidad_a_editar.getIdProvincia()));
			statement.setString(3, Integer.toString(localidad_a_editar.getIdPais()));

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
}
