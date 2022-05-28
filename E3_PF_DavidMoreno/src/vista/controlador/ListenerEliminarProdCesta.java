package vista.controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import vista.panelusuario.VentanaPanelCesta;

public class ListenerEliminarProdCesta implements ActionListener{
	private VentanaPanelCesta vpc;
	
	public ListenerEliminarProdCesta(VentanaPanelCesta vpc) {
		this.vpc = vpc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formatoNum = new DecimalFormat("0.00", simbolos);
		
		int[] filas = vpc.getTabla().getSelectedRows();
		if(filas.length>0) {
			for(int i=0; i<filas.length; i++) {
				vpc.getModelo().removeRow(filas[i]);
				float total = 0;
				for(int a=0; a<vpc.getModelo().getRowCount(); a++) { //Bucle que obtiene el precio total de cada producto de su columna para hacer un total final
					total += Float.parseFloat(vpc.getModelo().getValueAt(i, 4).toString());
				}
				
				vpc.getTotal().setText("Total: " + formatoNum.format(total) + "€");
				vpc.getTotal().setFont(new Font("Serif", Font.PLAIN, 15));
			}
		}
	}

}
