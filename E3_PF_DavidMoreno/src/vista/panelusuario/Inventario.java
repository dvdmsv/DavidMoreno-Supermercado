package vista.panelusuario;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerBuscarProducto;
/**
 * Clase que contiene el JPanel encargado de buscar el inventario
 * @author David
 *
 */
public class Inventario extends JPanel {
	/**
	 * JLabel que indica el nombre del producto
	 */
	private JLabel nomProd;
	/**
	 * JTextField que almacenará el nombre del campo que se quiere buscar
	 */
	private JTextField jtfNomProd;
	/**
	 * Boton para buscar por nombre
	 */
	private JButton buscarNom;
	/**
	 * Boton para buscar por codigo
	 */
	private JButton buscarCod;
	/**
	 * Boton para buscar por familia
	 */
	private JButton buscarFam;
	/**
	 * Constructor de Inventario
	 */
	public Inventario() {
		nomProd = new JLabel("Producto");
		jtfNomProd = new JTextField("");
		buscarNom = new JButton("Buscar producto por nombre");
		buscarCod = new JButton("Buscar producto por codigo");
		buscarFam = new JButton("Buscar producto por familia");
		
		
		this.add(nomProd);
		this.add(jtfNomProd);
		this.add(buscarNom);
		this.add(buscarCod);
		this.add(buscarFam);
		buscarNom.addActionListener(new ListenerBuscarProducto(this, 1));
		buscarCod.addActionListener(new ListenerBuscarProducto(this, 2));
		buscarFam.addActionListener(new ListenerBuscarProducto(this, 3));
		
		
		this.setLayout(new GridLayout(5,1));
		this.setPreferredSize(new Dimension(800,200));
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}
	
	/**
	 * Metodo que devuelve el JTextField con lo que se quiere consultar
	 * @return jtfNomProd
	 */
	public JTextField getJtfNomProd() {
		return jtfNomProd;
	}
}
