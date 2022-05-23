package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.paneladmin.VentanaPanelCrearUsuario;

public class ListenerBotonCrear implements ActionListener{
	private VentanaPanelCrearUsuario vpcu;
	
	public ListenerBotonCrear() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPanelCrearUsuario vpcu = new VentanaPanelCrearUsuario();
		
	}

}
