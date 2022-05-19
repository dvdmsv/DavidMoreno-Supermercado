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

public class ListenerLogin implements ActionListener {
	private Usuario usuario;
	private Contrasena contrasena;
	private MensajeError mensajeErr;
	private Supermercado superm = new Supermercado();
	private VentanaLogin vL;
	
	public ListenerLogin(Usuario usuario, Contrasena contrasena, MensajeError mensajeErr, VentanaLogin vL) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.mensajeErr=mensajeErr;
		this.vL = vL;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.loginCorrecto(usuario.getJtf().getText(), String.valueOf(contrasena.getJpswf().getPassword()))) {
			if(superm.loginAdmin(usuario.getJtf().getText(), String.valueOf(contrasena.getJpswf().getPassword()))) {
				mensajeErr.getLb().setForeground(Color.BLACK);
				mensajeErr.getLb().setText("Login correcto");
				vL.setVisible(false);
				vL.dispose();
				VentanaPanelAdmin pA = new VentanaPanelAdmin();
			}else {
				mensajeErr.getLb().setForeground(Color.BLACK);
				mensajeErr.getLb().setText("Login correcto");
				vL.setVisible(false);
				vL.dispose();
				VentanaPanelUsuario vpU = new VentanaPanelUsuario();
			}
		} else {
			mensajeErr.getLb().setText("Usuario " + usuario.getJtf().getText() + " no existe o contraseña incorrecta");
			mensajeErr.setBackground(Color.BLACK);
			mensajeErr.getLb().setForeground(Color.WHITE);
			
		}
	}
}
