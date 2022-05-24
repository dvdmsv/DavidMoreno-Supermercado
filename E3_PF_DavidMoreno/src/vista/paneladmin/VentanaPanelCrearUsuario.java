package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.controlador.ListenerCrearUsuario;

public class VentanaPanelCrearUsuario extends JFrame{
	private JLabel lblNombreUsu, lblContrasena, lblInfo;
	private JPasswordField jtpswContrasena;
	private JTextField jtfNombreUsu;
	private JCheckBox admin;
	private JButton crear;
	
	
	public VentanaPanelCrearUsuario() {
		super("GALDI -Crear Usuario-");
		JPanel panel = new JPanel();
		lblNombreUsu = new JLabel("Nombre de usuario");
		lblContrasena = new JLabel("Contrasena");
		lblInfo = new JLabel();
		jtfNombreUsu = new JTextField();
		jtpswContrasena = new JPasswordField();
		admin = new JCheckBox("Administrador");
		crear = new JButton("Crear");
		
		panel.add(lblNombreUsu);
		panel.add(jtfNombreUsu);
		panel.add(lblContrasena);
		panel.add(jtpswContrasena);
		panel.add(admin);
		panel.add(crear);
		panel.add(lblInfo);
		
		crear.addActionListener(new ListenerCrearUsuario(this));
		
		panel.setLayout((new GridLayout(4, 2)));
		panel.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
		this.getContentPane().add(panel);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(600, 400));
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}



	public JPasswordField getJtpswContrasena() {
		return jtpswContrasena;
	}

	public JTextField getJtfNombreUsu() {
		return jtfNombreUsu;
	}

	public JCheckBox getAdmin() {
		return admin;
	}

	public JButton getCrear() {
		return crear;
	}
}
