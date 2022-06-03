package vista.login;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
/**
 * Clase que contiene un JPanel con la contrase�a del usuario
 * @author David
 *
 */
public class Contrasena extends JPanel{
	/**
	 * JLabel que indica que el campo a su derecha es el de la contrase�a
	 */
	private JLabel lb1;
	/**
	 * JPasswordField que contiene la contrase�a de usuario
	 */
	private JPasswordField jpswf;
	/**
	 * Constructor de Contrasena
	 */
	public Contrasena() {
		lb1 = new JLabel("Password");
		this.add(lb1);
		
		jpswf = new JPasswordField(5);
		jpswf.setBackground(Color.decode("#70d0d0"));
		jpswf.setBorder(null);
		this.add(jpswf);
	
		this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		this.setLayout(null);
		
		
		this.setLayout(new GridLayout(1, 2));

		this.setBackground(Color.decode("#04FCFC"));
	}
	/**
	 * Metodo para obtener la contrase�a 
	 * @return jpswf
	 */
	public JPasswordField getJpswf() {
		return jpswf;
	}

}
