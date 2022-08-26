package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import dto.PersonaDomicilioDTO;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import persistencia.conexion.Conexion;


public class Vista
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JButton btnLocalidad;
	private JButton btnReporte;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"Id","Nombre y apellido","Telefono","Email","Cumpleaños","Calle","Altura","Piso","Depto","Localidad","Contacto"};

	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("AGENDA");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 950, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 900, 200);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar Contacto");
		btnAgregar.setBounds(10, 220, 160, 30);
		panel.add(btnAgregar);
		
		//Botón Editar
		btnEditar = new JButton("Editar Contacto");
		btnEditar.setBounds(180, 220, 150, 30);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar Contacto");
		btnBorrar.setBounds(340, 220, 150, 30);
		panel.add(btnBorrar);
		
		btnLocalidad = new JButton("Agregar Localidad");
		btnLocalidad.setBounds(500, 220, 170, 30);
		panel.add(btnLocalidad);

		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(800, 220, 100, 30);
		panel.add(btnReporte);
	}
	
	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Estás seguro que quieres salir de la Agenda?", 
		             "Confirmación", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnEditar() 
	{
		return btnEditar;
	}

	public AbstractButton getBtnLocalidad() {
		return btnLocalidad;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}

	// Llenar Tabla. Controlador. 
	public void llenarTabla(List<PersonaDomicilioDTO> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (PersonaDomicilioDTO p : personasEnTabla)
		{
			int idpersona = p.getIdPersona();
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			String email = p.getEmail();
			String fechaCumpleaños = p.getFechaCumpleaños();
			String calle = p.getCalle();
			String altura = p.getAltura();
			String piso = p.getPiso();
			String depto = p.getDepto();
			String localidad = p.getLocalidad();				
			String tipocontacto = p.getTipocontacto();

			Object[] fila = {idpersona, nombre, tel,email,fechaCumpleaños,calle,altura,piso,depto,localidad,tipocontacto};
			

			this.getModelPersonas().addRow(fila);
			
		
		}
		
	}




}
