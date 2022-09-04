package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import dto.DeporteDTO;
import dto.DomicilioDTO;
import dto.EquipoDTO;
import dto.LocalidadDTO;
import dto.LocalidadProvinciaDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;
import dto.ProvinciaDTO;
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

	//-----------------------------persona----------------------------------

	private void ventanaAgregarPersona(ActionEvent a) {

		this.ventanaPersona.mostrarVentana("NUEVO CONTACTO", false);
	}

	private void ventanaEditarPersona(ActionEvent e) {

		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		if (filasSeleccionadas.length == 1) {

			for (int fila : filasSeleccionadas) {
				
				int idPersona = this.personasEnTabla.get(fila).getIdPersona();
				
				PersonaDTO personaDTO = this.agenda.findPersonaById(idPersona);
				this.ventanaPersona.setTxtIdPersona(idPersona);
				this.ventanaPersona.setTxtNombre(personaDTO.getNombre());
				this.ventanaPersona.setTxtTelefono(personaDTO.getTelefono());
				this.ventanaPersona.setTxtEmail(personaDTO.getEmail());
				this.ventanaPersona.setTxtFechaCumpleaños(personaDTO.getFechaCumpleaños());
				
				DomicilioDTO domicilioDTO = this.agenda.findDomicilioById(personaDTO.getIdPersona());
				this.ventanaPersona.setTxtIdDomicilio(domicilioDTO.getidDomicilio());
				this.ventanaPersona.setTxtDomicilioCalle(domicilioDTO.getCalle());
				this.ventanaPersona.setTxtDomicilioAltura(domicilioDTO.getAltura());
				this.ventanaPersona.setTxtDomicilioPiso(domicilioDTO.getPiso());
				this.ventanaPersona.setTxtDomicilioDpto(domicilioDTO.getDepto());

				LocalidadDTO localidadDTO = this.agenda.findLocalidadById(domicilioDTO.getIdLocalidad());
				this.ventanaPersona.getJcLocalidad().setSelectedItem(localidadDTO.getNombre());

				TipoContactoDTO tipoContactoDTO = this.agenda.findTipoContactoById(personaDTO.getIdcontacto());
				this.ventanaPersona.getJcTipoContacto().setSelectedItem(tipoContactoDTO.getNombreTipo());
				
				DeporteDTO deporteDTO = this.agenda.findDeporteById(personaDTO.getIdDeporte());
				this.ventanaPersona.getJcDeporte().setSelectedItem(deporteDTO.getNombre());

				EquipoDTO equipoDTO = this.agenda.findEquipoById(personaDTO.getIdEquipo());
				this.ventanaPersona.getJcEquipo().setSelectedItem(equipoDTO.getNombre());
				
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
		PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, fechaCumpleaños, idcontacto, idDeporte, idEquipo);
		this.agenda.agregarPersona(nuevaPersona);
		this.refrescarTabla();
		this.guardarDomicilio();
		this.ventanaPersona.cerrar();
	}

	public void borrarPersona(ActionEvent s) {
		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		for (int fila : filasSeleccionadas) {
			int idPersona = this.personasEnTabla.get(fila).getIdPersona();
			DomicilioDTO domicilioDTO = this.agenda.findDomicilioById(idPersona);
			int idDomicilio = domicilioDTO.getidDomicilio();
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
		this.editarDomicilio();
		this.ventanaPersona.cerrar();
	}

	//-------------------------domicilio----------------------------

	private void guardarDomicilio() {
		List<PersonaDTO> personas = this.agenda.obtenerPersonas();
		List<Integer> ids = obtenerIdsPersonas(personas);
		int idpersona = obtenerUltimoId(ids);
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

	private void editarDomicilio() {

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
		if (filasSeleccionadas.length == 1) {
			for (int fila : filasSeleccionadas) {

				int idLocalidad = this.localidadesEnTabla.get(fila).getIdLocalidad();
				
				LocalidadDTO localidadDTO = this.agenda.findLocalidadById(idLocalidad);
				this.ventanaeditarlocalidad.setTxtIdLocalidad(String.valueOf(idLocalidad));
				this.ventanaeditarlocalidad.setTxtNombre(localidadDTO.getNombre());

				ProvinciaDTO provinciaDTO = this.agenda.findProvById(localidadDTO.getIdProvincia());
				this.ventanaeditarlocalidad.getJcprovincia().setSelectedItem(provinciaDTO.getNombreProvincia());
				
				PaisDTO paisDTO = this.agenda.findPaisById(localidadDTO.getIdPais());
				this.ventanaeditarlocalidad.getJcpais().setSelectedItem(paisDTO.getNombrePais());
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
			if (filasSeleccionadas.length == 1) {
	
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
	
	
	//------------------configuracion vista-------------------
	
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

	//---------------------auxiliares-----------------------------

	private List<Integer> obtenerIdsPersonas(List<PersonaDTO> personas) {
		List<Integer> ids = new ArrayList<>();
		for (PersonaDTO personaDTO : personas) {
			ids.add(personaDTO.getIdPersona());
		}
		return ids;
	}

	private int obtenerUltimoId(List<Integer> ids) {
		int mayor = ids.get(0);
		for (int x = 1; x < ids.size(); x++) {
			if (ids.get(x) > mayor) {
				mayor = ids.get(x);
			}
		}
		return mayor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
