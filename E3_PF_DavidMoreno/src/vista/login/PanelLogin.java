package vista.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
/**
 * Clase que reune en un JPanel todos los objetos para que el usuario se loguee
 * @author David
 *
 */
public class PanelLogin extends JPanel{
	/**
	 * JPanel que contiene la introduccion del nombre de usuario
	 */
	private Usuario usuario;
	/**
	 * JPanel que contiene la introduccion de la contraseña del usuario
	 */
	private Contrasena contrasena;
	/**
	 * JPanel que contiene el boton a pulsar para que el usuario se loguee
	 */
	private BotonLogin botLogin;
	/**
	 * Clase que contiene un JPanel con un JLabel para mostrar un error en caso de que el usuario se loguee incorrectamente
	 */
	private MensajeError mensajeErr;
	/**
	 * JFrame de la ventana de logueo
	 */
	private VentanaLogin vL;
	/**
	 * Constructor del JPanel que recibe como parametros el JFrame VentanaLogin
	 * @param vL JFrame que contiene la ventana de logueo
	 */
	public PanelLogin(VentanaLogin vL) {
		this.vL = vL;
		this.setBorder(new TitledBorder("Iniciar sesion"));
		
		this.setBackground(Color.decode("#04FCFC"));
		usuario = new Usuario();
		contrasena = new Contrasena();
		mensajeErr = new MensajeError();
		botLogin = new BotonLogin(usuario, contrasena, mensajeErr, vL);
		
		this.add(usuario);
		this.add(contrasena);
		this.add(botLogin);
		this.add(mensajeErr);
		this.setLayout(new GridLayout(4,1));
	}
	
	/**
	 * Metodo que devuelve el JPanel que contiene los metodos de entrada para introducir el nombre de usuario
	 * @return usuario 
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Metodo que devuelve el JPanel que contiene los metodos de entrada para introducir la contraseña de usuario
	 * @return contrasena 
	 */
	public Contrasena getContrasena() {
		return contrasena;
	}
	
	/**
	 * Metodo que devuelve el JPanel para iniciar el proceso de logueo
	 * @return botLogin 
	 */
	public BotonLogin getBotLogin() {
		return botLogin;
	}
	
	/**
	 * Metodo que devuelve el JPanel que contiene el mensaje para indicar error en caso de logueo erroneo
	 * @return mensajeErr 
	 */
	public MensajeError getMensajeErr() {
		return mensajeErr;
	}	
}
