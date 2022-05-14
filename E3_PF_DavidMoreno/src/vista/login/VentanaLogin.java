package vista.login;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaLogin extends JFrame {
	private PanelLogin pl = new PanelLogin();
	
	public VentanaLogin() {
		this.setPreferredSize(new Dimension(400,200));
		this.pack();
		this.setVisible(true);	
	}
	
	public void login() {
		this.add(pl);
	}
	
	public void botonNoRegistrado() {
		JButton b1 = new JButton("Boton no registrado");
		this.add(b1);
	}
	
	public void botonRegistrado() {
		JButton b2 = new JButton("Boton registrado");
		this.add(b2);
	}

	public PanelLogin getPl() {
		return pl;
	}

	public void setPl(PanelLogin pl) {
		this.pl = pl;
	}
}
