package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PaisDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PaisDAO;


public class PaisDAOSQL implements PaisDAO
{
	private static final String insert = "INSERT INTO pais (idpais, nombrepais) VALUES(?, ?)";
	private static final String delete = "DELETE FROM pais WHERE idpais = ?";
	private static final String readall = "SELECT * FROM pais";
	private static final String edit = "UPDATE pais SET nombrepais=? WHERE idpais = ?";
	
	public boolean insert(PaisDTO pais)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, pais.getNombrePais());
			//statement.setInt(2, pais.get.getIdProvincia());
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
	
	public boolean delete(PaisDTO pais_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(pais_a_eliminar.getIdPais()));
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
	
	public List<PaisDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PaisDTO> paises = new ArrayList<PaisDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				paises.add(getPaisDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return paises;
	}
	
	private PaisDTO getPaisDTO(ResultSet resultSet) throws SQLException
	{
		int idPais= resultSet.getInt("idpais");
		String nombre = resultSet.getString("nombrepais");
		//int idProv = resultSet.getInt("idprovincia");
		//int idpais = resultSet.getInt("idpais");

		return new PaisDTO(idPais,nombre);
	}


	//agrego funcion para editar pais
	public boolean edit(PaisDTO pais_a_editar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExitoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);

			statement.setString(2, Integer.toString(pais_a_editar.getIdPais()));
			statement.setString(1, pais_a_editar.getNombrePais());
			//statement.setString(2, Integer.toString(pais_a_editar.getIdProvincia()));
			//statement.setString(3, Integer.toString(localidad_a_editar.getIdPais()));

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
