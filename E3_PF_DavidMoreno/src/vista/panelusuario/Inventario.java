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
	private JButton buscarNom, buscarCod, buscarFam;
	
	public Inventario() {
		nomProd = new JLabel("Producto");
		jtfNomProd = new JTextField("");
		buscarNom = new JButton("Buscar producto por nombre");
		buscarCod = new JButton("Buscar producto por codigo");
		buscarFam = new JButton("Buscar producto por familia");
		
		
		this.add(nomProd);
		this.add(jtfNomProd);
		this.add(buscarNom);
		this.add(buscarCod);
		this.add(buscarFam);
		buscarNom.addActionListener(new ListenerBuscarProducto(this, 1));
		buscarCod.addActionListener(new ListenerBuscarProducto(this, 2));
		buscarFam.addActionListener(new ListenerBuscarProducto(this, 3));
		
		
		
		this.setLayout(new GridLayout(5,1));
		this.setPreferredSize(new Dimension(800,200));
	}

	public JLabel getInfoProd() {
		return infoProd;
	}

	public JTextField getJtfNomProd() {
		return jtfNomProd;
	}
}
