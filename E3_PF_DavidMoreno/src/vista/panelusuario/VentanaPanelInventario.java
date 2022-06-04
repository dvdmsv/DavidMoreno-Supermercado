package vista.panelusuario;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 * Clase que contiene el JFrame con la ventana del inventario
 * @author David
 *
 */
public class VentanaPanelInventario extends JFrame {
	/**
	 * Tabla que contiene los productos en el inventario
	 */
	private JTable tabla;
	/**
	 * Modelo que contiene los datos del inventario
	 */
	private DefaultTableModel modelo;
	/**
	 * Array donde se guardan los datos del inventario
	 */
	Object [] data = new Object[6];
	/**
	 * Constructor de VentanaPanelInvenrario
	 */
	public VentanaPanelInventario() {
		super("GALDI -Panel de inventario-");
		
		JScrollPane scrollPane = new JScrollPane();
		this.getContentPane().add(scrollPane);
		String [] columnas = {"Codigo producto", "Nombre producto", "Familia producto", "Cantidad Producto", "Precio producto", "IVA producto"};
		
		modelo = new DefaultTableModel(null, columnas) { //Se instancia el modelo para introducir datos en la tabla
			@Override	//Se sobreescribe el comportamiento para que las celdas no se puedan editar
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabla = new JTable(modelo);
		tabla.setBackground(Color.decode("#04FCFC"));
		scrollPane.setViewportView(tabla);
		
		TableRowSorter<DefaultTableModel> ordena = new TableRowSorter<DefaultTableModel>(modelo); //Objeto que ordena la tabla 
		tabla.setRowSorter(ordena); //Se le añade a la tabla
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	/**
	 * Metodo que devuelve la tabla
	 * @return tabla
	 */
	public JTable getTabla() {
		return tabla;
	}
	/**
	 * Metodo que devuelve el modelo con los datos
	 * @return modelo
	 */
	public DefaultTableModel getModelo() {
		return modelo;
	}
	/**
	 * Metodo que devuelve el array con los datos
	 * @return data
	 */
	public Object[] getData() {
		return data;
	}
}
