package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.LocalidadProvinciaDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;
import dto.TipoContactoDTO;
import modelo.Agenda;
import persistencia.conexion.Conexion;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.reportes.ReporteAgenda;
import presentacion.reportes.ReporteDeporte;
import presentacion.vista.VentanaConexion;
import presentacion.vista.VentanaEditarLocalidad;
import presentacion.vista.VentanaEditarTipoContacto;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaTipoContacto;
import presentacion.vista.Vista;

public class Controlador implements ActionListener {
	private Vista vista;
	private Agenda agenda;

	private VentanaPersona ventanaPersona;
	private VentanaLocalidad ventanaLocalidad;
	private VentanaTipoContacto ventanaTipoContacto;
	private VentanaEditarLocalidad ventanaeditarlocalidad;

	private VentanaEditarTipoContacto ventanaeditartipocontacto;

	private List<PersonaDomicilioDTO> personasEnTabla;
	private List<LocalidadProvinciaDTO> localidadesEnTabla;
	private List<TipoContactoDTO> tiposContactoEnTabla;

	private boolean estadoConexion;

	public Controlador(VentanaConexion ventanaConexion, Vista vista) {
		estadoConexion = false;

		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(a -> ventanaAgregarPersona(a));
		this.vista.getBtnEditar().addActionListener(e -> ventanaEditarPersona(e));
		this.vista.getBtnBorrar().addActionListener(s -> borrarPersona(s));
		this.vista.getBtnReporte().addActionListener(r -> mostrarReporte(r));
		this.vista.getBtnReporteDeporte().addActionListener(r -> mostrarReporteDeporte(r));
		this.vista.getBtnLocalidad().addActionListener(a -> ventanaMostrarLocalidad(a));
		this.vista.getBtnContactos().addActionListener(a -> ventanaMostrarTipoContacto(a));

		this.ventanaPersona = VentanaPersona.getInstance();
		this.ventanaPersona.getBtnAgregarPersona().addActionListener(p -> guardarPersona(p));
		this.ventanaPersona.getBtnActualizarPersona().addActionListener(h -> editarPersona(h));

		this.ventanaLocalidad = VentanaLocalidad.getInstance();
		this.ventanaLocalidad.getBtnAgregar().addActionListener(a -> ventanaAgregarLocalidad(a));
		this.ventanaLocalidad.getBtnBorrar().addActionListener(e -> borrarLocalidad(e));
		this.ventanaLocalidad.getBtnEditar().addActionListener(e -> ventanaEditarLocalidad(e));

		this.ventanaeditarlocalidad = VentanaEditarLocalidad.getInstance();

		this.ventanaeditarlocalidad.getBtnAgregarLocalidad().addActionListener(p -> guardarLocalidad(p));
		this.ventanaeditarlocalidad.getBtnActualizarLocalidad().addActionListener(p -> actualizarLocalidad(p));

		this.ventanaTipoContacto = VentanaTipoContacto.getInstance();
		this.ventanaTipoContacto.getBtnAgregar().addActionListener(p -> ventanaAgregarTipoContacto(p));
		this.ventanaTipoContacto.getBtnEditar().addActionListener(a -> ventanaEditarTipoContacto(a));
		this.ventanaTipoContacto.getBtnBorrar().addActionListener(b -> borrarTipoContacto(b));

		this.ventanaeditartipocontacto = VentanaEditarTipoContacto.getInstance();
		this.ventanaeditartipocontacto.getBtnAgregarTipoContacto().addActionListener(a -> guardarTipoContacto(a));
		this.ventanaeditartipocontacto.getBtnActualizarTipoContacto().addActionListener(a -> actualizarTipoContacto(a));

		ventanaConexion.getBtnConectar().addActionListener(c -> chequearConexion(ventanaConexion));
		ventanaConexion.mostrarVentana();

	}

	private void chequearConexion(VentanaConexion ventanaConexion) {

		Conexion conexion = Conexion.getConexion();
		estadoConexion = conexion.conectar(ventanaConexion);
		if (estadoConexion) {
			ventanaConexion.cerrarVentana();

			agenda = new Agenda(new DAOSQLFactory());
			this.ventanaPersona.llenarComboLocalidades(this.agenda.obtenerLocalidad());
			this.ventanaPersona.llenarComboTipos(this.agenda.obtenerTipoContacto());
			this.ventanaPersona.llenarComboDeportes(this.agenda.obtenerDeporte());
			this.ventanaPersona.llenarComboEquipos(this.agenda.obtenerEquipo());
			this.ventanaeditarlocalidad.llenarComboProvincias(this.agenda.obtenerProvincia());
			this.ventanaeditarlocalidad.llenarComboPaises(this.agenda.obtenerPais());

			inicializar();
		} else {
			ventanaConexion.mostrarMensajeError();
		}
	}

