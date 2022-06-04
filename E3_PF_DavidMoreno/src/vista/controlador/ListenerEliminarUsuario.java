package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import supermercado.Supermercado;
import vista.paneladmin.VentanaPanelEliminarUsuario;
/**
 * Clase que contiene la logica para eliminar un usuario
 * @author David
 *
 */
public class ListenerEliminarUsuario implements ActionListener {
	/**
	 * Ventana con los datos del usuario
	 */
	private VentanaPanelEliminarUsuario vpeu;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	Supermercado superm = new Supermercado();
	/**
	 * Constructor de la clase ListenerEliminarUsuario
	 * @param vpeu Ventana con los datos del usuario
	 */
	public ListenerEliminarUsuario(VentanaPanelEliminarUsuario vpeu) {
		this.vpeu = vpeu;
	}
	/**
	 * Metodo que contiene la logica para eliminar un usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.buscarUsuario(vpeu.getJtfNombreUsu().getText())){ //Si el usuario existe
			int confirmado = JOptionPane.showConfirmDialog(null, "Seguro que se quiere eliminar?");
			if(JOptionPane.OK_OPTION == confirmado) { //Si se confirma la eliminacion
				superm.eliminarUsuario(vpeu.getJtfNombreUsu().getText()); //Se elimina
				if(!superm.buscarUsuario(vpeu.getJtfNombreUsu().getText())) { //Si no se encuentra
					vpeu.getLblInfo().setText("Usuario eliminado correctamente");
					vpeu.getLblInfo().setForeground(Color.green);
					vpeu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
					vpeu.getJtfNombreUsu().setText("");
				}
			}else { //Si no se confirma la eliminacion
				vpeu.getLblInfo().setText("El usuario no se eliminara");
				vpeu.getLblInfo().setForeground(Color.black);
				vpeu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				vpeu.getJtfNombreUsu().setText("");
			}
		}else { //Si el usuario no existe
			vpeu.getLblInfo().setText("El usuario no existe");
			vpeu.getLblInfo().setForeground(Color.red);
			vpeu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			vpeu.getJtfNombreUsu().setText("");
		}
	}
}
