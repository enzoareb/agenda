package presentacion.vista;

import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaDomicilioPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JTextField txtLocalidad;
	//private JComboBox jcLocalidad; 
	


	private JButton btnAgregarDomicilio;
	
	private static VentanaDomicilioPersona INSTANCE;
	
	public static VentanaDomicilioPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaDomicilioPersona(); 	
			return new VentanaDomicilioPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaDomicilioPersona() 
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
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 11, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 52, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 93, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 134, 113, 14);
		panel.add(lblDepto);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 175, 113, 14);
		panel.add(lblLocalidad);

		txtCalle = new JTextField();
		txtCalle.setBounds(133, 8, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(133, 49, 164, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);

		txtPiso = new JTextField();
		txtPiso.setBounds(133, 89, 164, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);

		txtDepto = new JTextField();
		txtDepto.setBounds(133, 129, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);

		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(133, 169, 164, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);

		//jcLocalidad = new JComboBox<>();
		//jcLocalidad.setBounds(133, 169, 164, 20);
		//panel.add(jcLocalidad);
		
		btnAgregarDomicilio = new JButton("Agregar Domicilio");
		btnAgregarDomicilio.setBounds(133, 192, 164, 23);
		panel.add(btnAgregarDomicilio);

	
		this.setVisible(false);
	}
	
	public void mostrarVentanaDomicilio()
	{
		this.setVisible(true);
	}
	
	//public JComboBox getJcLocalidad() {
	//	return jcLocalidad;
	//}

	public JTextField getTxtCalle() 
	{
		return txtCalle;
	}

	public JTextField getTxtAltura() 
	{
		return txtAltura;
	}

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	public JTextField getTxtDepto() {
		return txtDepto;
	}

	public JTextField getTxtLocalidad() {
		return txtLocalidad;
	}

	// Domicilio
	public JButton getBtnAgregarDomicilio() 
	{
		return btnAgregarDomicilio;
	}

	public void cerrar()
	{
		this.txtCalle.setText(null);
		this.txtAltura.setText(null);
		this.txtPiso.setText(null);
		this.txtDepto.setText(null);
		this.txtLocalidad.setText(null);
		this.dispose();
	}
	
}

