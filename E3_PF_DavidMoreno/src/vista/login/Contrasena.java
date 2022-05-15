package vista.login;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Contrasena extends JPanel{
	private JLabel lb1;
	private JPasswordField jpswf;
	
	public Contrasena() {
		lb1 = new JLabel("Password");
		this.add(lb1);
		
		jpswf = new JPasswordField(5);
		this.add(jpswf);
		
		this.setLayout(new GridLayout(1, 2));

		this.setBackground(Color.decode("#04FCFC"));
	}

	public JPasswordField getJpswf() {
		return jpswf;
	}

}
