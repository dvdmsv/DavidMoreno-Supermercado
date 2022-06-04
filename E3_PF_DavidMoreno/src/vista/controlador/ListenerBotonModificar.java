package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.paneladmin.VentanaPanelModificarUsuario;
/**
 * Clase que despliega la ventana modificar usuario
 * @author David
 *
 */
public class ListenerBotonModificar implements ActionListener {
	/**
	 * Metodo que despliega la ventana modificar usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPanelModificarUsuario vpmu = new VentanaPanelModificarUsuario();
	}

}
