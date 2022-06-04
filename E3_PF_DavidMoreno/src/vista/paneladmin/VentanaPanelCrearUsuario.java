package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.controlador.ListenerCrearUsuario;
/**
 * Clase que contiene la ventana con el panel para crear usuarios
 * @author David
 *
 */
public class VentanaPanelCrearUsuario extends JFrame{
	/**
	 * JLabel que indica que el campo a su derecha es el del nombre de usuario
	 */
	private JLabel lblNombreUsu;
	/**
	 * JLabel que indica que el campo a su derecha es el de la contraseña
	 */
	private JLabel lblContrasena; 
	/**
	 * JLabel que muestra posibles errores
	 */
	private JLabel lblInfo;
	/**
	 * JPasswordField que contiene la contraseña
	 */
	private JPasswordField jtpswContrasena;
	/**
	 * JTextField que contiene el nombre de usuario
	 */
	private JTextField jtfNombreUsu;
	/**
	 * JCheckBox que habilita si el usuario va a tener permisos de administrador
	 */
	private JCheckBox admin;
	/**
	 * Boton para iniciar el proceso de creacion del usuario
	 */
	private JButton crear;
	
	/**
	 * Contructor de la clase VentanaPanelCrearUsuario
	 */
	public VentanaPanelCrearUsuario() {
		super("GALDI -Crear Usuario-");
		JPanel panel = new JPanel();
		lblNombreUsu = new JLabel("Nombre de usuario");
		lblContrasena = new JLabel("Contrasena");
		lblInfo = new JLabel();
		jtfNombreUsu = new JTextField();
		jtpswContrasena = new JPasswordField();
		admin = new JCheckBox("Administrador");
		crear = new JButton("Crear");
		
		panel.add(lblNombreUsu);
		panel.add(jtfNombreUsu);
		panel.add(lblContrasena);
		panel.add(jtpswContrasena);
		panel.add(admin);
		panel.add(crear);
		panel.add(lblInfo);
		
		crear.addActionListener(new ListenerCrearUsuario(this));
		
		panel.setLayout((new GridLayout(4, 2)));
		panel.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
		this.getContentPane().add(panel);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(600, 400));
	}
	/**
	 * Metodo que devuelve el JLabel
	 * @return lblInfo Contendrá informacion sobre la inserción del usuario
	 */
	public JLabel getLblInfo() {
		return lblInfo;
	}
	/**
	 * Metodo que devuelve el JPasswordField con la contraseña para el usuario
	 * @return jtpswContrasena
	 */
	public JPasswordField getJtpswContrasena() {
		return jtpswContrasena;
	}
	/**
	 * Metodo que devuelve el JTextField con el nombre de usuario
	 * @return jtfNombreUsu contiene el nombre del usuario a crear
	 */
	public JTextField getJtfNombreUsu() {
		return jtfNombreUsu;
	}
	/**
	 * JCheckBox que habilita si el usuario va a ser admin
	 * @return admin para comprobar si se ha marcado y darle permisos
	 */
	public JCheckBox getAdmin() {
		return admin;
	}
}