	//-------------------------tipo de cotacto -------------------------
	
	private void ventanaMostrarTipoContacto(ActionEvent l) {
		this.tiposContactoEnTabla = agenda.obtenerTipoContacto();
		this.ventanaTipoContacto.llenarTabla(this.tiposContactoEnTabla);
		this.ventanaTipoContacto.mostrarVentana("TIPOS DE CONTACTO", false);
	}

	private void guardarTipoContacto(ActionEvent p) {
		String nombre = this.ventanaeditartipocontacto.getTxtNombre().getText();
		TipoContactoDTO nuevoTipocontacto = new TipoContactoDTO(0, nombre);
		this.agenda.agregarTipoContacto(nuevoTipocontacto);
		this.refrescarTablaTipoContacto();
		this.ventanaeditartipocontacto.cerrar();
	}

	private void ventanaEditarTipoContacto(ActionEvent e) {

		int[] filasSeleccionadas = this.ventanaTipoContacto.getTablaTipoContacto().getSelectedRows();
		if (filasSeleccionadas.length != 0) {

			for (int fila : filasSeleccionadas) {
				this.ventanaeditartipocontacto.setTxtIdTipoContacto(String.valueOf(this.tiposContactoEnTabla.get(fila).getIdTipoContacto()));
				this.ventanaeditartipocontacto.setTxtNombre(this.tiposContactoEnTabla.get(fila).getNombreTipo());

			}

			this.ventanaeditartipocontacto.mostrarVentana2("EDITAR TIPO CONTACTO", false);
		} else {
			ventanaeditartipocontacto.mostrarMensaje();
		}
	}

	private void actualizarTipoContacto(ActionEvent p) {

		int idTipoContacto = Integer.parseInt(this.ventanaeditartipocontacto.getTxtIdTipoContacto().getText());
		String nombre = this.ventanaeditartipocontacto.getTxtNombre().getText();
		TipoContactoDTO tipo_a_editar = new TipoContactoDTO(idTipoContacto, nombre);
		this.agenda.editarTipoContacto(tipo_a_editar);
		this.refrescarTablaTipoContacto();
		this.ventanaeditartipocontacto.cerrar();
	}

	public void borrarTipoContacto(ActionEvent s) {
		int[] filasSeleccionadas = this.ventanaTipoContacto.getTablaTipoContacto().getSelectedRows();
		for (int fila : filasSeleccionadas) {
			int idTipocontacto = this.tiposContactoEnTabla.get(fila).getIdTipoContacto();
			this.agenda.borrarTipoContacto(idTipocontacto);

		}
		this.refrescarTablaTipoContacto();
	}

	private void ventanaAgregarTipoContacto(ActionEvent l) {
		this.ventanaeditartipocontacto.mostrarVentana("NUEVO TIPO CONTACTO", false);
	}

	//-----------------------------persona----------------------------------

	private void ventanaAgregarPersona(ActionEvent a) {

		this.ventanaPersona.mostrarVentana("NUEVO CONTACTO", false);
	}

	private void ventanaEditarPersona(ActionEvent e) {

		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		if (filasSeleccionadas.length != 0) {
			for (int fila : filasSeleccionadas) {
				int idPersona = this.personasEnTabla.get(fila).getIdPersona();
				this.ventanaPersona.setTxtIdPersona(idPersona);
				this.ventanaPersona.setTxtNombre(this.personasEnTabla.get(fila).getNombre());
				this.ventanaPersona.setTxtTelefono(this.personasEnTabla.get(fila).getTelefono());
				this.ventanaPersona.setTxtEmail(this.personasEnTabla.get(fila).getEmail());
				this.ventanaPersona.setTxtFechaCumpleaños(this.personasEnTabla.get(fila).getFechaCumpleaños());
				this.ventanaPersona.setTxtIdDomicilio(this.agenda.findDomicilioByIdPerson(idPersona));
				this.ventanaPersona.setTxtDomicilioCalle(this.personasEnTabla.get(fila).getCalle());
				this.ventanaPersona.setTxtDomicilioAltura(this.personasEnTabla.get(fila).getAltura());
				this.ventanaPersona.setTxtDomicilioPiso(this.personasEnTabla.get(fila).getPiso());
				this.ventanaPersona.setTxtDomicilioDpto(this.personasEnTabla.get(fila).getDepto());
				////////////////////////////////////////////////////////////////////////////////////
				//this.ventanaPersona.setTxtIdDeporte(String.valueOf(this.personasEnTabla.get(fila).getIdDeporte()));
			
				/////////////////////////////////////////////////////////////////////////////////////
			}

			this.ventanaPersona.mostrarVentana2("EDITAR CONTACTO", false);
		} else {
			ventanaPersona.mostrarMensaje();
		}

	}

