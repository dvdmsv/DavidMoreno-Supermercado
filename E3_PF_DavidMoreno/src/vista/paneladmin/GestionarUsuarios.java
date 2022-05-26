package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerBotonCrear;
import vista.controlador.ListenerBotonEliminar;
import vista.controlador.ListenerBotonModificar;

public class GestionarUsuarios extends JPanel {
	private JButton crear, eliminar, modificar;
	
	public GestionarUsuarios() {
		crear = new JButton("Crear Usuario");
		eliminar = new JButton("Eliminar Usuario");
		modificar = new JButton("Modificar Usuario");
		
		crear.addActionListener(new ListenerBotonCrear());
		eliminar.addActionListener(new ListenerBotonEliminar());
		modificar.addActionListener(new ListenerBotonModificar());
		
		this.setLayout(new GridLayout(1,3));
		this.add(crear);
		this.add(eliminar);
		this.add(modificar);
		this.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
	}
}
