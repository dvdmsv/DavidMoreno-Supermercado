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
		this.getContentPane().add(panelUsuario);
		
		menu = new CerrarSesion(this);
		this.setJMenuBar(menu);
		
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(500,300));
		this.pack();
	}

}
