package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.itextpdf.text.List;

import modelo.PlantillaPFD;
import supermercado.Supermercado;
import vista.panelusuario.VentanaPanelCesta;

public class ListenerFinalizarCompra implements ActionListener{
	private PlantillaPFD plantilla;
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
		
		for(int i=0; i<nombreProd.size(); i++) {
			superm.descontarStock(Integer.parseInt(cantidadProd.get(i)), listenerSiguiente.getCodProd().get(i));
		}
		
		for(int b=0; b<nombreProd.size(); b++) {
			System.out.println(nombreProd.get(b) + " " + listenerSiguiente.getCodProd().get(b));
		}
		PlantillaPFD pl1 = new PlantillaPFD(nombreProd, cantidadProd, precioProd, ivaProd, precTotalProd, vpc.getTotal().getText());
		pl1.crearPlantilla();
		
	}

}
