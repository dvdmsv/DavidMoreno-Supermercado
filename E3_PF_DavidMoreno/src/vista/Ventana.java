package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import vista.login.PanelLogin;

public class Ventana extends JFrame {
	public Ventana() {
		this.setPreferredSize(new Dimension(400,300));
		this.pack();
		this.setVisible(true);	
	}
	
	public void login() {
		PanelLogin pl = new PanelLogin();
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

}
