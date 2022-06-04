package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerBuscarVenta;
/**
 * Clase que contiene el JPanel para buscar las ventas
 * @author David
 *
 */
public class Ventas extends JPanel{
	/**
	 * JLabel que informa de que el campo debajo es para introducir datos para buscar
	 */
	private JLabel lblBuscar;
	/**
	 * JTextField que contiene los datos con los que buscar
	 */
	private JTextField jtfDatos;
	/**
	 * Boton para buscar por codigo de producto
	 */
	private JButton buscarCodProd;
	/**
	 * Boton para buscar por codigo de usuario
	 */
	private JButton buscarCodUsu;
	/**
	 * Constructor de la clase Ventas
	 */
	public Ventas() {
		lblBuscar = new JLabel("Buscar venta");
		jtfDatos = new JTextField();
		buscarCodProd = new JButton("Buscar ventas por codigo de producto");
		buscarCodUsu = new JButton("Buscar ventas por codigo de usuario");
		
		buscarCodProd.addActionListener(new ListenerBuscarVenta(this, 1));
		buscarCodUsu.addActionListener(new ListenerBuscarVenta(this, 2));
		
		this.add(lblBuscar);
		this.add(jtfDatos);
		this.add(buscarCodProd);
		this.add(buscarCodUsu);
		
		this.setLayout(new GridLayout(5,1));
		this.setPreferredSize(new Dimension(800,200));
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}
	/**
	 * Metodo que devuelve el JTextField con los datos a buscar
	 * @return jtfDatos contiene los datos que se quieren buscar
	 */
	public JTextField getJtfDatos() {
		return jtfDatos;
	}
}
