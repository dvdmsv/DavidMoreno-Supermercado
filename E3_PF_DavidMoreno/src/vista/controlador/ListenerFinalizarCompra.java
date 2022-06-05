package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import modelo.PlantillaPDF;
import supermercado.Supermercado;
import vista.login.Usuario;
import vista.panelusuario.VentanaPanelCesta;
/**
 * Clase que contiene la logica para finalizar la compra, descontar los articulos, generar el ticket y añadirlo a ventas
 * @author David
 *
 */
public class ListenerFinalizarCompra implements ActionListener{
	/**
	 * Plantilla para generar los datos en PDF
	 */
	private PlantillaPDF plantilla;
	/**
	 * Array que contiene el nombre del producto
	 */
	private ArrayList<String> nombreProd = new ArrayList<String>();
	/**
	 * Array que contiene la cantidad de producto
	 */
	private ArrayList<String> cantidadProd = new ArrayList<String>();
	/**
	 * Array que contiene el precio del producto
	 */
	private ArrayList<String> precioProd = new ArrayList<String>();
	/**
	 * Array que contiene el IVA del producto
	 */
	private ArrayList<String> ivaProd = new ArrayList<String>();
	/**
	 * Array que contiene el precio total de cada producto
	 */
	private ArrayList<String> precTotalProd = new ArrayList<String>();
	/**
	 * JFrame con el panel de la cesta
	 */
	private VentanaPanelCesta vpc;
	/**
	 * Clase que contiene los arrays con el codigo y cantidad de cada producto
	 */
	private ListenerSiguienteProducto listenerSiguiente;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	/**
	 * 
	 * @param vpc Clase que contiene los arrays con el codigo y cantidad de cada producto
	 * @param listenerSiguiente Clase que contiene todos los metodos de la aplicacion
	 */
	public ListenerFinalizarCompra(VentanaPanelCesta vpc, ListenerSiguienteProducto listenerSiguiente) {
		this.vpc = vpc;
		this.listenerSiguiente = listenerSiguiente;
	}
	/**
	 * Metodo que contiene la logica para finalizar la compra, descontar los articulos, generar el ticket y añadirlo a ventas
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<vpc.getModelo().getRowCount(); i++) { //Bucle que recorre las filas de la tabla
			//En cada vuelta se almacena en un arraylist el dato correspondiente a cada columna
			nombreProd.add(vpc.getModelo().getValueAt(i, 0).toString());
			cantidadProd.add(vpc.getModelo().getValueAt(i, 1).toString());
			precioProd.add(vpc.getModelo().getValueAt(i, 2).toString());
			ivaProd.add(vpc.getModelo().getValueAt(i, 3).toString());
			precTotalProd.add(vpc.getModelo().getValueAt(i, 4).toString());
		}
		
		for(int i=0; i<nombreProd.size(); i++) { //Bucle para descontar stock
			superm.descontarStock(Integer.parseInt(cantidadProd.get(i)), listenerSiguiente.getCodProd().get(i));
		}
		
		plantilla = new PlantillaPDF(nombreProd, cantidadProd, precioProd, ivaProd, precTotalProd, vpc.getTotal().getText());
		plantilla.crearPlantilla();
		
		for(int i=0; i<nombreProd.size(); i++) {
			superm.anadirVenta(Integer.parseInt(listenerSiguiente.getCodProd().get(i)), nombreProd.get(i), Integer.parseInt(listenerSiguiente.getCantProd().get(i)), LocalDate.now().toString(), superm.getCodUsu(Usuario.getUsuarioLogueado()));
		}
		
		int tamanoListaCesta = listenerSiguiente.getCodProd().size(); //Se tiene que guardar el tamaño del array antes de eliminar elementos del mismo porque si no al iterar sobre el va disminuyendo su tamaño y no elimina bien
		for(int i=0; i<tamanoListaCesta; i++) { //Despues de realizar la compra vacia el ArrayList que contiene los productos de la tabla. Asi está vacio para la siguiente compra
			listenerSiguiente.getCodProd().remove(0);
			listenerSiguiente.getCantProd().remove(0);
		}
		JOptionPane.showMessageDialog(null, "Compra realizada");
		
		vpc.dispose();
	}
}
