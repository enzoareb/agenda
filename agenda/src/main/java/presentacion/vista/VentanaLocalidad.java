package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.LocalidadDTO;


public class VentanaLocalidad extends JFrame 
{ 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtLocalidad;

	private JButton btnAgregar;

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
		setBounds(100, 100, 343, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 11, 113, 14);
		panel.add(lblLocalidad);

		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(133, 8, 164, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(133, 50, 100, 23);
		panel.add(btnAgregar);
	
		this.setVisible(false);
	}
	
	public void mostrarVentana(String titulo, boolean estado)
	{
		this.setTitle(titulo);
		this.btnAgregar.setVisible(!estado);
		this.setVisible(true);
	}


		
	


	public void cerrar()
	{
	
		this.txtLocalidad.setText(null);
		this.btnAgregar.setEnabled(false);
		this.dispose();
	}


	
	
}

