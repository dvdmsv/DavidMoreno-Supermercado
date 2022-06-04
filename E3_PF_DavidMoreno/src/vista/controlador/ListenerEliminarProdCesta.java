package vista.controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import vista.panelusuario.VentanaPanelCesta;
/**
 * Clase que contiene la logica para eliminar productos de la cesta
 * @author David
 *
 */
public class ListenerEliminarProdCesta implements ActionListener{
	/**
	 * Ventana que contiene la cesta
	 */
	private VentanaPanelCesta vpc;
	/**
	 * Listener con los productos que han ido pasando
	 */
	private ListenerSiguienteProducto listenerSiguiente;
	/**
	 * Constructor de la clase ListenerEliminarProdCesta
	 * @param vpc Ventana que contiene la cesta
	 * @param listenerSiguiente Listener con los productos que han ido pasando
	 */
	public ListenerEliminarProdCesta(VentanaPanelCesta vpc, ListenerSiguienteProducto listenerSiguiente) {
		this.vpc = vpc;
		this.listenerSiguiente = listenerSiguiente;
	}
	
	/**
	 * Metodo que contiene la logica para eliminar productos de la cesta
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formatoNum = new DecimalFormat("0.00", simbolos);
		
		int[] filas = vpc.getTabla().getSelectedRows(); //El array recoge la fila seleccionada
		if(filas.length>0) { //Si las filas seleccionadas son mayores que 0
			for(int i=0; i<filas.length; i++) { //Se recorre el array
				vpc.getModelo().removeRow(filas[i]); //Eliminando las filas
				listenerSiguiente.getCodProd().remove(i); //Eliminando el codigo del arraylist que contiene el codigo
				listenerSiguiente.getCantProd().remove(i); //Eliminando el codigo del arraylist que contiene la cantidad de producto
				
				//Para actualizar el precio de la cesta
				float total = 0;
				for(int a=0; a<vpc.getModelo().getRowCount(); a++) { //Bucle que obtiene el precio total de cada producto de su columna para hacer un total final
					total += Float.parseFloat(vpc.getModelo().getValueAt(i, 4).toString()); //Se va actualizando el precio en base a las filas de los productos
				}
				
				vpc.getTotal().setText("Total: " + formatoNum.format(total) + "€");
				vpc.getTotal().setFont(new Font("Serif", Font.PLAIN, 15));
			}
		}
	}
}
