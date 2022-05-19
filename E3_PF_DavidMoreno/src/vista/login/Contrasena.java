package vista.login;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Contrasena extends JPanel{
	private JLabel lb1;
	private JPasswordField jpswf;
	
	public Contrasena() {
		lb1 = new JLabel("Password");
		this.add(lb1);
		
		jpswf = new JPasswordField(5);
		jpswf.setBackground(Color.decode("#70d0d0"));
		jpswf.setBorder(null);
		this.add(jpswf);
	
		this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		this.setLayout(null);
		
		
		this.setLayout(new GridLayout(1, 2));

		this.setBackground(Color.decode("#04FCFC"));
	}

	public JPasswordField getJpswf() {
		return jpswf;
	}

}
