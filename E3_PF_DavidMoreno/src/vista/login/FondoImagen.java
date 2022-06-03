package vista.login;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase que contiene la imagen que da fondo a la ventana para loguearse
 * @author David
 *
 */
public class FondoImagen extends JPanel{
	/**
	 * Imagen de fondo
	 */
	private Image imagen;
	
	/**
	 * Metodo que pinta la imagen seleccionada
	 */
	@Override
	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource("/imagenes/logo_super.png")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		this.setOpaque(false);
		super.paint(g);
	}
}
