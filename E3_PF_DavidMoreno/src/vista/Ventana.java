package vista;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana() {
		
		
		
		
		
		this.pack();
		this.setVisible(true);	
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
