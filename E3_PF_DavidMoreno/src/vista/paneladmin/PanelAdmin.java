package vista.paneladmin;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import vista.panelusuario.Caja;
import vista.panelusuario.Inventario;

public class PanelAdmin extends JPanel{
	private Caja caja;
	private Inventario inventario;
	private GestionarUsuarios gestionarUsu;
	
	public PanelAdmin() {
		JTabbedPane jtp = new JTabbedPane();
		caja = new Caja();
		inventario = new Inventario();
		gestionarUsu = new GestionarUsuarios();
		
		jtp.add("Caja", caja);
		jtp.add("Inventario", inventario);
		jtp.add("Gestionar Usuarios", gestionarUsu);
		
		
		this.add(jtp);
		this.setBackground(Color.decode("#04FCFC"));
		this.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
		
	}
}
