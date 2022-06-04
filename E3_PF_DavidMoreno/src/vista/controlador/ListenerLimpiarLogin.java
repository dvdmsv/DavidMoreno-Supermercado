package vista.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.login.Contrasena;
import vista.login.MensajeError;
import vista.login.Usuario;
/**
 * Clase que contiene la logica para limpiar los campos de login
 * @author David
 *
 */
public class ListenerLimpiarLogin implements ActionListener{
	/**
	 * JPanel que contiene el nombre de usuario
	 */
	private Usuario usuario;
	/**
	 * JPanel que contiene la contraseña de usuario
	 */
	private Contrasena contrasena;
	/**
	 * JPanel que contiene el mensjae de error
	 */
	private MensajeError mensajeErr;
	
	/**
	 * Constructor de JPanel que contiene los datos del usuario
	 * @param usuario JPanel que contiene el nombre de usuario
	 * @param contrasena JPanel que contiene la contraseña de usuario
	 * @param mensajeErr JPanel que contiene el mensjae de error
	 */
	public ListenerLimpiarLogin(Usuario usuario, Contrasena contrasena, MensajeError mensajeErr) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.mensajeErr=mensajeErr;
	}
	/**
	 * Metodo con la logica para limpar los campos de login
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		usuario.getJtf().setText("");
		contrasena.getJpswf().setText("");
		mensajeErr.getLb().setText("");
		mensajeErr.setBackground(Color.decode("#04FCFC"));
	}
}
