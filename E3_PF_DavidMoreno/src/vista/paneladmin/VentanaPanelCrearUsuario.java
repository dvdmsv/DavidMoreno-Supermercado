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

public class VentanaPanelCrearUsuario extends JFrame{
	private JLabel lblNombreUsu, lblContrasena;
	private JPasswordField jtpswContrasena;
	private JTextField jtfNombreUsu;
	private JCheckBox admin;
	private JButton crear;
	
	public VentanaPanelCrearUsuario() {
		JPanel panel = new JPanel();
		lblNombreUsu = new JLabel("Nombre de usuario");
		lblContrasena = new JLabel("Contrasena");
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
		panel.setLayout((new GridLayout(4, 2)));
		panel.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
		this.getContentPane().add(panel);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(600, 400));
	}

}
