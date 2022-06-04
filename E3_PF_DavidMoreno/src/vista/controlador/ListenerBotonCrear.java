package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.paneladmin.VentanaPanelCrearUsuario;
/**
 * Clase que despliega la ventana crear usuario
 * @author David
 *
 */
public class ListenerBotonCrear implements ActionListener{
	/**
	 * Metodo que despliega la ventana crear usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPanelCrearUsuario vpcu = new VentanaPanelCrearUsuario();
		
	}

}
