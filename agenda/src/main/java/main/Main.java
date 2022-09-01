package main;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaConexion;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		VentanaConexion conn = new VentanaConexion();
		//conn.getBtnConectar().addActionListener(a->);
		conn.setTitle("DATOS DE CONEXION DEL SERVIDOR");
		conn.setLocationRelativeTo(null);
		conn.setVisible(true);
		//conn.getBtnConectar().addActionListener(abrirAgenda());

	

		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo);
		
		controlador.inicializar();
	}
/*/
	private void abrirAgenda(){
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo);
		controlador.inicializar();

	}*/







}
