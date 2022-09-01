package presentacion.vista;


import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.PaisDTO;
import dto.ProvinciaDTO;

public class VentanaEditarLocalidad extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	
	private JTextField txtIdLocalidad;
	private JTextField txtIdProvincia;
	private JTextField txtIdPais;

	private JComboBox<String> jcprovincia; 
	private JComboBox<String> jcpais;

	private JButton btnAgregarLocalidad;
	private JButton btnActualizarLocalidad;

	
	private static VentanaEditarLocalidad INSTANCE;
	
	public static VentanaEditarLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaEditarLocalidad(); 	
			return new VentanaEditarLocalidad();
		}
		else
			return INSTANCE;
	}

	private VentanaEditarLocalidad() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 370);
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
		
		JLabel lblIdLocalidad = new JLabel("IdLocalidad");
		lblIdLocalidad.setBounds(10, 33, 113, 14);
		lblIdLocalidad.setVisible(false);
		panel.add(lblIdLocalidad);

		JLabel lblIdProvincia = new JLabel("IdProvincia");
		lblIdProvincia.setBounds(10, 55, 113, 14);
		lblIdProvincia.setVisible(false);
		panel.add(lblIdProvincia);

		JLabel lblIdPais = new JLabel("IdPais");
		lblIdPais.setBounds(10, 77, 113, 14);
		lblIdPais.setVisible(false);
		panel.add(lblIdPais);

		JLabel lblProvincia = new JLabel("IdProvincia");
		lblProvincia.setBounds(10, 55, 113, 14);
		panel.add(lblProvincia);

		JLabel lblPais = new JLabel("IdPais");
		lblPais.setBounds(10, 121, 113, 14);
		panel.add(lblPais);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 11, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		// IdLocalidad Oculto
		txtIdLocalidad = new JTextField();
		txtIdLocalidad.setBounds(133, 33, 164, 20);
		txtIdLocalidad.setVisible(false);
		panel.add(txtIdLocalidad);
		txtIdLocalidad.setColumns(10);

		// IdProvincia OCULTO
		txtIdProvincia = new JTextField();
		txtIdProvincia.setBounds(133, 55, 164, 20);
		txtIdProvincia.setVisible(false);
		panel.add(txtIdProvincia);
		txtIdProvincia.setColumns(30);
		
		//IdPais OCULTO
		txtIdPais = new JTextField();
		txtIdPais.setBounds(133, 77, 164, 20);
		txtIdPais.setVisible(false);
		panel.add(txtIdPais);
		txtIdPais.setColumns(10);

		jcprovincia = new JComboBox<>();
		jcprovincia.setBounds(133, 55, 164, 20);
		panel.add(jcprovincia);

		jcpais = new JComboBox<>();
		jcpais.setBounds(133, 121, 164, 20);
		panel.add(jcpais);

		btnAgregarLocalidad = new JButton("Guardar");
		btnAgregarLocalidad.setBounds(133, 270, 100, 30);
		panel.add(btnAgregarLocalidad);

		btnActualizarLocalidad = new JButton("Actualizar");
		btnActualizarLocalidad.setBounds(133, 270, 130, 30);
		panel.add(btnActualizarLocalidad);

		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void mostrarVentana(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarLocalidad.setVisible(estado);
		this.btnAgregarLocalidad.setVisible(!estado);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void mostrarVentana2(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarLocalidad.setVisible(!estado);
		this.btnAgregarLocalidad.setVisible(estado);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtIdProvincia() {
		return txtIdProvincia;
	}


	public JTextField getTxtIdPais() {
		return txtIdPais;
	}


	public JComboBox<String> getJcpais() {
		return jcpais;
	}

	public void setJcpais(JComboBox<String> jcpais) {
		this.jcpais = jcpais;
	}
	public JComboBox<String> getJcprovincia() {
		return jcprovincia;
	}

	public void setJcprovincia(JComboBox<String> jcprovincia) {
		this.jcprovincia = jcprovincia;
	}

	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}


	public JButton getBtnActualizarLocalidad() {
		return btnActualizarLocalidad;
	}

	public JTextField getTxtIdLocalidad() {
		return txtIdLocalidad;
	}

	public void setTxtIdLocalidad(String idLocalidad) {
		this.txtIdLocalidad.setText(idLocalidad);
	}

	public void setTxtIdProvincia(String idProvincia) {
		this.txtIdProvincia.setText(idProvincia);
	}

	public void setTxtIdPais(String idPais) {
		this.txtIdPais.setText(idPais);
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

	
	// Parra llenar combo 
	
	public void llenarComboPaises(List<PaisDTO> paises) {
		for (PaisDTO pais : paises)
		{
			this.jcpais.addItem(pais.getNombrePais());
		}
	}

	// Parra llenar combo 
	public void llenarComboProvincias(List<ProvinciaDTO> provinciaList) {
		for (ProvinciaDTO provincia : provinciaList)
		{
			this.jcprovincia.addItem(provincia.getNombreProvincia());
		}
	} 
	

	
}

