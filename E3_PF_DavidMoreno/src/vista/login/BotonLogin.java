package vista.login;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerLimpiarLogin;
import vista.controlador.ListenerLogin;
/**
 * Clase que contiene un JPanel con los botones para limpiar los campos e iniciar el proceso de login
 * @author David
 *
 */
public class BotonLogin extends JPanel{
	/**
	 * JButton para limpiar y loguearse
	 */
	private JButton b1, b2;
	/**
	 * JPanel que contiene el nombre de usuario
	 */
	private Usuario usuario;
	/**
	 * JPanel que contiene la contraseña del usuario
	 */
	private Contrasena contrasena;
	/**
	 * JPanel que contiene el mensaje de error ante mal logueo
	 */
	private MensajeError mensajeErr;
	/**
	 * Listener que contiene la logica para loguearse
	 */
	private ListenerLogin lisLog;
	/**
	 * Listener que contiene la logica para limpiar los campos de texto
	 */
	private ListenerLimpiarLogin limpLogin;
	/**
	 * Ventana que contiene el login
	 */
	private VentanaLogin vL;
	/**
	 * Constructor de BotonLogin
	 * @param usuario JPanel que contiene el nombre de usuario
	 * @param contrasena JPanel que contiene la contraseña
	 * @param mensajeErr JPanel que contiene el mensaje de error
	 * @param vL ventana de login
	 */
	public BotonLogin(Usuario usuario, Contrasena contrasena, MensajeError mensajeErr,  VentanaLogin vL) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.mensajeErr=mensajeErr;
		this.vL = vL;
		this.setBackground(Color.decode("#04FCFC"));
		
		b1 = new JButton("Iniciar Sesion");
		this.add(b1);
		
		b2 = new JButton("Limpiar");
		this.add(b2);
		
		
		lisLog = new ListenerLogin(usuario, contrasena, mensajeErr, vL);
		b1.addActionListener(lisLog);
		
		limpLogin = new ListenerLimpiarLogin(usuario, contrasena, mensajeErr);
		b2.addActionListener(limpLogin);	
	}
}
