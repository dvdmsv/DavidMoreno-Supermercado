package vista.controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import supermercado.Supermercado;
import vista.panelusuario.Caja;
import vista.panelusuario.VentanaPanelCesta;
/**
 * Clase que contiene la logica para generar la cesta con los productos seleccionados
 * @author David
 *
 */
public class ListenerGenerarCesta implements ActionListener{
	/**
	 * JPanel que contiene los datos del producto
	 */
	private Caja caja;
	/**
	 * Clase que contiene los ArrayList con los productos 
	 */
	private ListenerSiguienteProducto listenerSiguiente; //Tiene como atributo el listenerSiguienteProducto
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	
	/**
	 * Constructor de ListenerGenerarCesta
	 * @param caja JPanel que contiene los datos del producto
	 * @param listenerSiguiente Clase que contiene los ArrayList con los productos
	 */
	public ListenerGenerarCesta(Caja caja, ListenerSiguienteProducto listenerSiguiente) {
		this.caja = caja;
		this.listenerSiguiente = listenerSiguiente;
	}
	/**
	 * 
	 * Metod que contiene la logica para generar la cesta con los productos que se han ido seleccionando
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPanelCesta vpc = new VentanaPanelCesta(listenerSiguiente); //Se instancia VentanaPanelCesta
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formatoNum = new DecimalFormat("0.00", simbolos);
		
		for(int i=0; i<listenerSiguiente.getCodProd().size(); i++) { //Se da tantas vueltas como codigos de producto tenga el arraylist de listenersiguiente
			superm.buscarProductoPorCod(listenerSiguiente.getCodProd().get(i), vpc); //Se busca el producto en base a su codigo y se van almacenando datos dentro de este metodo
			
			vpc.getData()[1] = listenerSiguiente.getCantProd().get(i); //Se obtiene la cantidad del arraylist de listenersiguiente
			
			int cantidad = Integer.parseInt(vpc.getData()[1].toString()); //Se obtiene la cantidad de producto escrito en int
			float precio = Float.parseFloat(vpc.getData()[2].toString()); //Se obtiene el precio del producto en int
			float iva = Float.parseFloat(vpc.getData()[3].toString()); //Se obtiene el IVA del producto en int
			float resultado = (cantidad*precio)*iva; //Se saca al calculo total
			
			vpc.getData()[4] = formatoNum.format(resultado); //Se almacena en la posicion 4 del array
			vpc.getModelo().addRow(vpc.getData()); //Se añade la fila a la tabla
		}
		
		float total = 0;
		for(int i=0; i<vpc.getModelo().getRowCount(); i++) { //Bucle que obtiene el precio total de cada producto de su columna para hacer un total final
			total += Float.parseFloat(vpc.getModelo().getValueAt(i, 4).toString());
		}
		
		vpc.getTotal().setText("TOTAL: " + formatoNum.format(total) + "€");
		vpc.getTotal().setFont(new Font("Serif", Font.PLAIN, 15));
	}

}
