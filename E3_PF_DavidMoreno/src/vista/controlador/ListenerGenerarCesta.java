package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.panelusuario.Caja;
import vista.panelusuario.VentanaPanelCesta;

public class ListenerGenerarCesta implements ActionListener{
	private Caja caja;
	private ListenerSiguienteProducto listenerSiguiente;
	private Supermercado superm = new Supermercado();
	
	
	public ListenerGenerarCesta(Caja caja, ListenerSiguienteProducto listenerSiguiente) {
		this.caja = caja;
		this.listenerSiguiente = listenerSiguiente;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPanelCesta vpc = new VentanaPanelCesta();
		for(int i=0; i<listenerSiguiente.getCodProd().size(); i++) {
			superm.buscarProductoPorCod(listenerSiguiente.getCodProd().get(i), vpc);
			
			
			
			vpc.getData()[1] = listenerSiguiente.getCantProd().get(i); //Cantidad
			
			int cantidad = Integer.parseInt(vpc.getData()[1].toString());
			float precio = Float.parseFloat(vpc.getData()[2].toString());
			float iva = Float.parseFloat(vpc.getData()[3].toString());
			float resultado = (cantidad*precio)*iva;
			
			vpc.getData()[4] = Float.toString(resultado);
			vpc.getModelo().addRow(vpc.getData());
		}
		
	}

}
