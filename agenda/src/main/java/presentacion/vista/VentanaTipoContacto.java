package presentacion.vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.TipoContactoDTO;

public class VentanaTipoContacto extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLocalidad;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JTable tablaTipoContacto;
	private DefaultTableModel modelTipoContacto;
	private String[] nombreColumnas = { "Id", "NombreTipo" };

	private static VentanaTipoContacto INSTANCE;

	public static VentanaTipoContacto getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VentanaTipoContacto();
			return new VentanaTipoContacto();
		} else
			return INSTANCE;
	}

	private VentanaTipoContacto() {
		super();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 440, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 500, 307);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 11, 113, 14);
		lblLocalidad.setVisible(false);
		panel.add(lblLocalidad);

		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(133, 8, 164, 20);
		txtLocalidad.setVisible(false);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(50, 220, 100, 25);
		panel.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(160, 220, 100, 25);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(270, 220, 100, 25);
		panel.add(btnBorrar);

		JScrollPane spTipoContacto = new JScrollPane();
		spTipoContacto.setBounds(10, 11, 400, 200);
		panel.add(spTipoContacto);

		modelTipoContacto = new DefaultTableModel(null, nombreColumnas);
		tablaTipoContacto = new JTable(modelTipoContacto);

		tablaTipoContacto.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaTipoContacto.getColumnModel().getColumn(0).setResizable(false);
		tablaTipoContacto.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaTipoContacto.getColumnModel().getColumn(1).setResizable(false);

		spTipoContacto.setViewportView(tablaTipoContacto);

		this.setVisible(false);
	}

	public void mostrarVentana(String titulo, boolean estado) {
		this.setTitle(titulo);
		this.btnAgregar.setVisible(!estado);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public DefaultTableModel getModelTipoContacto() {
		return modelTipoContacto;
	}

	public JTable getTablaTipoContacto() {
		return tablaTipoContacto;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void llenarTabla(List<TipoContactoDTO> TiposContactoEnTabla) {
		this.getModelTipoContacto().setRowCount(0); // Para vaciar la tabla
		this.getModelTipoContacto().setColumnCount(0);
		this.getModelTipoContacto().setColumnIdentifiers(this.getNombreColumnas());

		for (TipoContactoDTO p : TiposContactoEnTabla) {
			int idTipocontacto = p.getIdTipoContacto();
			String nombre = p.getNombreTipo();

			Object[] fila = { idTipocontacto, nombre };

			this.getModelTipoContacto().addRow(fila);

		}

	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void cerrar() {

		this.txtLocalidad.setText(null);
		this.btnAgregar.setEnabled(false);
		this.dispose();
	}

}
