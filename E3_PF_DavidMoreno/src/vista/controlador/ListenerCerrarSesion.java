package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.login.VentanaLogin;
import vista.paneladmin.VentanaPanelAdmin;
import vista.panelusuario.VentanaPanelUsuario;

public class ListenerCerrarSesion implements ActionListener{
	private JFrame ventana;
	
	public ListenerCerrarSesion(JFrame ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ventana.setVisible(false);
		ventana.dispose();
		VentanaLogin vL = new VentanaLogin();
		
	}

}
