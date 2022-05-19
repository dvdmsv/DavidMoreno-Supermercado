package vista.panelusuario;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerBuscarProducto;

public class Inventario extends JPanel {
	private JLabel nomProd, infoProd;
	private JTextField jtfNomProd;
	private JButton buscar;
	
	public Inventario() {
		nomProd = new JLabel("Nombre del producto");
		jtfNomProd = new JTextField("");
		buscar = new JButton("Buscar producto");
		infoProd = new JLabel();
		
		
		
		this.add(nomProd);
		this.add(jtfNomProd);
		this.add(buscar);
		buscar.addActionListener(new ListenerBuscarProducto(this));
		this.add(infoProd);
		
		
		
		this.setLayout(new GridLayout(4,1));
		this.setPreferredSize(new Dimension(800,200));
	}

	public JLabel getInfoProd() {
		return infoProd;
	}

	public JTextField getJtfNomProd() {
		return jtfNomProd;
	}
}
