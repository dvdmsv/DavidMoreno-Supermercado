package vista.panelusuario;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerGenerarCesta;
import vista.controlador.ListenerSiguienteProducto;

public class Caja extends JPanel{
	private JLabel lblCodProd, lblCantidadProd, lblInfo;
	private JTextField jtfCodProd, jtfCantidadProd;
	private JButton btSiguiente, btGenerar;
	
	public Caja() {
		lblCodProd = new JLabel("Codigo del producto ");
		lblCantidadProd = new JLabel("Cantidad del producto");
		jtfCodProd = new JTextField();
		jtfCantidadProd = new JTextField();
		btSiguiente = new JButton("Siguiente producto");
		btGenerar = new JButton("Generar cesta");
		lblInfo = new JLabel();
		
		this.setLayout(new GridLayout(4, 2));
		this.add(lblCodProd);
		this.add(jtfCodProd);
		
		this.add(lblCantidadProd);
		this.add(jtfCantidadProd);
		
		this.add(btSiguiente);
		this.add(btGenerar);
		this.add(lblInfo);
		
		
		ListenerSiguienteProducto listenerSiguiente = new ListenerSiguienteProducto(this);
		btSiguiente.addActionListener(listenerSiguiente);
		btGenerar.addActionListener(new ListenerGenerarCesta(this, listenerSiguiente));
		
		
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}

	public JTextField getJtfCodProd() {
		return jtfCodProd;
	}

	public JTextField getJtfCantidadProd() {
		return jtfCantidadProd;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}

}