	private void guardarPersona(ActionEvent p) {
		String nombre = this.ventanaPersona.getTxtNombre().getText();
		String tel = ventanaPersona.getTxtTelefono().getText();
		String email = ventanaPersona.getTxtEmail().getText();
		String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
		int idcontacto = ventanaPersona.getJcTipoContacto().getSelectedIndex() + 1;
		int idDeporte = ventanaPersona.getJcDeporte().getSelectedIndex() + 1;
		int idEquipo = ventanaPersona.getJcEquipo().getSelectedIndex() + 1;
		PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, fechaCumpleaños, idcontacto, idDeporte,
				idEquipo);
		this.agenda.agregarPersona(nuevaPersona);
		this.refrescarTabla();
		this.guardarDomicilioPersona(p);
		this.ventanaPersona.cerrar();
	}

	public void borrarPersona(ActionEvent s) {
		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		for (int fila : filasSeleccionadas) {
			int idPersona = this.personasEnTabla.get(fila).getIdPersona();
			int idDomicilio = this.agenda.findDomicilioByIdPerson(idPersona);
			this.agenda.borrarPersona(idPersona);
			this.agenda.borrarDomicilio(idDomicilio);
		}
		this.refrescarTabla();
	}

	private void editarPersona(ActionEvent h) {

		int idPersona = Integer.parseInt(this.ventanaPersona.getTxtIdPersona().getText());
		String nombre = this.ventanaPersona.getTxtNombre().getText();
		String tel = ventanaPersona.getTxtTelefono().getText();
		String email = ventanaPersona.getTxtEmail().getText();
		String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
		int idcontacto = ventanaPersona.getJcTipoContacto().getSelectedIndex() + 1;
		int idDeporte = ventanaPersona.getJcDeporte().getSelectedIndex() + 1;
		int idEquipo = ventanaPersona.getJcEquipo().getSelectedIndex() + 1;
		PersonaDTO persona_a_editar = new PersonaDTO(idPersona, nombre, tel, email, fechaCumpleaños, idcontacto,
				idDeporte, idEquipo);
		this.agenda.editarPersona(persona_a_editar);
		this.editarDomicilioPersona(h);
		this.ventanaPersona.cerrar();
	}

	//-------------------------domicilio persona----------------------------

	private void guardarDomicilioPersona(ActionEvent p) {
		List<PersonaDTO> personas = agenda.obtenerPersonas();
		List<Integer> ids = new ArrayList<>();
		for (PersonaDTO personaDTO : personas) {
			ids.add(personaDTO.getIdPersona());
		}
		int mayor = ids.get(0);
		// Recorrer arreglo y ver si no es así
		// (comenzar desde el 1 porque el 0 ya lo tenemos contemplado arriba)
		for (int x = 1; x < ids.size(); x++) {
			if (ids.get(x) > mayor) {
				mayor = ids.get(x);
			}
		}
		// int idpersona = personasEnTabla.get(personasEnTabla.size()-1).getIdPersona();
		int idpersona = mayor;
		String calle = ventanaPersona.getTxtDomicilioCalle().getText();
		String altura = ventanaPersona.getTxtDomicilioAltura().getText();
		String piso = ventanaPersona.getTxtDomicilioPiso().getText();
		String depto = ventanaPersona.getTxtDomicilioDpto().getText();
		int idLocalidad = ventanaPersona.getJcLocalidad().getSelectedIndex() + 1;

		DomicilioDTO nuevoDomicilio = new DomicilioDTO(0, idpersona, calle, altura, piso, depto, idLocalidad);
		this.agenda.agregarDomicilio(nuevoDomicilio);
		this.refrescarTabla();
		this.ventanaPersona.cerrar();
	}

	private void editarDomicilioPersona(ActionEvent h) {

		int idDomicilio = Integer.parseInt(this.ventanaPersona.getTxtIdDomicilio().getText());
		int idPersona = Integer.parseInt(this.ventanaPersona.getTxtIdPersona().getText());
		String calle = ventanaPersona.getTxtDomicilioCalle().getText();
		String altura = ventanaPersona.getTxtDomicilioAltura().getText();
		String piso = ventanaPersona.getTxtDomicilioPiso().getText();
		String depto = ventanaPersona.getTxtDomicilioDpto().getText();
		int idLocalidad = ventanaPersona.getJcLocalidad().getSelectedIndex() + 1;

		DomicilioDTO domicilio_a_editar = new DomicilioDTO(idDomicilio, idPersona, calle, altura, piso, depto,
				idLocalidad);
		this.agenda.editarDomicilio(domicilio_a_editar);
		this.refrescarTabla();

	}

	//-------------------------reporte------------------------------------

	private void mostrarReporte(ActionEvent r) {
		ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
		reporte.mostrar();
	}

	private void mostrarReporteDeporte(ActionEvent r) {
		ReporteDeporte reporte = new ReporteDeporte();
		reporte.mostrar();
	}

	//------------------localidad--------------------------------

	private void ventanaEditarLocalidad(ActionEvent e) {

		int[] filasSeleccionadas = this.ventanaLocalidad.getTablaLocalidades().getSelectedRows();
		if (filasSeleccionadas.length != 0) {

			for (int fila : filasSeleccionadas) {
				this.ventanaeditarlocalidad.setTxtIdLocalidad(String.valueOf(this.localidadesEnTabla.get(fila).getIdLocalidad()));
				this.ventanaeditarlocalidad.setTxtNombre(this.localidadesEnTabla.get(fila).getNombre());
				this.ventanaeditarlocalidad.setTxtIdProvincia(String.valueOf(this.localidadesEnTabla.get(fila).getIdProvincia()));
				this.ventanaeditarlocalidad.setTxtIdPais(String.valueOf(this.localidadesEnTabla.get(fila).getIdPais()));

			}

			this.ventanaeditarlocalidad.mostrarVentana2("EDITAR LOCALIDAD", false);
		} else {
			ventanaeditarlocalidad.mostrarMensaje();
		}
	}

	private void guardarLocalidad(ActionEvent p) {
		String nombre = this.ventanaeditarlocalidad.getTxtNombre().getText();
		int idprov = this.ventanaeditarlocalidad.getJcprovincia().getSelectedIndex() + 1;
		int idpais = this.ventanaeditarlocalidad.getJcpais().getSelectedIndex() + 1;

		LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, nombre, idprov, idpais);
		this.agenda.agregarLocalidad(nuevaLocalidad);
		this.refrescarTablaLocalidades();
		this.ventanaeditarlocalidad.cerrar();
	}

	private void ventanaAgregarLocalidad(ActionEvent l) {
		this.ventanaeditarlocalidad.mostrarVentana("NUEVA LOCALIDAD", false);
	}

	private void ventanaMostrarLocalidad(ActionEvent l) {
		this.localidadesEnTabla = agenda.obtenerLocalidadProvincia();
		this.ventanaLocalidad.llenarTabla(this.localidadesEnTabla);
		this.ventanaLocalidad.mostrarVentana("LOCALIDADES", false);
		// this.ventanaLocalidad.mostrarVentana("LOCALIDADES", false);
	}
	
	private void actualizarLocalidad(ActionEvent p) {

		int idLocalidad = Integer.parseInt(this.ventanaeditarlocalidad.getTxtIdLocalidad().getText());
		String nombre = this.ventanaeditarlocalidad.getTxtNombre().getText();
		int idprovincia = ventanaeditarlocalidad.getJcprovincia().getSelectedIndex() + 1;
		int idpais = ventanaeditarlocalidad.getJcpais().getSelectedIndex() + 1;
		LocalidadDTO localidad_a_editar = new LocalidadDTO(idLocalidad, nombre, idprovincia, idpais);
		this.agenda.editarLocalidad(localidad_a_editar);
		this.refrescarTablaLocalidades();
		this.ventanaeditarlocalidad.cerrar();
	}

	public void borrarLocalidad(ActionEvent s) {
		int[] filasSeleccionadas = this.ventanaLocalidad.getTablaLocalidades().getSelectedRows();
		for (int fila : filasSeleccionadas) {
			int idLocalidad = this.localidadesEnTabla.get(fila).getIdLocalidad();
			this.agenda.borrarLocalidad(idLocalidad);

		}
		this.refrescarTablaLocalidades();
	}

	//------------------configuracion-------------------
	
	public void inicializar() {
		this.refrescarTabla();
		this.vista.show();

	}

	private void refrescarTabla() {
		this.personasEnTabla = agenda.obtenerPersonasDomicilio();
		this.vista.llenarTabla(this.personasEnTabla);
		// this.ventanaDomicilioPersona.llenarCombo(this.localidadesEnTabla); // Cargar
		// Combo Localidades
	}

	private void refrescarTablaTipoContacto() {
		this.tiposContactoEnTabla = agenda.obtenerTipoContacto();
		this.ventanaTipoContacto.llenarTabla(this.tiposContactoEnTabla);
	}

	private void refrescarTablaLocalidades() {
		this.localidadesEnTabla = agenda.obtenerLocalidadProvincia();
		this.ventanaLocalidad.llenarTabla(this.localidadesEnTabla);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
