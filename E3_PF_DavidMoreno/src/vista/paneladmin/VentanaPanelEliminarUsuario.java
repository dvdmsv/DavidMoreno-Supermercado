package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerEliminarUsuario;
/**
 * Clase que contiene la ventana con el panel para eliminar usuarios
 * @author David
 *
 */
public class VentanaPanelEliminarUsuario extends JFrame{
	/**
	 * JLabel que indica que el campo a su derecha es el del nombre de usuario
	 */
	private JLabel lblNombreUsu; 
	/**
	 * JLabel que mostrará informacion sobre la eliminación del usuario
	 */
	private JLabel lblInfo;
	/**
	 * JTextField que almacena el nombre de usuario a eliminar
	 */
	private JTextField jtfNombreUsu;
	/**
	 * Boton para iniciar el proceso de eliminación
	 */
	private JButton eliminar;
	/**
	 * Constructor de la clase VentanaPanelEliminarUsuario
	 */
	public VentanaPanelEliminarUsuario() {
		super("GALDI -Eliminar Usuario-");
		JPanel panel = new JPanel();
		lblNombreUsu = new JLabel("Nombre de usuario");
		lblInfo = new JLabel();
		jtfNombreUsu = new JTextField();
		eliminar = new JButton("Eliminar");
		
		panel.add(lblNombreUsu);
		panel.add(jtfNombreUsu);
		panel.add(eliminar);
		panel.add(lblInfo);
		
		eliminar.addActionListener(new ListenerEliminarUsuario(this));
		
		panel.setLayout((new GridLayout(4, 2)));
		panel.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
		this.getContentPane().add(panel);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(600, 400));
	}
	/**
	 * Metodo que devuelve el JLabel para informar
	 * @return lblInfo mostrará informacion sobre la eliminación del usuario
	 */
	public JLabel getLblInfo() {
		return lblInfo;
	}
	/**
	 * Metodo que devuelve el JTextField que contiene el nombre de usuario
	 * @return jtfNombreUsu contiene el nombre de usuario a eliminar
	 */
	public JTextField getJtfNombreUsu() {
		return jtfNombreUsu;
	}
}
