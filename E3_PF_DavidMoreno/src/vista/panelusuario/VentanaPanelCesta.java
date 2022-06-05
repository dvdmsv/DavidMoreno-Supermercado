package vista.panelusuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import vista.controlador.ListenerEliminarProdCesta;
import vista.controlador.ListenerFinalizarCompra;
import vista.controlador.ListenerSiguienteProducto;
/**
 * JFrame que contiene la cesta con los productos que se han ido pasando por caja
 * @author David
 *
 */
public class VentanaPanelCesta extends JFrame {
	/**
	 * Tabla que contiene los productos de la cesta
	 */
	private JTable tabla;
	/**
	 * Modelo con los datos de los productos
	 */
	private DefaultTableModel modelo;
	/**
	 * Array con los datos de los productos
	 */
	Object [] data = new Object[5];
	/**
	 * Boton para finalizar la compra 
	 */
	private JButton finalizar;
	/**
	 * Boton para eliminar productos de la tabla
	 */
	private JButton eliminar;
	/**
	 * JLabel que va indicando el precio total de todos los productos en la tabla
	 */
	private JLabel total;
	/**
	 * Constructor de VentanaPanelCesta, recibe como parametro ListenerSiguienteProducto
	 * @param listenerSiguiente Clase que contiene los productos que se han ido pasando por caja
	 */
	public VentanaPanelCesta(ListenerSiguienteProducto listenerSiguiente) {
		super("GALDI -Panel de cesta-");
		
		JScrollPane scrollPane = new JScrollPane();
		this.getContentPane().add(scrollPane);
		String [] columnas = {"Nombre producto", "Cantidad Producto", "Precio producto", "IVA producto", "Precio total del producto"};
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
		
		JPanel Panelfinalizar = new JPanel();
		Panelfinalizar.setLayout(new GridLayout(3,1));
		Panelfinalizar.setBorder(BorderFactory.createEmptyBorder(50,200,50,200));
		
		total = new JLabel();
		Panelfinalizar.add(total);
		
		finalizar = new JButton("Finalizar compra");
		finalizar.addActionListener(new ListenerFinalizarCompra(this, listenerSiguiente));
		Panelfinalizar.add(finalizar);
		
		eliminar = new JButton("Eliminar producto");
		eliminar.addActionListener(new ListenerEliminarProdCesta(this, listenerSiguiente));
		Panelfinalizar.add(eliminar);
		
		
		this.getContentPane().add(Panelfinalizar);
		
		this.setLayout(new GridLayout(2, 1));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	/**
	 * Metodo que devuelve el array con los datos de los productos
	 * @return data
	 */
	public Object[] getData() {
		return data;
	}
	/**
	 * Metodo que devuelve el modelo que contiene los productos en la tabla
	 * @return modelo
	 */
	public DefaultTableModel getModelo() {
		return modelo;
	}
	/**
	 * Metodo que devuelve el JLabel que informará del precio total de todos los productos en la tabla
	 * @return total
	 */
	public JLabel getTotal() {
		return total;
	}
	/**
	 * Metodo que devuelve la tabla
	 * @return tabla
	 */
	public JTable getTabla() {
		return tabla;
	}
}
