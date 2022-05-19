package vista.panelusuario;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class VentanaPanelUsuario extends JFrame{
	private PanelUsuario panelUsuario;
	private JMenuBar menu;
	
	public VentanaPanelUsuario() {
		super("Galimerca");
		panelUsuario = new PanelUsuario();
		panelUsuario.setSize(4000,5000);
		this.getContentPane().add(panelUsuario);
		
		menu = new CerrarSesion(this);
		this.setJMenuBar(menu);
		
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(new Dimension(1000, 500));
	}

}
