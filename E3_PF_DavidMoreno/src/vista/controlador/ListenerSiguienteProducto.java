package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import supermercado.Supermercado;
import vista.panelusuario.Caja;

public class ListenerSiguienteProducto implements ActionListener{
	private ArrayList<String> codProd = new ArrayList<String>();
	private ArrayList<String> cantProd = new ArrayList<String>();
	private Caja caja;
	private Supermercado superm = new Supermercado();
	
	public ListenerSiguienteProducto(Caja caja) {
		this.caja = caja;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.productoExiste(caja.getJtfCodProd().getText())) { //Comprueba si el producto existe en la base de datos
			if(codProd.contains(caja.getJtfCodProd().getText())) { //Comprueba si el producto ya está en el arraylist
				caja.getLblInfo().setText("El producto ya esta en la cesta");
				caja.getLblInfo().setForeground(Color.red);
			}else { //Si el producto no está en el arraylist
				if(caja.getJtfCantidadProd().getText().isEmpty() || caja.getJtfCantidadProd().getText().equals("0")) { //Comprueba si el campo de cantidad producto esta vacio o es igual a 0 (SOLUCIONAR PONER SOLO VALORES NUMERICOS)
					caja.getLblInfo().setText("Introducir cantidad correcta");
					caja.getLblInfo().setForeground(Color.red);
					caja.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 25));
					caja.getJtfCantidadProd().setText("");
				}else { //Si el campo de texto no está vacio ni contiene un 0
					if(Integer.parseInt(caja.getJtfCantidadProd().getText()) <= superm.stockDisponible(caja.getJtfCodProd().getText())) { //Comprueba si hay stock disponible. Si la cantidad escrita es menor o igual a la cantidad de stock	
						codProd.add(caja.getJtfCodProd().getText()); //Se añade al ArrayList de codigos de producto el codigo de producto
						cantProd.add(caja.getJtfCantidadProd().getText()); //Se añade al ArrayList de cantidades la cantidad seleccionada
						caja.getLblInfo().setText("Producto añadido correctamente");
						caja.getLblInfo().setForeground(Color.green);
						caja.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 25));
						caja.getJtfCodProd().setText("");
						caja.getJtfCantidadProd().setText("");
					}else { //Si la cantidad escrita es mayor que el stock disponible
						caja.getLblInfo().setText("STOCK INSUFICIENTE. STOCK DISPONIBLE: " + superm.stockDisponible(caja.getJtfCodProd().getText()));
						caja.getLblInfo().setForeground(Color.red);
						caja.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
						caja.getJtfCodProd().setText("");
					}
				}	
			}
		}else { //Si el producto no existe en la base de datos
			caja.getLblInfo().setText("Codigo erroneo");
			caja.getLblInfo().setForeground(Color.red);
			caja.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 25));
			caja.getJtfCodProd().setText("");
		}
	}

	public ArrayList<String> getCodProd() {
		return codProd;
	}

	public ArrayList<String> getCantProd() {
		return cantProd;
	}

}
