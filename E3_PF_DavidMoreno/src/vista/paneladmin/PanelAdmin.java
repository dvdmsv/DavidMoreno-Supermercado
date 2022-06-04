package vista.paneladmin;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import vista.panelusuario.Caja;
import vista.panelusuario.Inventario;
/**
 * Clase que contiene el JPanel de los usuarios administrador
 * @author David
 *
 */
public class PanelAdmin extends JPanel{
	/**
	 * Pestaña de caja
	 */
	private Caja caja;
	/**
	 * Pestaña de inventario
	 */
	private Inventario inventario;
	/**
	 * Pestaña de gestionar usuarios
	 */
	private GestionarUsuarios gestionarUsu;
	/**
	 * Pestaña de introducir productos
	 */
	private IntroducirProductos introProd;
	/**
	 * Pestaña de ventas
	 */
	private Ventas ventas;
	/**
	 * Contructor de PanelAdmin
	 */
	public PanelAdmin() {
		JTabbedPane jtp = new JTabbedPane();
		caja = new Caja();
		inventario = new Inventario();
		gestionarUsu = new GestionarUsuarios();
		introProd = new IntroducirProductos();
		ventas = new Ventas();
		
		jtp.add("Caja", caja);
		jtp.add("Inventario", inventario);
		jtp.add("Gestionar Usuarios", gestionarUsu);
		jtp.add("Introducir productos", introProd);
		jtp.add("Ventas", ventas);
		
		this.add(jtp);
		this.setBackground(Color.decode("#04FCFC"));
		this.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
	}
}
