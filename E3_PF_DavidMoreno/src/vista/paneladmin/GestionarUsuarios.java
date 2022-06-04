package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerBotonCrear;
import vista.controlador.ListenerBotonEliminar;
import vista.controlador.ListenerBotonModificar;
/**
 * Clase que contiene el panel para gestionar los usuarios
 * @author David
 *
 */
public class GestionarUsuarios extends JPanel {
	/**
	 * Boton para desplegar la ventana para crear usuarios
	 */
	private JButton crear; 
	/**
	 * Boton para desplegar la ventana para eliminar usuarios
	 */
	private JButton eliminar; 
	/**
	 * Boton para desplegar la ventana para modificar usuarios
	 */
	private JButton modificar;
	/**
	 * Constructor de la clase GestionarUsuarios
	 */
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
