package presentacion.vista;

//import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnActualizarLocalidad;
	private JButton btnAgregarLocalidad;
	private JComboBox<String> jcProvincia;
	private JComboBox<String> jcPais;
	

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
		setBounds(100, 100, 343, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 113, 14);
		panel.add(lblNombre);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 52, 113, 14);
		panel.add(lblProvincia);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 93, 113, 14);
		panel.add(lblPais);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
	

		jcProvincia = new JComboBox<>();
		jcProvincia.setBounds(133, 49, 164, 20);
		jcProvincia.addItem("BUENOS AIRES");
		jcProvincia.addItem("CABA");
		jcProvincia.addItem("CORDOBA");
		jcProvincia.addItem("SAN LUIS");
		jcProvincia.addItem("RIO NEGRO");
		panel.add(jcProvincia);


		jcPais = new JComboBox<>();
		jcPais.setBounds(133, 89, 164, 20);
		jcPais.addItem("ARGENTINA");
		jcPais.addItem("CHILE");
		jcPais.addItem("URUGUAY");
		jcPais.addItem("BRASIL");
		jcPais.addItem("BOLIVIA");
		panel.add(jcPais);

		
		btnAgregarLocalidad = new JButton("Guardar");
		btnAgregarLocalidad.setBounds(208, 192, 89, 23);
		panel.add(btnAgregarLocalidad);

		btnActualizarLocalidad = new JButton("Actualizar");
		btnActualizarLocalidad.setBounds(208, 192, 95, 23);
		btnActualizarLocalidad.setVisible(false);
		panel.add(btnActualizarLocalidad);

	
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public void mostrarVentana(String titulo, boolean estado) {
		this.setTitle(titulo);
	//	this.btnDomicilioPersona.setEnabled(estado);
	//	this.btnActualizarPersona.setVisible(estado);
	//	this.btnAgregarPersona.setVisible(!estado);
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}


	public JButton getBtnAgregarLocalidad() 
	{
		return btnAgregarLocalidad;
	}

	public JButton getBtnActualizarLocalidad() 
	{
		return btnActualizarLocalidad;
	}
	

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.jcProvincia.setSelectedItem(null);
		this.jcPais.setSelectedItem(null);
		this.dispose();
	}

	// Seters
    public void setTxtNombre(String nombre) {
		this.txtNombre.setText(nombre);
	}



  
	
}

