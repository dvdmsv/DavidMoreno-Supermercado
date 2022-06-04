package vista.panelusuario;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
/**
 * Clase que contiene la ventana de los usuarios que no son administrador
 * @author David
 *
 */
public class VentanaPanelUsuario extends JFrame{
	/**
	 * JPanel con el contenido de los usuarios que no son administradores
	 */
	private PanelUsuario panelUsuario;
	/**
	 * JMenuBar que contiene un boton para cerrar sesion
	 */
	private JMenuBar menu;
	/**
	 * Constructor de VentanaPanelUsuario
	 */
	public VentanaPanelUsuario() {
		super("GALDI -Panel Usuario-");
		panelUsuario = new PanelUsuario();
		this.getContentPane().add(panelUsuario);

		menu = new CerrarSesion(this);
		this.setJMenuBar(menu);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
