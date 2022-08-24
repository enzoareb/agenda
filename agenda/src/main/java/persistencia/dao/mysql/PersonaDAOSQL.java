package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.DomicilioDTO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, email, Cumpleaños,IdDomicilio) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String insertDom = "INSERT INTO domicilio(idDomicilio, calle, altura, piso, depto) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String readallDom = "SELECT * FROM domicilio";
	private static final String edit = "UPDATE personas SET nombre=?, telefono=?, email=?, Cumpleaños=? WHERE idPersona = ?";
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statementPers;
		PreparedStatement statementDom;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statementPers = conexion.prepareStatement(insert);
			statementDom = conexion.prepareStatement(insertDom);
			System.out.println(persona.getIdPersona());
			System.out.println(persona.getDomicilio().getidDomicilio());
			statementPers.setInt(1, persona.getIdPersona());
			statementPers.setString(2, persona.getNombre());
			statementPers.setString(3, persona.getTelefono());
			statementPers.setString(4, persona.getEmail());
			statementPers.setString(5, persona.getFechaCumpleaños());
			statementPers.setInt(6, persona.getDomicilio().getidDomicilio());
			statementDom.setInt(1, persona.getDomicilio().getidDomicilio());
			statementDom.setString(2, persona.getDomicilio().getCalle());
			statementDom.setString(3, persona.getDomicilio().getAltura());
			statementDom.setString(4, persona.getDomicilio().getPiso());
			statementDom.setString(5, persona.getDomicilio().getDepto());

			if(statementPers.executeUpdate() > 0 && statementDom.executeUpdate()>0)
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
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
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
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statementPers;
		PreparedStatement statementDom;
		ResultSet resultSet; //Guarda el resultado de la query
		ResultSet resultSetDom;
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statementPers = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statementPers.executeQuery();

			statementDom = conexion.getSQLConexion().prepareStatement(readallDom);
			resultSetDom = statementDom.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet,resultSetDom));
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet,ResultSet resultSetDom) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		String fechaCumpleaños = resultSet.getString("Cumpleaños");
		DomicilioDTO domicilioDTO=null;
		while(resultSetDom.next())
			{
				domicilioDTO = getDomicilioDTO(resultSetDom);
			}
		return new PersonaDTO(id, nombre, tel,email,fechaCumpleaños,domicilioDTO);
	}

	private DomicilioDTO getDomicilioDTO(ResultSet resultSetDom) throws SQLException {

		int id = resultSetDom.getInt("IdDomicilio");
		String calle = resultSetDom.getString("Calle");
		String altura = resultSetDom.getString("Altura");
		String piso = resultSetDom.getString("Piso");
		String dpto = resultSetDom.getString("depto");

		return new DomicilioDTO(id, calle, altura, piso, dpto);

	}

	//agrego funcion para editar contacto
	public boolean edit(PersonaDTO persona_a_editar)
	{
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean isEditExitoso = false;
			
			try
			{
			statement = conexion.prepareStatement(edit);

			statement.setString(1, persona_a_editar.getNombre());
			statement.setString(2, persona_a_editar.getTelefono());
			statement.setString(3, persona_a_editar.getEmail());
			statement.setString(4, persona_a_editar.getFechaCumpleaños());
			statement.setString(5, persona_a_editar.getDomicilio().getCalle());
			statement.setString(6, persona_a_editar.getDomicilio().getAltura());
			statement.setString(7, persona_a_editar.getDomicilio().getPiso());
			statement.setString(8, persona_a_editar.getDomicilio().getDepto());
			statement.setString(5, Integer.toString(persona_a_editar.getIdPersona()));		

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
