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
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
