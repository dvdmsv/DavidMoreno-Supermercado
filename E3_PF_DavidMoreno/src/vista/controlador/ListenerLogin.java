package vista.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.login.Contrasena;
import vista.login.MensajeError;
import vista.login.Usuario;
import vista.login.VentanaLogin;
import vista.paneladmin.VentanaPanelAdmin;
import vista.panelusuario.VentanaPanelUsuario;
/**
 * Clase que se encarga de loguear a un usuario
 * @author David
 *
 */
public class ListenerLogin implements ActionListener {
	/**
	 * JPanel que contiene el nombre de usuario
	 */
	private Usuario usuario;
	/**
	 * JPanel que contiene la contraseña
	 */
	private Contrasena contrasena;
	/**
	 * JPanel que contiene el mensaje de error ante mal logueo
	 */
	private MensajeError mensajeErr;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	/**
	 * Ventana que contiene el login
	 */
	private VentanaLogin vL;
	/**
	 * Constructor de ListenerLogin
	 * @param usuario JPanel que contiene el nombre de usuario
	 * @param contrasena JPanel que contiene la contraseña
	 * @param mensajeErr JPanel que contiene el mensaje de error
	 * @param vL ventana de login
	 */
	public ListenerLogin(Usuario usuario, Contrasena contrasena, MensajeError mensajeErr, VentanaLogin vL) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.mensajeErr=mensajeErr;
		this.vL = vL;
	}
	
	/**
	 * Metodo que contiene toda la logica para loguearse
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.loginCorrecto(usuario.getJtf().getText(), superm.generarHash(contrasena.getJpswf().getText()))) { //Si el usuario y contraseña es correcto
			if(superm.loginAdmin(usuario.getJtf().getText(), superm.generarHash(contrasena.getJpswf().getText()))) { //Si el usuario es administrador
				vL.setVisible(false); //La ventana se hace invisible
				vL.dispose(); //La ventana se destruye
				VentanaPanelAdmin pA = new VentanaPanelAdmin(); //Se abre la ventana que contiene el panel de admin
			}else { //Si el usuario es un usuario normal
				vL.setVisible(false); //La ventana se hace invisible
				vL.dispose(); //La ventana se destruye
				VentanaPanelUsuario vpU = new VentanaPanelUsuario(); //Se abre la ventana que contiene el panel de usuario normal
			}
			Usuario.setUsuarioLogueado(this.usuario.getJtf().getText());  //Se establece como usuario logueado el nombre del usuario
		}else { //Si el nombre de usuario o la contraseña estan incorrectos
			mensajeErr.getLb().setText("Usuario " + usuario.getJtf().getText() + " no existe o contraseña incorrecta"); //Se indica en un mensaje
			mensajeErr.setBackground(Color.BLACK);
			mensajeErr.getLb().setForeground(Color.WHITE);
		}
	}
}
