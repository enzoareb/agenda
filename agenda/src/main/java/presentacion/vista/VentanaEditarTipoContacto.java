package presentacion.vista;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class VentanaEditarTipoContacto extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	
	private JTextField txtIdTipoContacto;

	private JButton btnAgregarTipoContacto;
	private JButton btnActualizarTipoContacto;
	
	private static VentanaEditarTipoContacto INSTANCE;
	
	public static VentanaEditarTipoContacto getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaEditarTipoContacto(); 	
			return new VentanaEditarTipoContacto();
		}
		else
			return INSTANCE;
	}

	private VentanaEditarTipoContacto() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 400, 853);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 113, 14);
		panel.add(lblNombre);
		
		JLabel lblIdTipoContacto = new JLabel("IdTipoContacto");
		lblIdTipoContacto.setBounds(10, 33, 113, 14);
		lblIdTipoContacto.setVisible(false);
		panel.add(lblIdTipoContacto);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 11, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		// txtIdTipoContacto Oculto
		txtIdTipoContacto = new JTextField();
		txtIdTipoContacto.setBounds(133, 33, 164, 20);
		txtIdTipoContacto.setVisible(false);
		panel.add(txtIdTipoContacto);
		txtIdTipoContacto.setColumns(10);

		btnAgregarTipoContacto = new JButton("Guardar");
		btnAgregarTipoContacto.setBounds(133, 100, 100, 30);
		panel.add(btnAgregarTipoContacto);

		btnActualizarTipoContacto = new JButton("Actualizar");
		btnActualizarTipoContacto.setBounds(133, 100, 130, 30);
		panel.add(btnActualizarTipoContacto);

		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public void mostrarVentana(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarTipoContacto.setVisible(estado);
		this.btnAgregarTipoContacto.setVisible(!estado);
		this.setVisible(true);
	}

	public void mostrarVentana2(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarTipoContacto.setVisible(!estado);
		this.btnAgregarTipoContacto.setVisible(estado);
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtIdTipoContacto() {
		return txtIdTipoContacto;
	}
	
	public JButton getBtnAgregarTipoContacto() {
		return btnAgregarTipoContacto;
	}

	public JButton getBtnActualizarTipoContacto() {
		return btnActualizarTipoContacto;
	}


	public void cerrar()
	{
		this.txtNombre.setText(null);

		this.dispose();
	}

	// Seters
    public void setTxtNombre(String nombre) {
		this.txtNombre.setText(nombre);
	}

	public void setTxtIdTipoContacto(String txtIdTipoContacto) {
		this.txtIdTipoContacto.setText(txtIdTipoContacto);
	}
	
	
}

