package vista.panelusuario;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inventario extends JPanel {
	private JLabel NomProd, lblNomProd, lblCodProd, lblFamProd, lblCantProd, lblPrecProd, lblIVAProd;
	private JTextField jtfNomProd;
	
	public Inventario() {
		lblNomProd = new JLabel("Nombre del producto");
		jtfNomProd = new JTextField("");
		

		lblCodProd = new JLabel("Codigo: ");
		lblNomProd = new JLabel("Nombre: ");
		lblFamProd = new JLabel("Familia: ");
		lblCantProd = new JLabel("Cantidad: ");
		lblPrecProd = new JLabel("Precio: ");
		lblIVAProd = new JLabel("IVA: ");
		
		//this.setPreferredSize(new Dimension(500,400));
		this.setLayout(new GridLayout(7, 1));
		
		
		this.add(lblNomProd);
		this.add(jtfNomProd);
		
		
		this.add(lblCodProd);
		this.add(lblNomProd);
		this.add(lblFamProd);
		this.add(lblCantProd);
		this.add(lblPrecProd);
		this.add(lblIVAProd);
		
		
		
	}

}
