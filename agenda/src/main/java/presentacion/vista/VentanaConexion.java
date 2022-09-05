package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import persistencia.conexion.Conexion;

public class VentanaConexion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServidor;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtPuerto;
	private JButton btnConectar;

	private static VentanaConexion INSTANCE;

	public static VentanaConexion getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VentanaConexion();
			return new VentanaConexion();
		} else
			return INSTANCE;
	}

	public VentanaConexion() {
		super();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 400, 240);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(10, 10, 113, 14);
		panel.add(lblServidor);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 70, 113, 14);
		lblUsuario.setVisible(true);
		panel.add(lblUsuario);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(10, 100, 113, 14);
		lblContraseña.setVisible(true);
		panel.add(lblContraseña);

		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(10, 40, 113, 14);
		lblContraseña.setVisible(true);
		panel.add(lblPuerto);


		txtServidor = new JTextField();
		txtServidor.setBounds(133, 10, 164, 20);
		panel.add(txtServidor);
		txtServidor.setColumns(10);
		txtServidor.setText("localhost");

		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 70, 164, 20);
		txtUsuario.setVisible(true);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.setText("root");

		txtContraseña = new JTextField();
		txtContraseña.setBounds(133, 100, 164, 20);
		txtContraseña.setVisible(true);
		panel.add(txtContraseña);
		txtContraseña.setColumns(30);
		txtContraseña.setText(" ");

		txtPuerto = new JTextField();
		txtPuerto.setBounds(133, 40, 164, 20);
		txtPuerto.setVisible(true);
		panel.add(txtPuerto);
		txtPuerto.setColumns(30);
		txtPuerto.setText("3306");

		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(110, 135, 100, 30);
		panel.add(btnConectar);

		this.setVisible(false);

	}

	public void mostrarVentana() {
		setTitle("CONEXION DEL SERVIDOR");
		setLocationRelativeTo(null);

		this.setVisible(true);
	}

	public void mostrarMensajeError() {
		JOptionPane.showMessageDialog(null, "Los datos ingresados no son correctos", "Error Conexion",
				JOptionPane.ERROR_MESSAGE);
		Conexion.getConexion().cerrarConexion();
	}

	public void cerrarVentana() {
		this.setVisible(false);
	}

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

	public JTextField getTxtPuerto() {
		return txtPuerto;
	}

	public void setTxtPuerto(JTextField txtPuerto) {
		this.txtPuerto = txtPuerto;
	}

	public void cerrar() {
		this.txtServidor.setText(null);
		this.txtUsuario.setText(null);
		this.txtContraseña.setText(null);
		this.txtPuerto.setText(null);

		this.dispose();
	}

}
