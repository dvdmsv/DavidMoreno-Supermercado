package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.panelusuario.Caja;
import vista.panelusuario.VentanaPanelCesta;

public class ListenerGenerarCesta implements ActionListener{
	private Caja caja;
	
	public ListenerGenerarCesta(Caja caja) {
		this.caja = caja;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPanelCesta panelCesta = new VentanaPanelCesta();
		
	}

}
