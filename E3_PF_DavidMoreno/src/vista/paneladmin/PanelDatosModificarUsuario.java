package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatosModificarUsuario extends JPanel{
	private JLabel lblNom, lblNewNom, lblContr, lblNewContr, lblInfo;
	private JTextField jtfNom, jtfNewNom, jtfContr, jtfNewContr;
	
	public PanelDatosModificarUsuario() {
		lblNom = new JLabel("Nombre del usuario");
		lblNewNom = new JLabel("Nuevo nombre del usuario");
		lblContr = new JLabel("Contraseņa actual");
		lblNewContr = new JLabel("Nueva contraseņa");
		lblInfo = new JLabel();
		
		jtfNom = new JTextField();
		jtfNewNom = new JTextField();
		jtfContr = new JTextField();
		jtfNewContr = new JTextField();
		
		this.add(lblNom);
		this.add(jtfNom);
		
		this.add(lblNewNom);
		this.add(jtfNewNom);
		
		this.add(lblContr);
		this.add(jtfContr);
		
		this.add(lblNewContr);
		this.add(jtfNewContr);
		
		this.add(lblInfo);
		
		this.setLayout(new GridLayout(5,2));
		this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
	}

	public JTextField getJtfNom() {
		return jtfNom;
	}

	public JTextField getJtfNewNom() {
		return jtfNewNom;
	}

	public JTextField getJtfContr() {
		return jtfContr;
	}

	public JTextField getJtfNewContr() {
		return jtfNewContr;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}
}
