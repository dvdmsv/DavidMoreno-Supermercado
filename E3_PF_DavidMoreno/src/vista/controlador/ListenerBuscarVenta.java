package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.VentanaPanelVentas;
import vista.paneladmin.Ventas;

public class ListenerBuscarVenta implements ActionListener{
	private Ventas vent;
	int tipoBusqueda;
	private Supermercado superm = new Supermercado();

	public ListenerBuscarVenta(Ventas vent, int tipoBusqueda) {
		this.vent = vent;
		this.tipoBusqueda = tipoBusqueda;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.tipoBusqueda == 1) {
			VentanaPanelVentas vpv = new VentanaPanelVentas();
			superm.buscarVenta(vent.getJtfDatos().getText(), vpv, tipoBusqueda);
		}else if(this.tipoBusqueda == 2) {
			VentanaPanelVentas vpv = new VentanaPanelVentas();
			superm.buscarVenta(vent.getJtfDatos().getText(), vpv, tipoBusqueda);
		}
		
	}

}
