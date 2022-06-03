package vista.panelusuario;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import vista.controlador.ListenerCerrarSesion;
import vista.paneladmin.VentanaPanelAdmin;
/**
 * Clase que contiene un JMenuBar para cerrar sesion en la aplicacion
 * @author David
 *
 */
public class CerrarSesion extends JMenuBar{
	/**
	 * Constructor de CerrarSesion para los usuarios normales
	 * @param panelUsuario
	 */
	public CerrarSesion(VentanaPanelUsuario panelUsuario) {
		JMenu cerrarSesion = new JMenu("Cerrar sesion");
		JMenuItem salir = new JMenuItem("Salir");
		
		cerrarSesion.add(salir);
		salir.addActionListener(new ListenerCerrarSesion(panelUsuario));
		
		this.add(cerrarSesion);
	}
	/**
	 * Constructor de CerrarSesion para los usuarios administradores. Recibe como parametro el JFrame que contiene la ventana login
	 * @param panelAdmin
	 */
	public CerrarSesion(VentanaPanelAdmin panelAdmin) {
		JMenu cerrarSesion = new JMenu("Cerrar sesion");
		JMenuItem salir = new JMenuItem("Salir");
		
		cerrarSesion.add(salir);
		salir.addActionListener(new ListenerCerrarSesion(panelAdmin));
		
		this.add(cerrarSesion);
	}
}
