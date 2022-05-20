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
		if(superm.productoExiste(caja.getJtfCodProd().getText())) { //Si el producto existe
			if(caja.getJtfCantidadProd().getText().isEmpty()) { //Si la cantidad está vacia
				caja.getLblInfo().setText("Introducir cantidad");
				caja.getLblInfo().setForeground(Color.red);
				caja.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 25));
				caja.getJtfCantidadProd().setText("");
			}else { //Si no está vacia
				codProd.add(caja.getJtfCodProd().getText());
				cantProd.add(caja.getJtfCantidadProd().getText());
				System.out.println(caja.getJtfCodProd().getText());
				caja.getLblInfo().setText("Producto añadido correctamente");
				caja.getLblInfo().setForeground(Color.green);
				caja.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 25));
				caja.getJtfCodProd().setText("");
				caja.getJtfCantidadProd().setText("");
			}
		}else { //Si el producto no existe
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
