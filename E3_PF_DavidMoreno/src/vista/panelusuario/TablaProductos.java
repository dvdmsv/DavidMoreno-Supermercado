package vista.panelusuario;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaProductos extends JPanel{
	private JTable tablaProd;
	private String[] nomColum = {"CODIGO PRODUCTO", "NOMBRE PRODUCTO", "FAMILIA PRODUCTO", "CANTIDAD PRODUCTO", "PRECIO PRODUCTO", "IVA PRODUCTO"};
	private Object[][] nomProd;
	
	public TablaProductos() {
		tablaProd = new JTable(nomProd, nomColum);
		add(new JScrollPane(tablaProd), BorderLayout.CENTER);
		this.add(tablaProd);
	}
	

}
