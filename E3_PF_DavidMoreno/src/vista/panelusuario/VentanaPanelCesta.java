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

public class VentanaPanelCesta extends JFrame {
	private JTable tabla;
	private DefaultTableModel modelo;
	Object [] data = new Object[5];
	private JButton finalizar, eliminar;
	private JLabel total;
	public VentanaPanelCesta() {
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
		Panelfinalizar.add(finalizar);
		
		eliminar = new JButton("Eliminar producto");
		eliminar.addActionListener(new ListenerEliminarProdCesta(this));
		Panelfinalizar.add(eliminar);
		
		
		this.getContentPane().add(Panelfinalizar);
		
		this.setLayout(new GridLayout(2, 1));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public Object[] getData() {
		return data;
	}
	
	public DefaultTableModel getModelo() {
		return modelo;
	}
	
	public JLabel getTotal() {
		return total;
	}
	
	public JTable getTabla() {
		return tabla;
	}
}
