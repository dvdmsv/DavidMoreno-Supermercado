package vista.login;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoImagen extends JPanel{
	private Image imagen;
	
	public FondoImagen() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource("/imagenes/logo_super.png")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		this.setOpaque(false);
		super.paint(g);
	}
}
