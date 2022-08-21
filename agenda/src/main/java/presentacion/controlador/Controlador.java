package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;



import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaDomicilioPersona;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.Domicilio;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
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
			this.ventanaPersona.getBtnDomicilioPersona().addActionListener(a->ventanaDomicilioPersona(a));
			// Editar
			this.vista.getBtnEditar().addActionListener(a->ventanaEditarPersona(a));
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->editarPersona(p));
			// Domicilio
			this.ventanaDomicilioPersona = VentanaDomicilioPersona.getInstance();
			this.ventanaDomicilioPersona.getBtnAgregarDomicilio().addActionListener(p->guardarDomicilioPersona(p));
			
			this.agenda = agenda;
		}
		
		private void ventanaDomicilioPersona(ActionEvent a) {
			this.ventanaDomicilioPersona.mostrarVentanaDomicilio();
	
		}

		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana("NUEVO CONTACTO",false);
			
		}
		
		// Editar
		private void ventanaEditarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana("EDITAR CONTACTO",true);
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel,email,fechaCumpleaños);
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}

		private void guardarDomicilioPersona(ActionEvent p) {
			String calle = this.ventanaDomicilioPersona.getTxtCalle().getText();
			String altura = ventanaDomicilioPersona.getTxtAltura().getText();
			String piso = ventanaDomicilioPersona.getTxtPiso().getText();
			String depto = ventanaDomicilioPersona.getTxtDepto().getText();
			//String localidad = ventanaDomicilioPersona.getJcLocalidad().getSelectedItem().toString();
			String localidad = ventanaDomicilioPersona.getTxtLocalidad().getText();
			Domicilio nuevoDomicilio = new Domicilio(0, calle, altura,piso,depto,localidad);
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
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}

		//Editar Persona
		private void editarPersona(ActionEvent p) {
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.editarPersona(this.personasEnTabla.get(fila));
			}
//			
			
//			Integer idpersona = p.getID(); //  this.ventanaPersona.get
//			String nombre = this.ventanaPersona.getTxtNombre().getText();
//			String tel = ventanaPersona.getTxtTelefono().getText();
//			String email = ventanaPersona.getTxtEmail().getText();
//			String fechaCumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
//			PersonaDTO persona = new PersonaDTO(idpersona, nombre, tel,email,fechaCumpleaños);
//			this.agenda.editarPersona(persona);
//			this.refrescarTabla();
//			this.ventanaPersona.cerrar();
	}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
