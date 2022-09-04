package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DomicilioDAO;
import dto.DomicilioDTO;

public class DomicilioDAOSQL implements DomicilioDAO
{
	private static final String insert = "INSERT INTO domicilio(idDomicilio, idPersona, calle, altura, piso, depto, localidad) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM domicilio WHERE idDomicilio = ?";
	private static final String readall = "SELECT * FROM domicilio";
	private static final String edit = "UPDATE domicilio SET calle=?, altura=?, piso=?, depto=?, localidad=? WHERE idDomicilio = ?";
	private static final String findById = "SELECT * FROM domicilio WHERE idPersona = ?";

	public boolean insert(DomicilioDTO domicilio)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, domicilio.getidDomicilio());
			statement.setInt(2, domicilio.getidPersona());
			statement.setString(3, domicilio.getCalle());
			statement.setString(4, domicilio.getAltura());
			statement.setString(5, domicilio.getPiso());
			statement.setString(6, domicilio.getDepto());
			statement.setInt(7, domicilio.getIdLocalidad());
			
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
	
	public boolean delete(int id_domicilio_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(id_domicilio_a_eliminar));
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
	
	public List<DomicilioDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<DomicilioDTO> domicilios = new ArrayList<DomicilioDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				domicilios.add(getDomicilioDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return domicilios;
	}

	private DomicilioDTO getDomicilioDTO(ResultSet resultSet) throws SQLException
	{
		int idDom = resultSet.getInt("idDomicilio");
		int idPer = resultSet.getInt("idPersona");
		String calle = resultSet.getString("Calle");
		String altura = resultSet.getString("Altura");
		String piso = resultSet.getString("Piso");
		String depto = resultSet.getString("Depto");
		int idlocalidad = resultSet.getInt("Localidad");
		
		return new DomicilioDTO(idDom,idPer,calle,altura,piso,depto,idlocalidad);
	}

	public boolean edit(DomicilioDTO domicilio_a_editar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isEditExitoso = false;
		try
		{
			statement = conexion.prepareStatement(edit);
			
			statement.setString(1, domicilio_a_editar.getCalle());
			statement.setString(2, domicilio_a_editar.getAltura());
			statement.setString(3, domicilio_a_editar.getPiso());
			statement.setString(4, domicilio_a_editar.getDepto());
			statement.setInt(5, domicilio_a_editar.getIdLocalidad());
			statement.setInt(6, domicilio_a_editar.getidDomicilio());

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

	public DomicilioDTO findById(int idPersona)
	{
		PreparedStatement statement;
		ResultSet resultSet; 
		DomicilioDTO domicilioDTO = null;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(findById);
			statement.setString(1, Integer.toString(idPersona));
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				domicilioDTO = getDomicilioDTO(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return domicilioDTO;
	}
}
