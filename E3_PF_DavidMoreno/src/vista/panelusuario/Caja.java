package vista.panelusuario;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerGenerarCesta;

public class Caja extends JPanel{
	private JLabel lblCodProd, lblCantidadProd;
	private JTextField jtfCodProd, jtfCantidadProd;
	private JButton btSiguiente, btGenerar;
	
	public Caja() {
		lblCodProd = new JLabel("Codigo del producto ");
		lblCantidadProd = new JLabel("Cantidad del producto");
		jtfCodProd = new JTextField();
		jtfCantidadProd = new JTextField();
		btSiguiente = new JButton("Siguiente producto");
		btGenerar = new JButton("Generar cesta");
		
		this.setLayout(new GridLayout(3, 2));
		this.add(lblCodProd);
		this.add(jtfCodProd);
		
		this.add(lblCantidadProd);
		this.add(jtfCantidadProd);
		
		this.add(btSiguiente);
		this.add(btGenerar);
		
		btGenerar.addActionListener(new ListenerGenerarCesta(this));
		
		
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}

}
