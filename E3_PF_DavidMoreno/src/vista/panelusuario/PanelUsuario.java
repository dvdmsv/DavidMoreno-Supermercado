package vista.panelusuario;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelUsuario extends JPanel {
	private Caja caja;
	private Inventario inventario;
	
	public PanelUsuario() {
		JTabbedPane jtp = new JTabbedPane();
		caja = new Caja();
		inventario = new Inventario();
		
		jtp.add("Caja", caja);
		jtp.add("Inventario", inventario);
		
		this.add(jtp);
		this.setBackground(Color.decode("#04FCFC"));
		this.setSize(400,300);
	}

}
