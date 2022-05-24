package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class VentanaPanelModificarUsuario extends JFrame{
	private PanelDatosModificarUsuario pdmu;
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
