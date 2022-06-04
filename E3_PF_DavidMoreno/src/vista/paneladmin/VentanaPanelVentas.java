package vista.paneladmin;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 * Clase que contiene la ventana con la tabla de ventas realizadas
 * @author David
 *
 */
public class VentanaPanelVentas extends JFrame{
	/**
	 * Tabla que contiene las ventas
	 */
	private JTable tabla;
	/**
	 * Modelo que contiene los datos de las ventas
	 */
	private DefaultTableModel modelo;
	/**
	 * Array que contiene los datos
	 */
	Object [] data = new Object[6];
	/**
	 * Constructor de VentanaPanelVentas
	 */
	public VentanaPanelVentas() {
		super("GALDI -Panel de ventas-");
		
		JScrollPane scrollPane = new JScrollPane();
		this.getContentPane().add(scrollPane);
		String [] columnas = {"Numero de venta", "Cosigo de producto", "Nombre de producto", "Cantidad de producto", "Fecha de venta", "Numero de empleado"};
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
	 * Metodo que devueve la tabla
	 * @return tabla contiene las filas y columnas con los datos
	 */
	public JTable getTabla() {
		return tabla;
	}
	/**
	 * Metodo que contiene los datos a mostrar
	 * @return modelo contiene los datos
	 */
	public DefaultTableModel getModelo() {
		return modelo;
	}
	/**
	 * Array que contiene los datos
	 * @return data contiene los datos
	 */
	public Object[] getData() {
		return data;
	}
}
