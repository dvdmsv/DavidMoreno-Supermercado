package vista.login;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Usuario extends JPanel{
	private JLabel lb1;
	private JTextField jtf;
	
	public Usuario() {
		lb1 = new JLabel("Nombre de usuario");
		this.add(lb1);
		
		jtf = new JTextField(5);
		this.add(jtf);
		
		this.setLayout(new GridLayout(1, 2));
	}
}
