package vista.paneladmin;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * Clase que contiene el JFame con el panel para los usuarios que son administradores
 * @author David
 *
 */
public class VentanaPanelAdmin extends JFrame{
	/**
	 * JPanel con las opciones de los usuarios administradores
	 */
	private PanelAdmin panelAdmin;
	/**
	 * JMenuBar con el boton para cerrar sesion
	 */
	private JMenuBar menu;
	/**
	 * Constructor de VentanaPanelAdmin
	 */
	public VentanaPanelAdmin() {
		super("GALDI -Panel de Admin-");
		panelAdmin = new PanelAdmin();
		this.getContentPane().add(panelAdmin);

		menu = new CerrarSesion(this);
		this.setJMenuBar(menu);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}