package vista.login;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que contiene un JPanel para ubicar el metodo de entrada para el nombre de usuario
 * @author David
 *
 */
public class Usuario extends JPanel{
	/**
	 * JLabel que informa que el campo a su derecha es para introducir el nombre de usuario
	 */
	private JLabel lb1;
	/**
	 * JTextField para almacenar el nombre del usuario
	 */
	private JTextField jtf;
	/**
	 * String que almacena el nombre de usuario que se ha logueado
	 */
	private static String usuarioLogueado;
	/**
	 * Constructor de Usuario
	 */
	public Usuario() {
		lb1 = new JLabel("Nombre de usuario ");
		this.add(lb1);
		
		jtf = new JTextField(5);
		jtf.setBackground(Color.decode("#70d0d0"));
		jtf.setBorder(null);
		this.add(jtf);
		this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		
		this.setLayout(new GridLayout(1, 2));
		this.setBackground(Color.decode("#04FCFC"));
	}
	/**
	 * Metodo que obtiene el JTextField que contiene el nombre de usuario
	 * @return jtf
	 */
	public JTextField getJtf() {
		return jtf;
	}
	/**
	 * Metodo que establece que usuario se ha logueado
	 * @param usuarioLogueado usuario que se ha logueado en el programa
	 */
	public static void setUsuarioLogueado(String usuarioLogueado) {
		Usuario.usuarioLogueado = usuarioLogueado;
	}
	
	/**
	 * Metodo que obtiene el usuario que se ha logueado
	 * @return usuarioLogueado 
	 */
	public static String getUsuarioLogueado() {
		return usuarioLogueado;
	}
}
