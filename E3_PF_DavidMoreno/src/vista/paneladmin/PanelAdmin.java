package vista.paneladmin;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import vista.panelusuario.Caja;
import vista.panelusuario.Inventario;

public class PanelAdmin extends JPanel{
	private Caja caja;
	private Inventario inventario;
	private GestionarUsuarios gestionarUsu;
	private IntroducirProductos introProd;
	private Ventas ventas;
	
	public PanelAdmin() {
		JTabbedPane jtp = new JTabbedPane();
		caja = new Caja();
		inventario = new Inventario();
		gestionarUsu = new GestionarUsuarios();
		introProd = new IntroducirProductos();
		ventas = new Ventas();
		
		jtp.add("Caja", caja);
		jtp.add("Inventario", inventario);
		jtp.add("Gestionar Usuarios", gestionarUsu);
		jtp.add("Introducir productos", introProd);
		jtp.add("Ventas", ventas);
		
		
		this.add(jtp);
		this.setBackground(Color.decode("#04FCFC"));
		this.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
		
	}
}
