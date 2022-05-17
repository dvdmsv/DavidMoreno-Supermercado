package vista.panelusuario;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPanelUsuario extends JFrame{
	private JLabel lb1;
	
	public VentanaPanelUsuario() {
		lb1 = new JLabel("Panel de usuario");
		this.getContentPane().add(lb1);
		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(500,300));
	}

}
