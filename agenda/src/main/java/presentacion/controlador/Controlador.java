package presentacion.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;
import modelo.Agenda;

import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaEditarLocalidad;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
//import presentacion.vista.VistaLocalidades;
import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.LocalidadProvinciaDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;
//import dto.ProvinciaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDomicilioDTO> personasEnTabla;
		private VentanaPersona ventanaPersona; 
		private VentanaLocalidad ventanaLocalidad; 
		
		private Agenda agenda;
		private List<LocalidadProvinciaDTO> localidadesEnTabla;
		private VentanaEditarLocalidad ventanaeditarlocalidad;

		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.ventanaPersona = VentanaPersona.getInstance();
			// Guardar
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			// Editar
			this.vista.getBtnEditar().addActionListener(e->ventanaEditarPersona(e));
			this.ventanaPersona.getBtnActualizarPersona().addActionListener(h->editarPersona(h));
			// Localidad
			this.vista.getBtnLocalidad().addActionListener(a->ventanaMostrarLocalidad(a));
			//this.vistaLocalidades = VistaLocalidades.getInstance();
			//this.vistaLocalidades.getBtnAgregar().addActionListener(a->ventanaAgregarLocalidad(a));
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			
			this.agenda = agenda;
			this.ventanaPersona.llenarComboLocalidades(this.agenda.obtenerLocalidad());
			this.ventanaPersona.llenarComboTipos(this.agenda.obtenerTipoContacto());
			this.ventanaPersona.llenarComboDeportes(this.agenda.obtenerDeporte());
			this.ventanaPersona.llenarComboEquipos(this.agenda.obtenerEquipo());

			this.ventanaeditarlocalidad = VentanaEditarLocalidad.getInstance();
			this.ventanaLocalidad.getBtnAgregar().addActionListener(a->ventanaAgregarLocalidad(a));

			this.ventanaeditarlocalidad.llenarComboProvincias(this.agenda.obtenerProvincia());
			this.ventanaeditarlocalidad.llenarComboPaises(this.agenda.obtenerPais());

			//Guardar Localidad
			this.ventanaeditarlocalidad.getBtnAgregarLocalidad().addActionListener(p->guardarLocalidad(p));
			//Editar Localidad
			this.ventanaeditarlocalidad.getBtnActualizarLocalidad().addActionListener(p->actualizarLocalidad(p));
			//Borrar Localidad
			this.ventanaLocalidad.getBtnBorrar().addActionListener(e->borrarLocalidad(e));

			this.ventanaLocalidad.getBtnEditar().addActionListener(e->ventanaEditarLocalidad(e));

		}
		
	//	private void ventanaDomicilioPersona(ActionEvent a) {
			// Aca paso idPersona
	//		int idPersona = Integer.parseInt(this.ventanaPersona.getTxtIdPersona().getText());
	//		this.ventanaDomicilioPersona.mostrarVentanaDomicilio("AGREGAR DOMICILIO",idPersona);
			
	//	}

		private void ventanaMostrarLocalidad(ActionEvent l) {
			this.localidadesEnTabla = agenda.obtenerLocalidadProvincia();
			this.ventanaLocalidad.llenarTabla(this.localidadesEnTabla);
			this.ventanaLocalidad.mostrarVentana("LOCALIDADES", false);
			//this.vistaLocalidades.mostrarVentana("LOCALIDADES");
		}

		private void ventanaAgregarLocalidad(ActionEvent l) {
			//this.localidadesEnTabla = agenda.obtenerLocalidadProvincia();
			//this.ventanaLocalidad.llenarTabla(this.localidadesEnTabla);
			this.ventanaeditarlocalidad.mostrarVentana("NUEVA LOCALIDAD", false);
		}

		private void ventanaAgregarPersona(ActionEvent a) {
		
			this.ventanaPersona.mostrarVentana("NUEVO CONTACTO",false);
		}
		
		// Para Editar Persona
		private void ventanaEditarPersona(ActionEvent e) {
			
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
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
		

			}

			this.ventanaPersona.mostrarVentana2("EDITAR CONTACTO",false);
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
			int idcontacto = ventanaPersona.getJcTipoContacto().getSelectedIndex()+1;
			int idDeporte = ventanaPersona.getJcDeporte().getSelectedIndex()+1;
			int idEquipo = ventanaPersona.getJcEquipo().getSelectedIndex()+1;
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel,email,fechaCumpleaños,idcontacto,idDeporte,idEquipo);
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.guardarDomicilioPersona(p);
			this.ventanaPersona.cerrar();
		}

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
			//int idpersona = personasEnTabla.get(personasEnTabla.size()-1).getIdPersona();
			int idpersona = mayor;
			String calle = ventanaPersona.getTxtDomicilioCalle().getText();
			String altura = ventanaPersona.getTxtDomicilioAltura().getText();
			String piso = ventanaPersona.getTxtDomicilioPiso().getText();
			String depto = ventanaPersona.getTxtDomicilioDpto().getText();
			int idLocalidad = ventanaPersona.getJcLocalidad().getSelectedIndex()+1;
			
			DomicilioDTO nuevoDomicilio = new DomicilioDTO(0, idpersona, calle, altura,piso,depto,idLocalidad);
			this.agenda.agregarDomicilio(nuevoDomicilio);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}


		private void guardarLocalidad(ActionEvent p) {
			String nombre = this.ventanaeditarlocalidad.getTxtNombre().getText();
			int idprov = this.ventanaeditarlocalidad.getJcprovincia().getSelectedIndex()+1;
			int idpais = this.ventanaeditarlocalidad.getJcpais().getSelectedIndex()+1;

			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, nombre,idprov,idpais);
			this.agenda.agregarLocalidad(nuevaLocalidad);
			this.refrescarTablaLocalidades();
			this.ventanaeditarlocalidad.cerrar();
		}


		private void guardarProvincia(ActionEvent p) {

			String nombrelocalidad = ventanaeditarlocalidad.getTxtNombre().getText();

			int idprovincia = ventanaeditarlocalidad.getJcprovincia().getSelectedIndex()+1;
			int idpais = ventanaeditarlocalidad.getJcpais().getSelectedIndex()+1;
			
			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, nombrelocalidad,idprovincia, idpais);
			this.agenda.agregarLocalidad(nuevaLocalidad);
			this.refrescarTabla();
			this.ventanaeditarlocalidad.cerrar();
		}


		// Para Editar Localidad
		private void ventanaEditarLocalidad(ActionEvent e) {
			
			int[] filasSeleccionadas = this.ventanaLocalidad.getTablaLocalidades().getSelectedRows();
				for (int fila : filasSeleccionadas)
				{
					this.ventanaeditarlocalidad.setTxtIdLocalidad(String.valueOf(this.localidadesEnTabla.get(fila).getIdLocalidad()));
					this.ventanaeditarlocalidad.setTxtNombre(this.localidadesEnTabla.get(fila).getNombre());
					this.ventanaeditarlocalidad.setTxtIdProvincia(String.valueOf(this.localidadesEnTabla.get(fila).getIdProvincia()));
					this.ventanaeditarlocalidad.setTxtIdPais(String.valueOf(this.localidadesEnTabla.get(fila).getIdPais()));
		
				}
		
			this.ventanaeditarlocalidad.mostrarVentana2("EDITAR LOCALIDAD",false);
		}



		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				int idPersona = this.personasEnTabla.get(fila).getIdPersona();
				int idDomicilio = this.agenda.findDomicilioByIdPerson(idPersona);
				this.agenda.borrarPersona(idPersona);
				this.agenda.borrarDomicilio(idDomicilio);
			}
			this.refrescarTabla();
		}

		//Editar Persona
		private void editarPersona(ActionEvent h) {

			int idPersona = Integer.parseInt(this.ventanaPersona.getTxtIdPersona().getText());
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
			int idcontacto = ventanaPersona.getJcTipoContacto().getSelectedIndex()+1;
			int idDeporte = ventanaPersona.getJcDeporte().getSelectedIndex()+1;
			int idEquipo = ventanaPersona.getJcEquipo().getSelectedIndex()+1;
			PersonaDTO persona_a_editar = new PersonaDTO(idPersona, nombre, tel,email,fechaCumpleaños,idcontacto,idDeporte,idEquipo);
			this.agenda.editarPersona(persona_a_editar);
		//	this.refrescarTabla();
			this.editarDomicilioPersona(h);
			this.ventanaPersona.cerrar();
	}

		private void editarDomicilioPersona(ActionEvent h) {
			
		int idDomicilio = Integer.parseInt(this.ventanaPersona.getTxtIdDomicilio().getText());
		int idPersona = Integer.parseInt(this.ventanaPersona.getTxtIdPersona().getText());
		String calle = ventanaPersona.getTxtDomicilioCalle().getText();
		String altura = ventanaPersona.getTxtDomicilioAltura().getText();
		String piso = ventanaPersona.getTxtDomicilioPiso().getText();
		String depto = ventanaPersona.getTxtDomicilioDpto().getText();
		int idLocalidad = ventanaPersona.getJcLocalidad().getSelectedIndex()+1;
		
		DomicilioDTO domicilio_a_editar = new DomicilioDTO(idDomicilio, idPersona, calle, altura,piso,depto,idLocalidad);
		this.agenda.editarDomicilio(domicilio_a_editar);
		this.refrescarTabla();
		
	}

	//Actualizar Localidad
	private void actualizarLocalidad(ActionEvent p) {

		int idLocalidad = Integer.parseInt(this.ventanaeditarlocalidad.getTxtIdLocalidad().getText());
		String nombre = this.ventanaeditarlocalidad.getTxtNombre().getText();
		int idprovincia = ventanaeditarlocalidad.getJcprovincia().getSelectedIndex()+1;
		int idpais = ventanaeditarlocalidad.getJcpais().getSelectedIndex()+1;
		LocalidadDTO localidad_a_editar = new LocalidadDTO(idLocalidad, nombre, idprovincia, idpais);
		this.agenda.editarLocalidad(localidad_a_editar);
		this.refrescarTablaLocalidades();
		this.ventanaeditarlocalidad.cerrar();
}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
			
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonasDomicilio();
			this.vista.llenarTabla(this.personasEnTabla);
			//this.ventanaDomicilioPersona.llenarCombo(this.localidadesEnTabla); // Cargar Combo Localidades
		}

		private void refrescarTablaLocalidades()
		{
			this.localidadesEnTabla = agenda.obtenerLocalidadProvincia();
			this.ventanaLocalidad.llenarTabla(this.localidadesEnTabla);
		}

		public void borrarLocalidad(ActionEvent s)
		{
			int[] filasSeleccionadas = this.ventanaLocalidad.getTablaLocalidades().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				int idLocalidad = this.localidadesEnTabla.get(fila).getIdLocalidad();
				this.agenda.borrarLocalidad(idLocalidad);
				
			}
			this.refrescarTablaLocalidades();
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
