package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * Clase que contiene el panel con los campos para modificar al usuario
 * @author David
 *
 */
public class PanelDatosModificarUsuario extends JPanel{
	/**
	 * JLabel que indica que a su derecha está el campo nombre
	 */
	private JLabel lblNom;
	/**
	 * JLabel que indica que a su derecha está el campo para el nuevo nombre
	 */
	private JLabel lblNewNom; 
	/**
	 * JLabel que indica que a su derecha está el campo contraseña
	 */
	private JLabel lblContr;
	/**
	 * JLabel que indica que a su derecha está el campo para la nueva contraseña
	 */
	private JLabel lblNewContr;
	/**
	 * JLabel que muestra posibles errores de insercion de datos
	 */
	private JLabel lblInfo;
	/**
	 * JTextField que almacena el nombre
	 */
	private JTextField jtfNom;
	/**
	 * JTextField que almacena el nuevo nombre
	 */
	private JTextField jtfNewNom;
	/**
	 * JTextField que almacena la contraseña
	 */
	private JPasswordField jpswContr;
	/**
	 * JTextField que almacena la nueva contraseña
	 */
	private JPasswordField jpswNewContr;
	/**
	 * JCheckBox que habilita los permisos de administrador para el usuario
	 */
	private JCheckBox admin;
	/**
	 * Contructor de la clase PanelDatosModificarUsuario
	 */
	public PanelDatosModificarUsuario() {
		lblNom = new JLabel("Nombre del usuario");
		lblNewNom = new JLabel("Nuevo nombre del usuario");
		lblContr = new JLabel("Contraseña actual");
		lblNewContr = new JLabel("Nueva contraseña");
		lblInfo = new JLabel();
		
		jtfNom = new JTextField();
		jtfNewNom = new JTextField();
		jpswContr = new JPasswordField();
		jpswNewContr = new JPasswordField();
		
		admin = new JCheckBox("Administrador");
		
		this.add(lblNom);
		this.add(jtfNom);
		
		this.add(lblNewNom);
		this.add(jtfNewNom);
		
		this.add(lblContr);
		this.add(jpswContr);
		
		this.add(lblNewContr);
		this.add(jpswNewContr);
		
		this.add(lblInfo);
		
		this.add(admin);
		
		this.setLayout(new GridLayout(5,2));
		this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
	}
	/**
	 * Metodo que devuelve el JTextField con el nombre
	 * @return jtfNom contiene el nombre actual del usuario
	 */
	public JTextField getJtfNom() {
		return jtfNom;
	}
	/**
	 * Metodo que devuelve el JTextField con el nuevo nombre
	 * @return jtfNewNom contiene el nuevo nombre del usuario
	 */
	public JTextField getJtfNewNom() {
		return jtfNewNom;
	}
	/**
	 * Metodo que devuelve el JPasswordField con la contraseña
	 * @return jpswContr contiene la contraseña del usuario
	 */
	public JPasswordField getJpswContr() {
		return jpswContr;
	}
	/**
	 * Metodo que devuelve el JPasswordField con la nueva contraseña
	 * @return jpswNewContr contiene la contraseña nueva contraseña del usuario
	 */
	public JPasswordField getJpswNewContr() {
		return jpswNewContr;
	}
	/**
	 * Metodo que devuelve el JLabel con informacion
	 * @return lblInfo contiene informacion sobre errores
	 */
	public JLabel getLblInfo() {
		return lblInfo;
	}
	/**
	 * Metodo que devuelve el JCheckBox con el modo administrador
	 * @return admipara comprobar si se ha marcado y otorgar al usuario permisos de admin
	 */
	public JCheckBox getAdmin() {
		return admin;
	}
}
