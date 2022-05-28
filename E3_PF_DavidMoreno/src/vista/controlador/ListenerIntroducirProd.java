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
		
		//Controlar que los campos tengan texto
		if(introProd.getJtfNomProd().getText().isEmpty()) {
			introProd.getLblInfo().setText("Campo nombre esta vacio");
			introProd.getLblInfo().setForeground(Color.red);
			introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
		}else if(introProd.getJtfFamProd().getText().isEmpty()) {
			introProd.getLblInfo().setText("Campo Familia esta vacio");
			introProd.getLblInfo().setForeground(Color.red);
			introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
		}else if(introProd.getJtfCantProd().getText().isEmpty()) {
			introProd.getLblInfo().setText("Campo cantidad esta vacio");
			introProd.getLblInfo().setForeground(Color.red);
			introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
		}else if(introProd.getJtfPrecProd().getText().isEmpty()) {
			introProd.getLblInfo().setText("Campo precio esta vacio");
			introProd.getLblInfo().setForeground(Color.red);
			introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
		} else if(introProd.getJcIVAProd().getSelectedIndex() == 0) {
			introProd.getLblInfo().setText("Seleccionar un IVA");
			introProd.getLblInfo().setForeground(Color.red);
			introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
		}else {
			//Controlar que los datos introducidos sean correctos
			if(!superm.productoExistePorNom(introProd.getJtfNomProd().getText())) { //Si el producto NO existe en la base de datos	
				if(superm.isInt(introProd.getJtfCantProd().getText())) { //Si la cantidad es un entero
					if(Integer.parseInt(introProd.getJtfCantProd().getText()) >= 0) { //Si la cantidad introducida es mayor o igual que 0
						if(superm.isFloat(introProd.getJtfPrecProd().getText())) { //Si el precio es un flotante
							if(Float.parseFloat(introProd.getJtfPrecProd().getText())>=0) { //Si el precio es mayor o igual que 0
								int ivaSeleccionado = introProd.getJcIVAProd().getSelectedIndex(); //Se obtiene el indice del IVA
									//Se obtienen los datos del producto en variables
									String nom = introProd.getJtfNomProd().getText();
									String fam = introProd.getJtfFamProd().getText();
									int cant = Integer.parseInt(introProd.getJtfCantProd().getText());
									double prec = Double.parseDouble(introProd.getJtfPrecProd().getText());
									//
									double iva = 0;
									if(ivaSeleccionado == 1) {
										iva = superm.getIVA4();
									}else if(ivaSeleccionado == 2) {
										iva = superm.getIVA10();
									}else if(ivaSeleccionado == 3) {
										iva = superm.getIVA21();
									}
									superm.introProd(nom, fam, cant, prec, iva); //Se introduce el producto en la base de datos
									
									if(superm.productoExistePorNom(nom)) { //Se hace una consulta en base al nombre para comprobar que se ha introducido correctamente
										introProd.getLblInfo().setText("Producto añadido correctamente");
										introProd.getLblInfo().setForeground(Color.green);
										introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
										introProd.getJtfNomProd().setText("");
										introProd.getJtfFamProd().setText("");
										introProd.getJtfCantProd().setText("");
										introProd.getJtfPrecProd().setText("");
										introProd.getJcIVAProd().setSelectedIndex(0);
									}else {
										introProd.getLblInfo().setText("Error al añadir producto");
										introProd.getLblInfo().setForeground(Color.red);
										introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
										introProd.getJtfCantProd().setText("");
									}
							}else { //Si el precio es menor que 0
								introProd.getLblInfo().setText("Precio incorrecto");
								introProd.getLblInfo().setForeground(Color.red);
								introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
								introProd.getJtfCantProd().setText("");
							}
						}else { //Si el precio no es un flotante
							introProd.getLblInfo().setText("Precio incorrecto");
							introProd.getLblInfo().setForeground(Color.red);
							introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
							introProd.getJtfPrecProd().setText("");
						}
					}else {//Si la cantidad introducida es menor que 0
						introProd.getLblInfo().setText("Cantidad incorrecta");
						introProd.getLblInfo().setForeground(Color.red);
						introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
						introProd.getJtfCantProd().setText("");
					}
				}else {//Si la cantidad no es un entero
					introProd.getLblInfo().setText("Cantidad incorrecta");
					introProd.getLblInfo().setForeground(Color.red);
					introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
					introProd.getJtfCantProd().setText("");
				}
			}else { //Si el producto existe en la base de datos
				introProd.getLblInfo().setText("El producto ya existe en la base de datos");
				introProd.getLblInfo().setForeground(Color.red);
				introProd.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				introProd.getJtfNomProd().setText("");
			}
		}
	}

}
