package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.IntroducirProductos;

public class ListenerIntroducirProd implements ActionListener{
	private IntroducirProductos introProd;
	private Supermercado superm = new Supermercado();
	
	public ListenerIntroducirProd(IntroducirProductos introProd) {
		this.introProd = introProd;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nom = introProd.getJtfNomProd().getText();
		String fam = introProd.getJtfFamProd().getText();
		int cant = Integer.parseInt(introProd.getJtfCantProd().getText());
		float prec = Float.parseFloat(introProd.getJtfPrecProd().getText());
		float iva = Float.parseFloat(introProd.getJtfIVAProd().getText());
		
		superm.introProd(nom, fam, cant, prec, iva);
		System.out.println(nom + fam+ cant + prec + iva);
		
	}

}
