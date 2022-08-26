package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;



import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaDomicilioPersona;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.DomicilioDTO;
import dto.PersonaDTO;
import dto.PersonaDomicilioDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDomicilioDTO> personasEnTabla;
		//private List<PersonaDTO> personasEnTabla;
		//private List<LocalidadDTO> localidadesEnTabla;
		private VentanaPersona ventanaPersona; 
		private VentanaDomicilioPersona ventanaDomicilioPersona; 
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
			//this.ventanaPersona.getBtnDomicilioPersona().addActionListener(a->ventanaDomicilioPersona(a));
			// Editar
			this.vista.getBtnEditar().addActionListener(a->ventanaEditarPersona(a));
			this.ventanaPersona.getBtnActualizarPersona().addActionListener(p->editarPersona(p));
			// Domicilio
			this.ventanaDomicilioPersona = VentanaDomicilioPersona.getInstance();
			this.ventanaDomicilioPersona.getBtnAgregarDomicilio().addActionListener(p->guardarDomicilioPersona(p));
			
			this.agenda = agenda;
		}
		
	//	private void ventanaDomicilioPersona(ActionEvent a) {
			// Aca paso idPersona
	//		int idPersona = Integer.parseInt(this.ventanaPersona.getTxtIdPersona().getText());
	//		this.ventanaDomicilioPersona.mostrarVentanaDomicilio("AGREGAR DOMICILIO",idPersona);
			
	//	}

		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.llenarComboLocalidades(this.agenda.obtenerLocalidad());
			this.ventanaPersona.llenarComboTipos(this.agenda.obtenerTipoContacto());
			this.ventanaPersona.mostrarVentana("NUEVO CONTACTO",false);
			
		}
		
		// Para Editar Persona
		private void ventanaEditarPersona(ActionEvent a) {
			
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.ventanaPersona.setTxtIdPersona(this.personasEnTabla.get(fila).getIdPersona());
				this.ventanaPersona.setTxtNombre(this.personasEnTabla.get(fila).getNombre());
				this.ventanaPersona.setTxtTelefono(this.personasEnTabla.get(fila).getTelefono());
				this.ventanaPersona.setTxtEmail(this.personasEnTabla.get(fila).getEmail());
				this.ventanaPersona.setTxtFechaCumpleaños(this.personasEnTabla.get(fila).getFechaCumpleaños());
				this.ventanaPersona.setTxtDomicilioCalle(this.personasEnTabla.get(fila).getCalle());
				this.ventanaPersona.setTxtDomicilioAltura(this.personasEnTabla.get(fila).getAltura());
				this.ventanaPersona.setTxtDomicilioPiso(this.personasEnTabla.get(fila).getPiso());
				this.ventanaPersona.setTxtDomicilioDpto(this.personasEnTabla.get(fila).getDepto());
				this.ventanaPersona.setTxtIdDomicilio(this.personasEnTabla.get(fila).getIdDireccion());
				//this.ventanaPersona.setJcLocalidad(this.personasEnTabla.get(fila));

			}

			this.ventanaPersona.mostrarVentana("EDITAR CONTACTO",true);
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
			int idcontacto = ventanaPersona.getJcTipoContacto().getSelectedIndex();
			//String domicilio = ventanaPersona.getTxtDomicilio().getText();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel,email,fechaCumpleaños,idcontacto);
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.guardarDomicilioPersona(p);
			this.ventanaPersona.cerrar();
		}

		private void guardarDomicilioPersona(ActionEvent p) {
			int idpersona = Integer.parseInt(this.ventanaDomicilioPersona.getTxtIdPersona().getText());

			String calle = this.ventanaDomicilioPersona.getTxtCalle().getText();
			String altura = ventanaDomicilioPersona.getTxtAltura().getText();
			String piso = ventanaDomicilioPersona.getTxtPiso().getText();
			String depto = ventanaDomicilioPersona.getTxtDepto().getText();
			int localidad = ventanaDomicilioPersona.getJcLocalidad().getSelectedIndex();
			String tipocontacto = ventanaDomicilioPersona.getTxtTipoContacto().getText();
			
			//String localidad = ventanaDomicilioPersona.getTxtLocalidad().getText();
			//String localidad = "SAN MIGUEL";
			DomicilioDTO nuevoDomicilio = new DomicilioDTO(0, idpersona, calle, altura,piso,depto,localidad,tipocontacto);
			this.agenda.agregarDomicilio(nuevoDomicilio);
			this.refrescarTabla();
			this.ventanaDomicilioPersona.cerrar();
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
				//this.agenda.borrarPersona(this.personasEnTabla.get(fila));
				
			}
			
			this.refrescarTabla();
		}

		//Editar Persona
		private void editarPersona(ActionEvent p) {
		
			String id = this.ventanaPersona.getTxtIdPersona().getText(); 
			int idpersona = Integer.parseInt(id.trim());
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
			int idcontacto = ventanaPersona.getJcTipoContacto().getSelectedIndex();
			//String domicilio = ventanaPersona.getTxtDomicilio().getText();
			PersonaDTO persona = new PersonaDTO(idpersona, nombre, tel,email,fechaCumpleaños,idcontacto);
			this.agenda.editarPersona(persona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
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
