package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelDatosModificarUsuario extends JPanel{
	private JLabel lblNom, lblNewNom, lblContr, lblNewContr, lblInfo;
	private JTextField jtfNom, jtfNewNom;
	private JPasswordField jpswContr, jpswNewContr;
	private JCheckBox admin;
	
	public PanelDatosModificarUsuario() {
		lblNom = new JLabel("Nombre del usuario");
		lblNewNom = new JLabel("Nuevo nombre del usuario");
		lblContr = new JLabel("Contraseña actual");
		lblNewContr = new JLabel("Nueva contraseña");
		lblInfo = new JLabel();
		
		jtfNom = new JTextField();
		jtfNewNom = new JTextField();
		jpswContr = new JPasswordField();
		jpswNewContr = new JPasswordField();
		
		admin = new JCheckBox("Administrador");
		
		this.add(lblNom);
		this.add(jtfNom);
		
		this.add(lblNewNom);
		this.add(jtfNewNom);
		
		this.add(lblContr);
		this.add(jpswContr);
		
		this.add(lblNewContr);
		this.add(jpswNewContr);
		
		this.add(lblInfo);
		
		this.add(admin);
		
		this.setLayout(new GridLayout(5,2));
		this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
	}

	public JTextField getJtfNom() {
		return jtfNom;
	}

	public JTextField getJtfNewNom() {
		return jtfNewNom;
	}

	public JPasswordField getJpswContr() {
		return jpswContr;
	}

	public JPasswordField getJpswNewContr() {
		return jpswNewContr;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}

	public JCheckBox getAdmin() {
		return admin;
	}
}
