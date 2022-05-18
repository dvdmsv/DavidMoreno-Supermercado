package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.login.VentanaLogin;
import vista.panelusuario.VentanaPanelUsuario;

public class ListenerCerrarSesion implements ActionListener{
	private VentanaPanelUsuario panelUsuario;
	
	public ListenerCerrarSesion(VentanaPanelUsuario panelUsuario) {
		this.panelUsuario = panelUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panelUsuario.setVisible(false);
		panelUsuario.dispose();
		VentanaLogin vL = new VentanaLogin();
		
	}

}
