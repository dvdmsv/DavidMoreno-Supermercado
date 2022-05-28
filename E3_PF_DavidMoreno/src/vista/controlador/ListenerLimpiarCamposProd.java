package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.paneladmin.IntroducirProductos;

public class ListenerLimpiarCamposProd implements ActionListener{
	private IntroducirProductos introProd;
	
	public ListenerLimpiarCamposProd(IntroducirProductos introProd) {
		this.introProd = introProd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		introProd.getJtfNomProd().setText("");
		introProd.getJtfFamProd().setText("");
		introProd.getJtfCantProd().setText("");
		introProd.getJtfPrecProd().setText("");
		introProd.getJcIVAProd().setSelectedIndex(0);
	}
}
