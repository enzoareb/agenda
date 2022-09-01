package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import presentacion.vista.VentanaConexion;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);
	private VentanaConexion  ventanaConexion;	
	
	
	private  Conexion()
	{
		try
		{
			
			ventanaConexion =  new VentanaConexion(); //.getInstance();

			String servidor = (ventanaConexion.getTxtServidor().getText()).trim();
			String usuario =  (ventanaConexion.getTxtUsuario().getText()).trim();
			String pass= (ventanaConexion.getTxtContraseña().getText()).trim();
			//String conn = "jdbc:mysql://"+servidor+":3306//agenda"+usuario+pass;
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			//this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
			this.connection = DriverManager.getConnection("jdbc:mysql://"+servidor+":3306/agenda",usuario,pass);
			//this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
			
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
			
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}
