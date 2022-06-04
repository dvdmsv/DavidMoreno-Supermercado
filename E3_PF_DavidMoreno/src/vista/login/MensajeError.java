package vista.login;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Clase que contiene un JLabel que informará sobre errores en el login
 * @author David
 *
 */
public class MensajeError extends JPanel {
	/**
	 * JLabel que informara de errores
	 */
	private JLabel lb;
	/**
	 * Constructor de MensajeError
	 */
	public MensajeError() {
		lb = new JLabel();
		
		this.add(lb);
		this.setBackground(Color.decode("#04FCFC"));
	}
	/**
	 * Metodo que devuelve el JLabel que indica errores
	 * @return lb 
	 */
	public JLabel getLb() {
		return lb;
	}
}
