package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerBuscarVenta;

public class Ventas extends JPanel{
	private JLabel lblBuscar;
	private JTextField jtfDatos;
	private JButton buscarNomUsu, buscarCodUsu;
	
	public Ventas() {
		lblBuscar = new JLabel("Buscar venta");
		jtfDatos = new JTextField();
		buscarNomUsu = new JButton("Buscar ventas por codigo de producto");
		buscarCodUsu = new JButton("Buscar ventas por codigo de usuario");
		
		buscarNomUsu.addActionListener(new ListenerBuscarVenta(this, 1));
		buscarCodUsu.addActionListener(new ListenerBuscarVenta(this, 2));
		
		this.add(lblBuscar);
		this.add(jtfDatos);
		this.add(buscarNomUsu);
		this.add(buscarCodUsu);
		
		this.setLayout(new GridLayout(5,1));
		this.setPreferredSize(new Dimension(800,200));
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}

	public JTextField getJtfDatos() {
		return jtfDatos;
	}
}
