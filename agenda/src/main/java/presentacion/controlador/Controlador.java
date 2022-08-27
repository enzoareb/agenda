package presentacion.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;
import modelo.Agenda;

import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.DomicilioDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDomicilioDTO> personasEnTabla;
		private VentanaPersona ventanaPersona; 
		private VentanaLocalidad ventanaLocalidad; 
		private Agenda agenda;

		
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
			this.vista.getBtnLocalidad().addActionListener(l->ventanaAgregarLocalidad(l));
			this.ventanaLocalidad = ventanaLocalidad.getInstance();
			
			this.agenda = agenda;
			this.ventanaPersona.llenarComboLocalidades(this.agenda.obtenerLocalidad());
			this.ventanaPersona.llenarComboTipos(this.agenda.obtenerTipoContacto());
			this.ventanaPersona.llenarComboDeportes(this.agenda.obtenerDeporte());
			this.ventanaPersona.llenarComboEquipos(this.agenda.obtenerEquipo());
		}
		
	//	private void ventanaDomicilioPersona(ActionEvent a) {
			// Aca paso idPersona
	//		int idPersona = Integer.parseInt(this.ventanaPersona.getTxtIdPersona().getText());
	//		this.ventanaDomicilioPersona.mostrarVentanaDomicilio("AGREGAR DOMICILIO",idPersona);
			
	//	}

		private void ventanaAgregarLocalidad(ActionEvent l) {
			this.ventanaLocalidad.mostrarVentana("NUEVA LOCALIDAD", false);
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
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
			
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonasDomicilio();
			//this.personasEnTabla = agenda.obtenerPersonas();
			//this.vista.llenarTabla(this.personasEnTabla);
			this.vista.llenarTabla(this.personasEnTabla);
			
			
			//this.localidadesEnTabla = agenda.obtenerLocalidad();
			//this.ventanaDomicilioPersona.llenarCombo(this.localidadesEnTabla); // Cargar Combo Localidades
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
