package vista.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

public class PanelLogin2 extends JPanel{
	private VentanaLogin vL;
	
	public PanelLogin2 (VentanaLogin vL) {
		this.vL = vL;
		
		this.setBackground(Color.decode("#04FCFC"));
		
		
		this.setLayout(null);
		componentes();
		
	}
	
	public void componentes() {
		JLabel nomUsu = new JLabel("Nombre de usuario");
		JPasswordField contrasena = new JPasswordField();
		JButton iniciarSesion = new JButton();
		JButton limpiar = new JButton();
		JLabel info = new JLabel();
		
		nomUsu.setBounds(10, 10, 30, 50);
		
		
		this.add(nomUsu);
		this.add(contrasena);
		this.add(iniciarSesion);
		this.add(limpiar);
		this.add(info);
		
	}

}
