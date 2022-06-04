package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.paneladmin.IntroducirProductos;
/**
 * Clase que contiene la logica para limpiar los campos de producto
 * @author David
 *
 */
public class ListenerLimpiarCamposProd implements ActionListener{
	/**
	 * JPanel que contiene los campos del producto
	 */
	private IntroducirProductos introProd;
	/**
	 * Constructor de la clase ListenerLimpiarCamposProd
	 * @param introProd JPanel que contiene los campos del producto
	 */
	public ListenerLimpiarCamposProd(IntroducirProductos introProd) {
		this.introProd = introProd;
	}
	/**
	 * Metodo que contiene la logica para limpiar los campos de introducir producto
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		introProd.getJtfNomProd().setText("");
		introProd.getJtfFamProd().setText("");
		introProd.getJtfCantProd().setText("");
		introProd.getJtfPrecProd().setText("");
		introProd.getJcIVAProd().setSelectedIndex(0);
	}
}
