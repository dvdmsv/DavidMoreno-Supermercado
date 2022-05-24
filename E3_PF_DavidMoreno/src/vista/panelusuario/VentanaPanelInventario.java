package vista.panelusuario;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class VentanaPanelInventario extends JFrame {
	private JTable tabla;
	private DefaultTableModel modelo;
	Object [] data = new Object[6];
	
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
	
	public JTable getTabla() {
		return tabla;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public Object[] getData() {
		return data;
	}
}
