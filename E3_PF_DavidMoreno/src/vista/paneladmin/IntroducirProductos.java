package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerIntroducirProd;
import vista.controlador.ListenerLimpiarCamposProd;
/**
 * Clase que contiene el panel para introducir productos en el inventario
 * @author David
 *
 */
public class IntroducirProductos extends JPanel{
	/**
	 * JLabel que indica que el campo a su derecha es el del nombre del producto
	 */
	private JLabel lblNomProd; 
	/**
	 * JLabel que indica que el campo a su derecha es el de la familia del producto
	 */
	private JLabel lblFamProd;
	/**
	 * JLabel que indica que el campo a su derecha es el de la cantidad del producto
	 */
	private JLabel lblCantProd; 
	/**
	 * JLabel que indica que el campo a su derecha es el del precio del producto
	 */
	private JLabel lblPrecProd; 
	/**
	 * JLabel que indica que el campo a su derecha es el del IVA del producto
	 */
	private JLabel lblIVAProd;
	/**
	 * JLabel que indica sobre posibles errores en la inserción de campos
	 */
	private JLabel lblInfo;
	/**
	 * JTextField que almacena el nombre del producto
	 */
	private JTextField jtfNomProd;
	/**
	 * JTextField que almacena la familia del producto
	 */
	private JTextField jtfFamProd;
	/**
	 * JTextField que almacena el cantidad del producto
	 */
	private JTextField jtfCantProd; 
	/**
	 * JTextField que almacena el precio del producto
	 */
	private JTextField jtfPrecProd;
	/**
	 * Boton para introducir el producto en la base de datos
	 */
	private JButton btIntro; 
	/**
	 * Boton para limpiar los campos
	 */
	private JButton btLimpiar;
	/**
	 * JComboBox de opciones con el IVA de productos
	 */
	private JComboBox<String> jcIVAProd;
	
	public IntroducirProductos() {
		lblNomProd = new JLabel("Nombre del producto");
		lblFamProd = new JLabel("Familia del producto");
		lblCantProd = new JLabel("Cantidad del producto");
		lblPrecProd = new JLabel("Precio del producto");
		lblIVAProd = new JLabel("IVA del producto");
		lblInfo = new JLabel();
		
		jtfNomProd = new JTextField();
		jtfFamProd = new JTextField();
		jtfCantProd = new JTextField();
		jtfPrecProd = new JTextField();
		
		btIntro = new JButton("Introducir producto");
		btIntro.addActionListener(new ListenerIntroducirProd(this));
		
		btLimpiar = new JButton("Limpiar");
		btLimpiar.addActionListener(new ListenerLimpiarCamposProd(this));

		jcIVAProd = new JComboBox<String>();
		jcIVAProd.addItem("");
		jcIVAProd.addItem("4%");
		jcIVAProd.addItem("10%");
		jcIVAProd.addItem("21%");
		
		
		this.setLayout(new GridLayout(7,2));
		this.add(lblNomProd);
		this.add(jtfNomProd);
		
		this.add(lblFamProd);
		this.add(jtfFamProd);
		
		this.add(lblCantProd);
		this.add(jtfCantProd);
		
		this.add(lblPrecProd);
		this.add(jtfPrecProd);
		
		this.add(lblIVAProd);
		this.add(jcIVAProd);
		
		this.add(btIntro);
		this.add(btLimpiar);
		
		this.add(lblInfo);
		
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}
	/**
	 * Metodo que devuelve el JTextField con el nombre del producto
	 * @return jtfNomProd contiene el nombre del producto
	 */
	public JTextField getJtfNomProd() {
		return jtfNomProd;
	}
	/**
	 * Metodo que devuelve el JTextField con la familia
	 * @return jtfFamProd contiene la familia del producto
	 */
	public JTextField getJtfFamProd() {
		return jtfFamProd;
	}
	/**
	 * Metodo que devuelve el JTextField con la cantidad del producto
	 * @return jtfCantProd contiene la cantidad del producto
	 */
	public JTextField getJtfCantProd() {
		return jtfCantProd;
	}
	/**
	 * Metodo que devuelve el JTextField con el precio del producto
	 * @return jtfPrecProd contiene el precio del producto
	 */
	public JTextField getJtfPrecProd() {
		return jtfPrecProd;
	}
	/**
	 * Metodo que devuelve el JComboBox con los IVA
	 * @return jcIVAProd contiene el IVA que se ha seleccionado
	 */
	public JComboBox<String> getJcIVAProd() {
		return jcIVAProd;
	}
	/**
	 * Metodo que devuelve el JLabel con informacion sobre errores
	 * @return lblInfo contiene informacion sobre errores de insercion de datos
	 */
	public JLabel getLblInfo() {
		return lblInfo;
	}
}
