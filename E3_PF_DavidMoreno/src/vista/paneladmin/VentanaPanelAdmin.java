package vista.paneladmin;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPanelAdmin extends JFrame{
	private JLabel lb;
	public VentanaPanelAdmin() {
		lb = new JLabel("Panel de administrador");
		this.getContentPane().add(lb);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
