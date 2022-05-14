package vista.login;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerLimpiarLogin;
import vista.controlador.ListenerLogin;

public class BotonLogin extends JPanel{
	private JButton b1, b2;
	private Usuario usuario;
	private Contrasena contrasena;
	private MensajeError mensajeErr;
	private ListenerLogin lisLog;
	private ListenerLimpiarLogin limpLogin;
	
	public BotonLogin(Usuario usuario, Contrasena contrasena, MensajeError mensajeErr) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.mensajeErr=mensajeErr;
		
		b1 = new JButton("Iniciar Sesion");
		this.add(b1);
		
		b2 = new JButton("Limpiar");
		this.add(b2);
		
		
		lisLog = new ListenerLogin(usuario, contrasena, mensajeErr);
		b1.addActionListener(lisLog);
		
		limpLogin = new ListenerLimpiarLogin(usuario, contrasena, mensajeErr);
		b2.addActionListener(limpLogin);
		
	}

}
