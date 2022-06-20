package vista.paneladmin;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import vista.controlador.ListenerCerrarSesion;
/**
 * Clase que contiene el JMenuBar con la opcion de cerrar sesion
 * @author David
 *
 */
public class CerrarSesion extends JMenuBar{
	/**
	 * Constructor de la clase CerrarSesion. 
	 * @param panelAdmin Recibe como parametro el panel del usuario administrador
	 */
	public CerrarSesion(VentanaPanelAdmin panelAdmin) {
		JMenu cerrarSesion = new JMenu("Cerrar sesion");
		JMenuItem salir = new JMenuItem("Salir");
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		cerrarSesion.add(salir);
		salir.addActionListener(new ListenerCerrarSesion(panelAdmin));
		this.add(cerrarSesion);
	}
}
