package presentacion.vista;


import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.DeporteDTO;
import dto.EquipoDTO;
import dto.LocalidadDTO;
import dto.TipoContactoDTO;

public class VentanaPersona extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtFechaCumpleaños;
	private JTextField txtIdPersona;
	private JTextField txtIdDomicilio;

	private JTextField txtDomicilioCalle;
	private JTextField txtDomicilioAltura;
	private JTextField txtDomicilioPiso;
	private JTextField txtDomicilioDpto;

	private JComboBox<String> jcLocalidad; 
	private JComboBox<String> jcTipoContacto;
	private JComboBox<String> jcDeporte; 
	private JComboBox<String> jcEquipo;
	private JButton btnAgregarPersona;
	private JButton btnActualizarPersona;


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
		setBounds(100, 100, 643, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 840, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(325, 11, 113, 14);
		panel.add(lblEmail);

		JLabel lblFechaCumpleaños = new JLabel("Cumpleaños");
		lblFechaCumpleaños.setBounds(325, 52, 113, 14);
		panel.add(lblFechaCumpleaños);

		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 93, 113, 14);
		panel.add(lblDomicilio);
		
		JLabel lblDomicilioCalle = new JLabel("Calle");
		lblDomicilioCalle.setBounds(10, 134, 113, 14);
		panel.add(lblDomicilioCalle);
		
		JLabel lblDomicilioAltura = new JLabel("Altura");
		lblDomicilioAltura.setBounds(10, 175, 113, 14);
		panel.add(lblDomicilioAltura);
		
		JLabel lblDomicilioPiso = new JLabel("Piso");
		lblDomicilioPiso.setBounds(325, 134, 113, 14);
		panel.add(lblDomicilioPiso);

		JLabel lblDomicilioDpto = new JLabel("Dpto");
		lblDomicilioDpto.setBounds(325, 175, 113, 14);
		panel.add(lblDomicilioDpto);
		
		JLabel lblDomicilioLocalidad = new JLabel("Localidad");
		lblDomicilioLocalidad.setBounds(10, 216, 113, 14);
		panel.add(lblDomicilioLocalidad);

		JLabel lblTipoContacto = new JLabel("Tipo Contacto");
		lblTipoContacto.setBounds(325, 216, 113, 14);
		panel.add(lblTipoContacto);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(10, 257, 113, 14);
		panel.add(lblDeporte);

		JLabel lblEquipo = new JLabel("Equipo Futbol");
		lblEquipo.setBounds(325, 257, 113, 14);
		panel.add(lblEquipo);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		// IdPersona Oculto
		txtIdPersona = new JTextField();
		txtIdPersona.setBounds(133, 30, 164, 20);
		txtIdPersona.setVisible(false);
		panel.add(txtIdPersona);
		txtIdPersona.setColumns(10);

		// IdDomicilio OCULTO
		txtIdDomicilio = new JTextField();
		txtIdDomicilio.setBounds(133, 93, 164, 20);
		txtIdDomicilio.setVisible(false);
		panel.add(txtIdDomicilio);
		txtIdDomicilio.setColumns(30);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(430, 8, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		txtFechaCumpleaños = new JTextField();
		txtFechaCumpleaños.setBounds(430, 49, 164, 20);
		panel.add(txtFechaCumpleaños);
		txtFechaCumpleaños.setColumns(10);

		txtDomicilioCalle = new JTextField();
		txtDomicilioCalle.setBounds(133, 134, 164, 20);
		panel.add(txtDomicilioCalle);
		txtDomicilioCalle.setColumns(10);

		txtDomicilioAltura = new JTextField();
		txtDomicilioAltura.setBounds(133, 175, 164, 20);
		panel.add(txtDomicilioAltura);
		txtDomicilioAltura.setColumns(10);

		txtDomicilioPiso = new JTextField();
		txtDomicilioPiso.setBounds(430, 134, 164, 20);
		panel.add(txtDomicilioPiso);
		txtDomicilioPiso.setColumns(10);

		txtDomicilioDpto = new JTextField();
		txtDomicilioDpto.setBounds(430, 175, 164, 20);
		panel.add(txtDomicilioDpto);
		txtDomicilioDpto.setColumns(10);
		
		jcLocalidad = new JComboBox<>();
		jcLocalidad.setBounds(133, 216, 164, 20);
		panel.add(jcLocalidad);

		jcTipoContacto = new JComboBox<>();
		jcTipoContacto.setBounds(430, 216, 164, 20);
		panel.add(jcTipoContacto);

		jcDeporte = new JComboBox<>();
		jcDeporte.setBounds(133, 257, 164, 20);
		panel.add(jcDeporte);

		jcEquipo = new JComboBox<>();
		jcEquipo.setBounds(430, 257, 164, 20);
		panel.add(jcEquipo);

		btnAgregarPersona = new JButton("Guardar");
		btnAgregarPersona.setBounds(490, 290, 100, 30);
		panel.add(btnAgregarPersona);

		btnActualizarPersona = new JButton("Actualizar");
		btnActualizarPersona.setBounds(460, 290, 130, 30);
		panel.add(btnActualizarPersona);

		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public void mostrarVentana(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarPersona.setVisible(estado);
		this.btnAgregarPersona.setVisible(!estado);
		this.setVisible(true);
	}

	public void mostrarVentana2(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnActualizarPersona.setVisible(!estado);
		this.btnAgregarPersona.setVisible(estado);
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtIdPersona() 
	{
		return txtIdPersona;
	}

	public JTextField getTxtIdDomicilio(){
		return txtIdDomicilio;
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

	

	public JTextField getTxtDomicilioCalle() {
		return txtDomicilioCalle;
	}

	public JTextField getTxtDomicilioAltura() {
		return txtDomicilioAltura;
	}

	public JTextField getTxtDomicilioPiso() {
		return txtDomicilioPiso;
	}

	public JTextField getTxtDomicilioDpto() {
		return txtDomicilioDpto;
	}

	public JComboBox<String> getJcLocalidad() {
		return jcLocalidad;
	}

	public JComboBox<String> getJcTipoContacto() {
		return jcTipoContacto;
	}
	

	public JComboBox<String> getJcDeporte() {
		return jcDeporte;
	}

	public JComboBox<String> getJcEquipo() {
		return jcEquipo;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public JButton getBtnActualizarPersona() 
	{
		return btnActualizarPersona;
	}
	

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtEmail.setText(null);
		this.txtFechaCumpleaños.setText(null);
		this.txtIdPersona.setText(null);
		this.txtDomicilioAltura.setText(null);
		this.txtDomicilioCalle.setText(null);
		this.txtDomicilioPiso.setText(null);
		this.txtDomicilioDpto.setText(null);

		this.dispose();
	}

	// Seters
    public void setTxtNombre(String nombre) {
		this.txtNombre.setText(nombre);
	}

	public void setTxtIdPersona(String idPersona) {
		this.txtIdPersona.setText(idPersona);
	}

	public void setTxtIdDomicilio(Integer idDomicilio) {
		String id = idDomicilio.toString();
		this.txtIdDomicilio.setText(id);
	}

    public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}

    public void setTxtTelefono(String telefono) {
		this.txtTelefono.setText(telefono);
    }

    public void setTxtFechaCumpleaños(String fechaCumpleaños) {
		this.txtFechaCumpleaños.setText(fechaCumpleaños);
    }

	public void setTxtIdPersona(Integer idPersona) {
		String id = idPersona.toString();
		this.txtIdPersona.setText(id);
	}

	public void setTxtDomicilioCalle(String domicilioCalle) {
		this.txtDomicilioCalle.setText(domicilioCalle);
    }
	public void setTxtDomicilioAltura(String domicilioAltura) {
		this.txtDomicilioAltura.setText(domicilioAltura);
    }
	public void setTxtDomicilioPiso(String domicilioPiso) {
		this.txtDomicilioPiso.setText(domicilioPiso);
    }
	public void setTxtDomicilioDpto(String domicilioDpto) {
		this.txtDomicilioDpto.setText(domicilioDpto);
    }
	public void setJcTipoContacto(JComboBox<String> jcTipoContacto) {
		this.jcTipoContacto = jcTipoContacto;
	}
	public void setJcLocalidad(JComboBox<String> jcLocalidad) {
		this.jcLocalidad = jcLocalidad;
	}
	public void setJcDeporte(JComboBox<String> jcDeporte) {
		this.jcDeporte = jcDeporte;
	}

	public void setJcEquipo(JComboBox<String> jcEquipo) {
		this.jcEquipo = jcEquipo;
	}
    
	// Parra llenar combo 
	
	public void llenarComboLocalidades(List<LocalidadDTO> localidades) {
		for (LocalidadDTO localidad : localidades)
		{
			this.jcLocalidad.addItem(localidad.getNombre());
		}
	}

	// Parra llenar combo 
	public void llenarComboTipos(List<TipoContactoDTO> tiposcontactolList) {
		for (TipoContactoDTO tipoContacto : tiposcontactolList)
		{
			this.jcTipoContacto.addItem(tipoContacto.getNombreTipo());
		}
	} 
	public void llenarComboDeportes(List<DeporteDTO> deporteslList) {
			for (DeporteDTO deporte : deporteslList)
			{
				this.jcDeporte.addItem(deporte.getNombre());
			}
		}
	public void llenarComboEquipos(List<EquipoDTO> equipoList) {
		for (EquipoDTO equipo : equipoList)
		{
			this.jcEquipo.addItem(equipo.getNombre());
		}
	}
	
}

