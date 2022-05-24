package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerBotonCrear;
import vista.controlador.ListenerBotonEliminar;

public class GestionarUsuarios extends JPanel {
	private JButton crear, eliminar, modificar;
	
	public GestionarUsuarios() {
		crear = new JButton("Crear Usuario");
		eliminar = new JButton("Eliminar Usuario");
		modificar = new JButton("Modificar Usuario");
		
		crear.addActionListener(new ListenerBotonCrear());
		eliminar.addActionListener(new ListenerBotonEliminar());
		
		this.setLayout(new GridLayout(1,2));
		this.add(crear);
		this.add(eliminar);
		//this.add(modificar);
	}
}
