package vista.panelusuario;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerGenerarCesta;
import vista.controlador.ListenerSiguienteProducto;
/**
 * Clase que contiene el JPanel de la pestaña de Caja
 * @author David
 *
 */
public class Caja extends JPanel{
	/**
	 * JLabel que indica que el codigo de producto se escribe en el campo a su derecha
	 */
	private JLabel lblCodProd;
	/**
	 * JLabel que indica que el nombre de producto se escribe en el campo a su derecha
	 */
	private JLabel lblCantidadProd;
	/**
	 * JLabel que indica que infroma sobre errores
	 */
	private JLabel lblInfo;
	/**
	 * JTextField que almacenara el codigo de producto
	 */
	private JTextField jtfCodProd;
	/**
	 * JTextField que almacenara la cantidad de producto
	 */
	private JTextField jtfCantidadProd;
	/**
	 * JButton que introducirá el producto en la cesta y limpará los campos para el siguiente
	 */
	private JButton btSiguiente;
	/**
	 * JButton que genera la cesta 
	 */
	private JButton btGenerar;
	/**
	 * Constructor de Caja
	 */
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
	/**
	 * Metodo que devuelve el JTextField con el codigo del producto
	 * @return jtfCodProd
	 */
	public JTextField getJtfCodProd() {
		return jtfCodProd;
	}
	/**
	 * Metodo que devuelve la cantidad de producto introducida
	 * @return jtfCantidadProd
	 */
	public JTextField getJtfCantidadProd() {
		return jtfCantidadProd;
	}
	/**
	 * Metodo que devuelve el JLabel que informa al usuario
	 * @return lblInfo
	 */
	public JLabel getLblInfo() {
		return lblInfo;
	}

}
