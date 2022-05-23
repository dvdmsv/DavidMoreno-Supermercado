package vista.paneladmin;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import vista.controlador.ListenerCerrarSesion;

public class CerrarSesion extends JMenuBar{
	public CerrarSesion(VentanaPanelAdmin panelAdmin) {
		JMenu cerrarSesion = new JMenu("Cerrar sesion");
		JMenuItem salir = new JMenuItem("Salir");
		
		cerrarSesion.add(salir);
		salir.addActionListener(new ListenerCerrarSesion(panelAdmin));
		this.add(cerrarSesion);
	}

}
