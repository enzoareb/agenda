package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtFechaCumpleaños;
	private JButton btnAgregarPersona;
	private JButton btnDomicilioPersona;
	private static VentanaPersona INSTANCE;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
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
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 93, 113, 14);
		panel.add(lblEmail);

		JLabel lblFechaCumpleaños = new JLabel("Cumpleaños");
		lblFechaCumpleaños.setBounds(10, 134, 113, 14);
		panel.add(lblFechaCumpleaños);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(133, 89, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		txtFechaCumpleaños = new JTextField();
		txtFechaCumpleaños.setBounds(133, 129, 164, 20);
		panel.add(txtFechaCumpleaños);
		txtFechaCumpleaños.setColumns(10);
		
		btnAgregarPersona = new JButton("Guardar");
		btnAgregarPersona.setBounds(208, 192, 89, 23);
		panel.add(btnAgregarPersona);

		btnDomicilioPersona = new JButton("Domicilio");
		btnDomicilioPersona.setBounds(100, 192, 90, 23);
		panel.add(btnDomicilioPersona);

		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public void mostrarVentana(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnDomicilioPersona.setEnabled(estado);
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtFechaCumpleaños() {
		return txtFechaCumpleaños;
	}

	// Seters
	public void setTxtNombre(JTextField nombre) 
	{
		this.txtNombre = nombre;
	}

	public void setTxtTelefono(JTextField telefono) 
	{
		this.txtTelefono = telefono;
	}

	public void setTxtEmail(JTextField email) {
		this.txtEmail = email;
	}

	public void setTxtFechaCumpleaños(JTextField cumple) {
		this.txtFechaCumpleaños = cumple;
	}


	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	// Domicilio
	public JButton getBtnDomicilioPersona() 
	{
		return btnDomicilioPersona;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtEmail.setText(null);
		this.txtFechaCumpleaños.setText(null);
		this.dispose();
	}


	
}

