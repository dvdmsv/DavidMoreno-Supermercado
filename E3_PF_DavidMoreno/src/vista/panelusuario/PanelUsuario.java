package vista.panelusuario;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * Clase que contiene un JPanel con el panel del usuario normal
 * @author David
 *
 */
public class PanelUsuario extends JPanel {
	/**
	 * JPanel del contenido de la pestaña Caja
	 */
	private Caja caja;
	/**
	 * JPanel del contenido de la pestaña Inventario
	 */
	private Inventario inventario;
	/**
	 * Constructor de Caja
	 */
	public PanelUsuario() {
		JTabbedPane jtp = new JTabbedPane();
		caja = new Caja();
		inventario = new Inventario();
		
		jtp.add("Caja", caja);
		jtp.add("Inventario", inventario);
		
		
		this.add(jtp);
		this.setBackground(Color.decode("#04FCFC"));
		this.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
	}
}
