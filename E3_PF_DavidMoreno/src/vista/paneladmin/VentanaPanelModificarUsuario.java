package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
/**
 * Clase que contiene la ventana con el panel para modificar usuarios
 * @author David
 *
 */
public class VentanaPanelModificarUsuario extends JFrame{
	/**
	 * JPanel con los campos para modificar al usuario
	 */
	private PanelDatosModificarUsuario pdmu;
	/**
	 * JPanel con los botones para modificar al usuario
	 */
	private PanelBotonesModificarUsuario pbmu;
	
	public VentanaPanelModificarUsuario() {
		super("GALDI -Modificar Usuario-");
		pdmu = new PanelDatosModificarUsuario();
		
		pbmu = new PanelBotonesModificarUsuario(pdmu);
		
		this.getContentPane().add(pdmu);
		this.getContentPane().add(pbmu);
		
		this.setLayout(new GridLayout(2,1));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(600, 400));
	}
}
