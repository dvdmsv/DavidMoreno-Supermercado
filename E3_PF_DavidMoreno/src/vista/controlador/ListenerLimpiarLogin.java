package vista.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.login.Contrasena;
import vista.login.MensajeError;
import vista.login.Usuario;

public class ListenerLimpiarLogin implements ActionListener{
	private Usuario usuario;
	private Contrasena contrasena;
	private MensajeError mensajeErr;
	
	public ListenerLimpiarLogin(Usuario usuario, Contrasena contrasena, MensajeError mensajeErr) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.mensajeErr=mensajeErr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		usuario.getJtf().setText("");
		contrasena.getJpswf().setText("");
		mensajeErr.getLb().setText("");
		mensajeErr.setBackground(Color.decode("#04FCFC"));
	}
}
