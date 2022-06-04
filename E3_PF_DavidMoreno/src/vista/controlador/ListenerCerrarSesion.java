package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import supermercado.Supermercado;
import vista.login.VentanaLogin;
import vista.paneladmin.VentanaPanelAdmin;
import vista.panelusuario.VentanaPanelUsuario;
/**
 * Clase con la logica para cerrar sesion
 * @author David
 *
 */
public class ListenerCerrarSesion implements ActionListener{
	/**
	 * La ventana actual
	 */
	private JFrame ventana;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	Supermercado superm = new Supermercado();
	/**
	 * Constructor de ListenerCerrarSesion
	 * @param ventana La ventana actual
	 */
	public ListenerCerrarSesion(JFrame ventana) {
		this.ventana = ventana;
	}
	/**
	 * Metodo con la logica para cerrar sesion
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ventana.setVisible(false);
		ventana.dispose();
		superm.login();
	}
}
