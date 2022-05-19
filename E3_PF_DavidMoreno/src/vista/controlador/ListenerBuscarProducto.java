package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.panelusuario.Inventario;

public class ListenerBuscarProducto implements ActionListener{
	private Inventario inv;
	private Supermercado superm = new Supermercado();
	
	public ListenerBuscarProducto(Inventario inv) {
		this.inv = inv;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<superm.buscarProducto(inv.getJtfNomProd().getText()).size(); i++) { //Tantas vueltas como el tamaño del arraylist
			inv.getInfoProd().setText(
					superm.buscarProducto(inv.getJtfNomProd().getText()).get(0) + "\n" + 
					superm.buscarProducto(inv.getJtfNomProd().getText()).get(1) + "\n" + 
					superm.buscarProducto(inv.getJtfNomProd().getText()).get(2)
					);
		}
		
	}

}
