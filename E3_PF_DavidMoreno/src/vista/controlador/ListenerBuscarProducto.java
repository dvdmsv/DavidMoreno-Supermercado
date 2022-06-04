package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import supermercado.Supermercado;
import vista.panelusuario.Inventario;
import vista.panelusuario.VentanaPanelInventario;
/**
 * Clase con la logica para buscar un producto
 * @author David
 *
 */
public class ListenerBuscarProducto implements ActionListener{
	/**
	 * Panel del inventario
	 */
	private Inventario inv;
	/**
	 * Tipo de busqueda que se quiere realizar
	 */
	int tipoBusqueda;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	/**
	 * Constructor de la clase ListenerBuscarProducto
	 * @param inv Panel del inventario
	 * @param tipoBusqueda Tipo de busqueda que se quiere realizar
	 */
	public ListenerBuscarProducto(Inventario inv, int tipoBusqueda) { //Recibe el JPanel inventario y un int que indica el tipo de busqueda a realizar
		this.inv = inv;
		this.tipoBusqueda = tipoBusqueda;
	}
	/**
	 * Metodo con la logica para buscar un producto
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.tipoBusqueda == 1) {
			VentanaPanelInventario vpi = new VentanaPanelInventario();
			superm.buscarProducto(inv.getJtfNomProd().getText(), vpi, tipoBusqueda);
		}else if(this.tipoBusqueda == 2) {
			VentanaPanelInventario vpi = new VentanaPanelInventario();
			superm.buscarProducto(inv.getJtfNomProd().getText(), vpi, tipoBusqueda);
		}else if(this.tipoBusqueda == 3) {
			VentanaPanelInventario vpi = new VentanaPanelInventario();
			superm.buscarProducto(inv.getJtfNomProd().getText(), vpi, tipoBusqueda);
		}
	}
}
