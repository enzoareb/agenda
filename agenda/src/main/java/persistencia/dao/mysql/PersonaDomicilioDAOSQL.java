package persistencia.dao.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
//import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.PersonaDomicilioDAO;
import dto.PersonaDomicilioDTO;

public class PersonaDomicilioDAOSQL implements PersonaDomicilioDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, email, Cumpleaños) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "delete personas,domicilio FROM personas inner join domicilio ON domicilio.idPersona = personas.idPersona  WHERE personas.idPersona = ?";
	private static final String readall = "SELECT * FROM personas left join domicilio on personas.idPersona = domicilio.idPersona left join tipocontacto on personas.idContacto = tipocontacto.idtipocontacto left join localidad on domicilio.localidad = localidad.idlocalidad";
	//private static final String readall = "SELECT personas.*, iddomicilio,calle,altura,piso,depto,localidad FROM personas, domicilio";
	private static final String edit = "UPDATE personas SET nombre=?, telefono=?, email=?, Cumpleaños=? WHERE idPersona = ?";
	
	public boolean insert(PersonaDomicilioDTO personadomicilio)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, personadomicilio.getIdPersona());
			statement.setString(2, personadomicilio.getNombre());
			statement.setString(3, personadomicilio.getTelefono());
			statement.setString(4, personadomicilio.getEmail());
			statement.setString(5, personadomicilio.getFechaCumpleaños());
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
	
	public boolean delete(PersonaDomicilioDTO persona_a_eliminar)
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
	

	
	public List<PersonaDomicilioDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDomicilioDTO> personasdomicilio = new ArrayList<PersonaDomicilioDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personasdomicilio.add(getPersonaDomicilioDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personasdomicilio;
	}
	


	private PersonaDomicilioDTO getPersonaDomicilioDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		String fechaCumpleaños = resultSet.getString("Cumpleaños");
		//int iddomi = resultSet.getInt("idDomicilio");
		String calle = resultSet.getString("calle");
		String altura = resultSet.getString("altura");
		String piso = resultSet.getString("piso");
		String depto = resultSet.getString("depto");
		//int local = resultSet.getInt("localidad");
		String local = resultSet.getString("nombrelocalidad");
		String tipocontacto = resultSet.getString("nombretipo");

		return new PersonaDomicilioDTO(id, nombre, tel,email,fechaCumpleaños,calle,altura,piso,depto,local,tipocontacto);
		

		//return new PersonaDomicilioDTO(id, nombre, tel,email,fechaCumpleaños,iddomi,calle,altura,piso,depto,local);
	}


	//agrego funcion para editar contacto
	public boolean edit(PersonaDomicilioDTO persona_a_editar)
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
