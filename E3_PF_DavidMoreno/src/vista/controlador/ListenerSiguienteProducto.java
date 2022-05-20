package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import vista.panelusuario.Caja;

public class ListenerSiguienteProducto implements ActionListener{
	private ArrayList<Integer> codProd = new ArrayList<Integer>();
	private Caja caja;
	
	public ListenerSiguienteProducto(Caja caja) {
		this.caja = caja;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		codProd.add(caja.get)
		
	}

}
