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
//import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.LocalidadProvinciaDAO;


public class LocalidadProvinciaDAOSQL implements LocalidadProvinciaDAO
{
	private static final String insert = "INSERT INTO localidad (idlocalidad, nombrlocalidad,idprovincia, idpais) VALUES(?, ?, ?, ?)";
	private static final String delete = "DELETE FROM localidad WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidad left join provincia on localidad.idprovincia = provincia.idprovincia left join pais on localidad.idpais = pais.idpais";
	private static final String edit = "UPDATE localidad SET nombre=?,idProvincia=?, idpais=? WHERE idlocalidad = ?";
	
	public boolean insert(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, localidad.getNombre());
			statement.setInt(2, localidad.getIdProvincia());
			statement.setInt(3, localidad.getIdPais());
	
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
	
	public boolean delete(LocalidadDTO localidad_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(localidad_a_eliminar.getIdLocalidad()));
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
	
	public List<LocalidadProvinciaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadProvinciaDTO> localidadesProvincia = new ArrayList<LocalidadProvinciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidadesProvincia.add(getLocalidadProvinciaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidadesProvincia;
	}
	
	private LocalidadProvinciaDTO getLocalidadProvinciaDTO(ResultSet resultSet) throws SQLException
	{
		int idLocal = resultSet.getInt("idlocalidad");
		String nombre = resultSet.getString("nombrelocalidad");
		int idProv = resultSet.getInt("idprovincia");
		int idpais = resultSet.getInt("idpais");
		String nombreProv = resultSet.getString("nombreProvincia");
		String nombrePais = resultSet.getString("nombrePais");

		return new LocalidadProvinciaDTO(idLocal,nombre,idProv,idpais,nombreProv,nombrePais);
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
