package vista.panelusuario;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Caja extends JPanel{
	private JLabel lblCodProd, lblCantidadProd;
	private JTextField jtfCodProd, jtfCantidadProd;
	private JButton btSiguiente, btFinalizar;
	
	public Caja() {
		lblCodProd = new JLabel("Codigo del producto ");
		lblCantidadProd = new JLabel("Cantidad del producto");
		jtfCodProd = new JTextField();
		jtfCantidadProd = new JTextField();
		btSiguiente = new JButton("Siguiente producto");
		btFinalizar = new JButton("Finalizar compra");
		
		this.setLayout(new GridLayout(3, 2));
		this.add(lblCodProd);
		this.add(jtfCodProd);
		
		this.add(lblCantidadProd);
		this.add(jtfCantidadProd);
		
		this.add(btSiguiente);
		this.add(btFinalizar);
		
		
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
		
		
		
	}

}
