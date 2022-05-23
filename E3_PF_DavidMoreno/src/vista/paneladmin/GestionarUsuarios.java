package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerBotonCrear;

public class GestionarUsuarios extends JPanel {
	private JButton crear, eliminar, modificar;
	private ListenerBotonCrear listenerBotonCrear;
	
	public GestionarUsuarios() {
		crear = new JButton("Crear Usuario");
		eliminar = new JButton("Eliminar Usuario");
		modificar = new JButton("Modificar Usuario");
		
		crear.addActionListener(listenerBotonCrear);
		
		this.setLayout(new GridLayout(1,2));
		this.add(crear);
		this.add(eliminar);
		//this.add(modificar);
	}
}
