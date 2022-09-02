package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import dto.LocalidadDTO;
import dto.LocalidadProvinciaDTO;


public class VentanaLocalidad extends JFrame 
{ 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLocalidad;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JTable tablaLocalidades;
	private DefaultTableModel modelLocalidades;
	private  String[] nombreColumnas = {"Id","Nombre","Provincia","Pais"};

	private static VentanaLocalidad INSTANCE;
	
	public static VentanaLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaLocalidad(); 	
			return new VentanaLocalidad();
		}
		else
			return INSTANCE;
	}

	private VentanaLocalidad() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 500, 307);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 11, 113, 14);
		lblLocalidad.setVisible(false);
		panel.add(lblLocalidad);

		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(133, 8, 164, 20);
		txtLocalidad.setVisible(false);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(50, 220, 100, 25);
		panel.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(160, 220, 100, 25);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(270, 220, 100, 25);
		panel.add(btnBorrar);

		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 400, 200);
		panel.add(spPersonas);

		modelLocalidades = new DefaultTableModel(null,nombreColumnas);
		tablaLocalidades = new JTable(modelLocalidades);
		
		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);
		tablaLocalidades.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaLocalidades.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaLocalidades);

	
		this.setVisible(false);
	}
	
	public void mostrarVentana(String titulo, boolean estado)
	{
		this.setTitle(titulo);
		this.btnAgregar.setVisible(!estado);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public DefaultTableModel getModelLocalidades() 
	{
		return modelLocalidades;
	}
	
	public JTable getTablaLocalidades()
	{
		return tablaLocalidades;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}

	public void llenarTabla(List<LocalidadProvinciaDTO> localidadesEnTabla) {
		this.getModelLocalidades().setRowCount(0); //Para vaciar la tabla
		this.getModelLocalidades().setColumnCount(0);
		this.getModelLocalidades().setColumnIdentifiers(this.getNombreColumnas());

		for (LocalidadProvinciaDTO p : localidadesEnTabla)
		{
			int idlocalidad = p.getIdLocalidad();
			String nombre = p.getNombre();
			int idprovincia = p.getIdProvincia();
			int idpais = p.getIdPais();
			String nombreprovincia = p.getNombreProvincia();
			String nombrepais = p.getNombrePais();

			Object[] fila = {idlocalidad, nombre, nombreprovincia, nombrepais,idprovincia,idpais};
			

			this.getModelLocalidades().addRow(fila);
			
		
		}
		
	}
		
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}


	public void cerrar()
	{
	
		this.txtLocalidad.setText(null);
		this.btnAgregar.setEnabled(false);
		this.dispose();
	}


	
	
}

