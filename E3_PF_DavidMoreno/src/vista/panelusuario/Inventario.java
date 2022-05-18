package vista.panelusuario;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inventario extends JPanel {
	private JLabel lblNomProd, infoProd;
	private JTextField jtfNomProd;
	
	public Inventario() {
		lblNomProd = new JLabel("Nombre del producto");
		jtfNomProd = new JTextField("");
		infoProd = new JLabel();
		
		this.setLayout(new GridLayout());
		
		this.add(lblNomProd);
		this.add(jtfNomProd);
		this.add(infoProd);
		
		
	}

}
