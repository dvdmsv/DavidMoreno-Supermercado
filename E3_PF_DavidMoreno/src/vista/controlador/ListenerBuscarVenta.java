package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.VentanaPanelVentas;
import vista.paneladmin.Ventas;
/**
 * Clase con la logica para buscar una venta
 * @author David
 *
 */
public class ListenerBuscarVenta implements ActionListener{
	/**
	 * Panel de ventas
	 */
	private Ventas vent;
	/**
	 * Tipo de busqueda que se quiere realizar
	 */
	int tipoBusqueda;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	/**
	 * Constructor de ListenerBuscarVenta
	 * @param vent Panel de ventas
	 * @param tipoBusqueda Tipo de busqueda que se quiere realizar
	 */
	public ListenerBuscarVenta(Ventas vent, int tipoBusqueda) {
		this.vent = vent;
		this.tipoBusqueda = tipoBusqueda;
	}
	/**
	 * Metodo con la logica para buscar una venta
	 */
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
