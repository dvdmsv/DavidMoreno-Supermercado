package vista.controlador;

import java.awt.Color;
import java.awt.Font;
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
		if(!superm.productoExistePorNom(introProd.getJtfNomProd().getText())) { //Si el producto NO existe en la base de datos
			if(Integer.parseInt(introProd.getJtfCantProd().getText())>=0) { //Si la cantidad es mayor o igual que 0
				if(Double.parseDouble(introProd.getJtfPrecProd().getText())>=0) { //Si el precio es mayor o igual que 0
					int ivaSeleccionado = introProd.getJcIVAProd().getSelectedIndex();
					if(ivaSeleccionado > 0) { //Si se ha seleccionado IVA. El indice seleccionado es mayor que 0 (el primero)
						String nom = introProd.getJtfNomProd().getText();
						String fam = introProd.getJtfFamProd().getText();
						int cant = Integer.parseInt(introProd.getJtfCantProd().getText());
						double prec = Double.parseDouble(introProd.getJtfPrecProd().getText());
						double iva = 0;
						if(ivaSeleccionado == 1) {
							iva = superm.getIVA4();
						}else if(ivaSeleccionado == 2) {
							iva = superm.getIVA10();
						}else if(ivaSeleccionado == 3) {
							iva = superm.getIVA21();
						}
						superm.introProd(nom, fam, cant, prec, iva);
						if(superm.productoExistePorNom(nom)) { //Si el nuevo producto existe en la base de datos se ha introducido correctamente
							introProd.getLblInfo().setText("Producto añadido correctamente");
							introProd.getLblInfo().setForeground(Color.green);
							introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
							introProd.getJtfNomProd().setText("");
							introProd.getJtfFamProd().setText("");
							introProd.getJtfCantProd().setText("");
							introProd.getJtfPrecProd().setText("");
							introProd.getJcIVAProd().setSelectedIndex(0);
						}else {
							introProd.getLblInfo().setText("Error al introducir producto");
							introProd.getLblInfo().setForeground(Color.green);
							introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
							introProd.getJtfNomProd().setText("");
							introProd.getJtfFamProd().setText("");
							introProd.getJtfCantProd().setText("");
							introProd.getJtfPrecProd().setText("");
							introProd.getJcIVAProd().setSelectedIndex(0);
						}	
					}else {
						introProd.getLblInfo().setText("Seleccionar un IVA");
						introProd.getLblInfo().setForeground(Color.red);
						introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
					}
				}
			}else {
				introProd.getLblInfo().setText("Cantidad incorrecta");
				introProd.getLblInfo().setForeground(Color.red);
				introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				introProd.getJtfCantProd().setText("");
			}
		}else {
			introProd.getLblInfo().setText("El producto ya existe en la base de datos");
			introProd.getLblInfo().setForeground(Color.red);
			introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			introProd.getJtfNomProd().setText("");
		}
	}

}
