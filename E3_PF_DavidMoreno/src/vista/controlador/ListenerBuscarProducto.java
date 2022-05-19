package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import supermercado.Supermercado;
import vista.panelusuario.Inventario;
import vista.panelusuario.VentanaPanelInventario;

public class ListenerBuscarProducto implements ActionListener{
	private Inventario inv;
	int tipoBusqueda;
	private Supermercado superm = new Supermercado();
	
	public ListenerBuscarProducto(Inventario inv, int tipoBusqueda) { //Recibe el JPanel inventario y un int que indica el tipo de busqueda a realizar
		this.inv = inv;
		this.tipoBusqueda = tipoBusqueda;
	}
	
	
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
