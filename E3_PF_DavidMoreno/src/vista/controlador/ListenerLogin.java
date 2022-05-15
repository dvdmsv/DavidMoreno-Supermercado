package vista.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.login.Contrasena;
import vista.login.MensajeError;
import vista.login.Usuario;

public class ListenerLogin implements ActionListener {
	private Usuario usuario;
	private Contrasena contrasena;
	private MensajeError mensajeErr;
	private Supermercado superm = new Supermercado();
	
	public ListenerLogin(Usuario usuario, Contrasena contrasena, MensajeError mensajeErr) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.mensajeErr=mensajeErr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.loginCorrecto(usuario.getJtf().getText(), String.valueOf(contrasena.getJpswf().getPassword()))) {
			mensajeErr.getLb().setText("Login correcto");
		} else {
			mensajeErr.getLb().setText("Usuario " + usuario.getJtf().getText() + " no existe o contraseña incorrecta");
			mensajeErr.setBackground(Color.BLACK);
			mensajeErr.getLb().setForeground(Color.WHITE);
			
		}
	}
}
