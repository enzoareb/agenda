package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class VentanaConexion extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServidor;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JButton btnConectar;
	//private JButton btnSalir;

	
/* 
	private static VentanaConexion INSTANCE;
	
	public static VentanaConexion getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaConexion(); 	
			return new VentanaConexion();
		}
		else
			return INSTANCE;
	}
*/
	public VentanaConexion() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 400, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(10, 11, 113, 14);
		panel.add(lblServidor);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 33, 113, 14);
		lblUsuario.setVisible(true);
		panel.add(lblUsuario);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(10, 55, 113, 14);
		lblContraseña.setVisible(true);
		panel.add(lblContraseña);


		txtServidor = new JTextField();
		txtServidor.setBounds(133, 11, 164, 20);
		panel.add(txtServidor);
		txtServidor.setColumns(10);
		txtServidor.setText("localhost");

		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 33, 164, 20);
		txtUsuario.setVisible(true);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.setText("root");

		txtContraseña = new JTextField();
		txtContraseña.setBounds(133, 55, 164, 20);
		txtContraseña.setVisible(true);
		panel.add(txtContraseña);
		txtContraseña.setColumns(30);
		txtContraseña.setText(" ");		

		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(133, 100, 100, 30);
		panel.add(btnConectar);
/* 
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(133, 270, 130, 30);
		panel.add(btnSalir);
		btnSalir.setVisible(false);
		*/
	}
	

	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	/* 
	public void mostrarVentana(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarLocalidad.setVisible(estado);
		this.btnAgregarLocalidad.setVisible(!estado);
		this.setVisible(true);
	}

	public void mostrarVentana2(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarLocalidad.setVisible(!estado);
		this.btnAgregarLocalidad.setVisible(estado);
		this.setVisible(true);
	}*/
	
	public JTextField getTxtServidor() {
		return txtServidor;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}
	public JTextField getTxtContraseña() {
		return txtContraseña;
	}


	public JButton getBtnConectar() {
		return btnConectar;
	}

	public void setTxtServidor(String servidor) {
		this.txtServidor.setText(servidor);
	}

	public void setTxtUsuario(String usuario) {
		this.txtUsuario.setText(usuario);
	}

	public void setTxtPass(String pass) {
		this.txtContraseña.setText(pass);
	}




	public void cerrar()
	{
		this.txtServidor.setText(null);
		this.txtUsuario.setText(null);
		this.txtContraseña.setText(null);

		this.dispose();
	}

	
	

	
}

