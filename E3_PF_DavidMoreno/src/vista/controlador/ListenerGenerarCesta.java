package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.panelusuario.Caja;
import vista.panelusuario.VentanaPanelCesta;

public class ListenerGenerarCesta implements ActionListener{
	private Caja caja;
	private ListenerSiguienteProducto listenerSiguiente; //Tiene como atributo el listenerSiguienteProducto
	private Supermercado superm = new Supermercado();
	
	
	public ListenerGenerarCesta(Caja caja, ListenerSiguienteProducto listenerSiguiente) {
		this.caja = caja;
		this.listenerSiguiente = listenerSiguiente;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPanelCesta vpc = new VentanaPanelCesta(); //Se instancia VentanaPanelCesta
		for(int i=0; i<listenerSiguiente.getCodProd().size(); i++) { //Se da tantas vueltas como codigos de producto tenga el arraylist de listenersiguiente
			superm.buscarProductoPorCod(listenerSiguiente.getCodProd().get(i), vpc); //Se busca el producto en base a su codigo y se van almacenando datos dentro de este metodo
			
			vpc.getData()[1] = listenerSiguiente.getCantProd().get(i); //Se obtiene la cantidad del arraylist de listenersiguiente
			
			int cantidad = Integer.parseInt(vpc.getData()[1].toString()); //Se obtiene la cantidad de producto escrito en int
			float precio = Float.parseFloat(vpc.getData()[2].toString()); //Se obtiene el precio del producto en int
			float iva = Float.parseFloat(vpc.getData()[3].toString()); //Se obtiene el IVA del producto en int
			float resultado = (cantidad*precio)*iva; //Se saca al calculo total
			
			vpc.getData()[4] = Float.toString(resultado); //Se almacena en la posicion 4 del array
			vpc.getModelo().addRow(vpc.getData()); //Se a�ade la fila a la tabla
		}
		
	}

}
