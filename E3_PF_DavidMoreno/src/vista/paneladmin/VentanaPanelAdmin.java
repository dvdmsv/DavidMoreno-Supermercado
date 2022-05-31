package vista.paneladmin;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import vista.panelusuario.CerrarSesion;
import vista.panelusuario.PanelUsuario;

public class VentanaPanelAdmin extends JFrame{
	private PanelAdmin panelAdmin;
	private JMenuBar menu;
	
	public VentanaPanelAdmin() {
		super("GALDI -Panel de Admin-");
		panelAdmin = new PanelAdmin();
		this.getContentPane().add(panelAdmin);

		menu = new CerrarSesion(this);
		this.setJMenuBar(menu);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}