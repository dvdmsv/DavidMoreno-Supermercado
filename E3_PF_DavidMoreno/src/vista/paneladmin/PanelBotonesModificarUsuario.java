package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerModificarContra;
import vista.controlador.ListenerModificarNombre;
import vista.controlador.ListenerModificarPermiso;
/**
 * Clase que contiene el panel con los botones para modificar a unusuario
 * @author David
 *
 */
public class PanelBotonesModificarUsuario extends JPanel{
	/**
	 * Boton para modificar el nombre
	 */
	private JButton btModNom;
	/**
	 * Boton para modificar la contraseña
	 */
	private JButton btModContra;
	/**
	 * Boton para modificar los permisos de administrador
	 */
	private JButton btModAdmin;
	/**
	 * Constructor de la clase PanelBotonesModificarUsuario
	 * @param pdmu Recibe como parametro PanelDatosModificarUsuario, que es el JPanel principal con los campos para modificar al usuario
	 */
	public PanelBotonesModificarUsuario(PanelDatosModificarUsuario pdmu) {
		btModNom = new JButton("Modificar nombre");
		btModNom.addActionListener(new ListenerModificarNombre(pdmu));
		
		btModContra = new JButton("Modificar contraseña");
		btModContra.addActionListener(new ListenerModificarContra(pdmu));
		
		btModAdmin = new JButton("Modificar permiso");
		btModAdmin.addActionListener(new ListenerModificarPermiso(pdmu));
		
		this.add(btModNom);
		this.add(btModContra);
		this.add(btModAdmin);
		this.setLayout(new GridLayout(1,3));
		this.setBorder(BorderFactory.createEmptyBorder(0,50,50,50));
	}
}
