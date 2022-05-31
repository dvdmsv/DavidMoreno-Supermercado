package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.List;

import modelo.PlantillaPDF;
import supermercado.Supermercado;
import vista.panelusuario.VentanaPanelCesta;

public class ListenerFinalizarCompra implements ActionListener{
	private PlantillaPDF plantilla;
	private ArrayList<String> nombreProd = new ArrayList<String>();
	private ArrayList<String> cantidadProd = new ArrayList<String>();
	private ArrayList<String> precioProd = new ArrayList<String>();
	private ArrayList<String> ivaProd = new ArrayList<String>();
	private ArrayList<String> precTotalProd = new ArrayList<String>();
	private VentanaPanelCesta vpc;
	private ListenerSiguienteProducto listenerSiguiente;
	private Supermercado superm = new Supermercado();
	
	public ListenerFinalizarCompra(VentanaPanelCesta vpc, ListenerSiguienteProducto listenerSiguiente) {
		this.vpc = vpc;
		this.listenerSiguiente = listenerSiguiente;
	}
	
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
		
		PlantillaPDF pl1 = new PlantillaPDF(nombreProd, cantidadProd, precioProd, ivaProd, precTotalProd, vpc.getTotal().getText());
		pl1.crearPlantilla();
		
		
		for(int i=0; i<nombreProd.size(); i++) {
			//superm.anadirVenta(listenerSiguiente.getCodProd().get(i), nombreProd.get(i), listenerSiguiente.getCantProd().get(i), "2020", "0");
			System.out.println(listenerSiguiente.getCodProd().get(i) + nombreProd.get(i) + listenerSiguiente.getCantProd().get(i) + LocalDate.now().toString() + "0");
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
