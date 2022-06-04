package vista.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 * Clase que crea una ventana sobre la cual los usuarios se loguearan
 * @author David
 *
 */
public class VentanaLogin extends JFrame {
	/**
	 * JPanel que contiene el login
	 */
	private PanelLogin pl = new PanelLogin(this);
	/**
	 * JPanel que contiene la imagen de fondo
	 */
	private FondoImagen fondo = new FondoImagen();
	/**
	 * Constructor de la ventana para loguearse
	 */
	public VentanaLogin() {
		super("GALDI -Login-");
		
		this.setPreferredSize(new Dimension(500,400));
		this.setBackground(Color.decode("#04FCFC"));
		this.setContentPane(fondo);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.getContentPane().add(pl);
		this.pack();
	}
}
