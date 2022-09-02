package main;

import presentacion.controlador.Controlador;
import presentacion.vista.VentanaConexion;
import presentacion.vista.Vista;

public class Main {

	public static void main(String[] args) {

		VentanaConexion ventanaConexion = new VentanaConexion();
		Vista vista = new Vista();
		new Controlador(ventanaConexion, vista);

	}

}
