package vista.panelusuario;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import vista.controlador.ListenerCerrarSesion;

public class CerrarSesion extends JMenuBar{
	public CerrarSesion(VentanaPanelUsuario panelUsuario) {
		JMenu cerrarSesion = new JMenu("Cerrar sesion");
		JMenuItem salir = new JMenuItem("Salir");
		
		cerrarSesion.add(salir);
		salir.addActionListener(new ListenerCerrarSesion(panelUsuario));
		
		this.add(cerrarSesion);
	}

}
