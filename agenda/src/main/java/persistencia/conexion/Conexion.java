package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import presentacion.vista.VentanaConexion;

public class Conexion {
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);

	public Conexion() {
	}

	public boolean conectar(VentanaConexion ventanaConexion) {
		try {

			String servidor = (ventanaConexion.getTxtServidor().getText()).trim();
			String usuario = (ventanaConexion.getTxtUsuario().getText()).trim();
			String pass = (ventanaConexion.getTxtContraseña().getText()).trim();

			Class.forName("com.mysql.jdbc.Driver");

			this.connection = DriverManager.getConnection("jdbc:mysql://" + servidor + ":3306/agenda", usuario, pass);

			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
			return true;
		} catch (Exception e) {
			log.error("Conexión fallida", e);
			return false;

		}

	}

	public static Conexion getConexion() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() {
		return this.connection;
	}

	public void cerrarConexion() {
		try {
			this.connection.close();
			log.info("Conexion cerrada");
		} catch (SQLException e) {
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}
