package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.LocalidadDTO;
//import modelo.Agenda;

public class VentanaDomicilioPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JTextField txtLocalidad;
	private JTextField txtIdPersona;
	private JComboBox<String> jcLocalidad; 
	private JButton btnAgregarDomicilio;
//	private List<LocalidadDTO> localidadesEnTabla;
	//private Agenda agenda;
	
	
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

		txtIdPersona = new JTextField();
		txtIdPersona.setBounds(133, 30, 164, 20);
		panel.add(txtIdPersona);
		txtIdPersona.setColumns(10);
		txtIdPersona.setVisible(false);
		
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

		//txtLocalidad = new JTextField();
		//txtLocalidad.setBounds(133, 169, 164, 20);
		//panel.add(txtLocalidad);
		//txtLocalidad.setColumns(10);

		jcLocalidad = new JComboBox<>();
		jcLocalidad.setBounds(133, 169, 164, 20);
		jcLocalidad.addItem("SAN MIGUEL");
		jcLocalidad.addItem("MALVINAS");
		jcLocalidad.addItem("MUÑIZ");
		panel.add(jcLocalidad);
		
		btnAgregarDomicilio = new JButton("Agregar Domicilio");
		btnAgregarDomicilio.setBounds(133, 192, 164, 23);
		panel.add(btnAgregarDomicilio);

		//this.localidadesEnTabla = agenda.obtenerLocalidad();
		//this.llenarCombo(this.localidadesEnTabla); // Cargar Combo Localidades
	
		this.setVisible(false);
	}
	
	public void mostrarVentanaDomicilio(String titulo, Integer idPersona)
	{
		this.setTitle(titulo);
		this.txtIdPersona.setText(idPersona.toString());
	
		this.setVisible(true);
	}
	
	public JComboBox<String> getJcLocalidad() {
		return jcLocalidad;
	}

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

	public JTextField getTxtIdPersona() {
		return txtIdPersona;
	}

	public void setTxtIdPersona(JTextField txtIdPersona) {
		this.txtIdPersona = txtIdPersona;
	}


	public void llenarCombo(List<LocalidadDTO> localidadEnTabla) {

		for (LocalidadDTO l : localidadEnTabla)
		{
			//int idlocalidad = l.getIdLocalidad();
			String nombre = l.getNombre();
			//int idprovincia = l.getIdProvincia();
			//int idpais = l.getIdPais();
			//String fila = {idlocalidad,nombre,};
			jcLocalidad.addItem(nombre);
			
			
		
		}
		
	}


	public void cerrar()
	{
		this.txtCalle.setText(null);
		this.txtAltura.setText(null);
		this.txtPiso.setText(null);
		this.txtDepto.setText(null);
		this.jcLocalidad.setSelectedItem(null);
		this.dispose();
	}


	
	
}

