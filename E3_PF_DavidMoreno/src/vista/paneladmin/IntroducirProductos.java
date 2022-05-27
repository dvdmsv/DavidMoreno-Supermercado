package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerIntroducirProd;

public class IntroducirProductos extends JPanel{
	private JLabel lblNomProd, lblFamProd, lblCantProd, lblPrecProd, lblIVAProd, lblInfo;
	private JTextField jtfNomProd, jtfFamProd, jtfCantProd, jtfPrecProd;
	private JButton btIntro, btLimpiar;
	private JComboBox<String> jcIVAProd;
	
	public IntroducirProductos() {
		lblNomProd = new JLabel("Nombre del producto");
		lblFamProd = new JLabel("Familia del producto");
		lblCantProd = new JLabel("Cantidad del producto");
		lblPrecProd = new JLabel("Precio del producto");
		lblIVAProd = new JLabel("IVA del producto");
		lblInfo = new JLabel();
		
		jtfNomProd = new JTextField();
		jtfFamProd = new JTextField();
		jtfCantProd = new JTextField();
		jtfPrecProd = new JTextField();
		
		btIntro = new JButton("Introducir producto");
		btIntro.addActionListener(new ListenerIntroducirProd(this));
		
		btLimpiar = new JButton("Limpiar");

		jcIVAProd = new JComboBox<String>();
		jcIVAProd.addItem("");
		jcIVAProd.addItem("4%");
		jcIVAProd.addItem("10%");
		jcIVAProd.addItem("21%");
		
		
		this.setLayout(new GridLayout(7,2));
		this.add(lblNomProd);
		this.add(jtfNomProd);
		
		this.add(lblFamProd);
		this.add(jtfFamProd);
		
		this.add(lblCantProd);
		this.add(jtfCantProd);
		
		this.add(lblPrecProd);
		this.add(jtfPrecProd);
		
		this.add(lblIVAProd);
		this.add(jcIVAProd);
		
		this.add(btIntro);
		this.add(btLimpiar);
		
		this.add(lblInfo);
		
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}

	public JTextField getJtfNomProd() {
		return jtfNomProd;
	}

	public JTextField getJtfFamProd() {
		return jtfFamProd;
	}

	public JTextField getJtfCantProd() {
		return jtfCantProd;
	}

	public JTextField getJtfPrecProd() {
		return jtfPrecProd;
	}

	
	public JComboBox<String> getJcIVAProd() {
		return jcIVAProd;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}
}
