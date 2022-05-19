package vista.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Usuario extends JPanel{
	private JLabel lb1;
	private JTextField jtf;
	
	public Usuario() {
		lb1 = new JLabel("Nombre de usuario ");
		this.add(lb1);
		
		jtf = new JTextField(5);
		jtf.setBackground(Color.decode("#70d0d0"));
		jtf.setBorder(null);
		this.add(jtf);
		this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		
		this.setLayout(new GridLayout(1, 2));
		this.setBackground(Color.decode("#04FCFC"));
	}

	public JTextField getJtf() {
		return jtf;
	}
	
}
