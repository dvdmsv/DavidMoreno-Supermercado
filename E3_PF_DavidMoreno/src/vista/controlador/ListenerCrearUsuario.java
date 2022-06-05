package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.VentanaPanelCrearUsuario;
/**
 * Clase que contiene la logica para crear un usuario
 * @author David
 *
 */
public class ListenerCrearUsuario implements ActionListener{
	/**
	 * Panel que contiene todos los datos del usuario
	 */
	VentanaPanelCrearUsuario vpcu;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	Supermercado superm = new Supermercado();
	
	/**
	 * Contructor de ListenerCrearUsuario
	 * @param vpcu Panel que contiene todos los datos del usuario
	 */
	public ListenerCrearUsuario(VentanaPanelCrearUsuario vpcu) {
		this.vpcu = vpcu;
	}
	/**
	 * Metodo que contiene la logica para crear un usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String nom = vpcu.getJtfNombreUsu().getText(); //Se ontiene el nombre de usuario
		String pass = superm.generarHash(vpcu.getJtpswContrasena().getText()); //Se obtiene la contraseña 
		String admin="F"; //Se indica por defecto que el usuario no se admnistrador
		if(vpcu.getAdmin().isSelected()) { //Si el checkbox está marcado 
			admin = "T"; //El usuario admnistrador se cambia a T
		}
		if(superm.buscarUsuario(nom) || vpcu.getJtfNombreUsu().getText().isEmpty()) { //Si el usuario existe
			vpcu.getLblInfo().setText("El usuario ya existe o está vacio"); //Se indica que ya existe
			vpcu.getLblInfo().setForeground(Color.red);
			vpcu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			vpcu.getJtfNombreUsu().setText("");
			vpcu.getJtpswContrasena().setText("");
		}else if( vpcu.getJtpswContrasena().getText().isEmpty()) {
			vpcu.getLblInfo().setText("No se ha indicado contrasena");
			vpcu.getLblInfo().setForeground(Color.red);
			vpcu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			vpcu.getJtfNombreUsu().setText("");
			vpcu.getJtpswContrasena().setText("");
		}else { //Si no existe se crea
			superm.crearUsuario(nom, pass, admin);
			if(superm.loginCorrecto(nom, superm.generarHash(vpcu.getJtpswContrasena().getText()))) {
				vpcu.getLblInfo().setText("Usuario añadido correctamente");
				vpcu.getLblInfo().setForeground(Color.green);
				vpcu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				vpcu.getJtfNombreUsu().setText("");
				vpcu.getJtpswContrasena().setText("");
			}
		}
	}
}
