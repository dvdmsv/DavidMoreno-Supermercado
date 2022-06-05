package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.PanelDatosModificarUsuario;
/**
 * Clase que contiene la logica para modificar el nombre de un usuario
 * @author David
 *
 */
public class ListenerModificarNombre implements ActionListener{
	/**
	 * JPanel que contiene los datos del usuario
	 */
	private PanelDatosModificarUsuario pdmu;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	/**
	 * Constructor de la clase ListenerModificarNombre
	 * @param pdmu JPanel que contiene los datos del usuario
	 */
	public ListenerModificarNombre(PanelDatosModificarUsuario pdmu) {
		this.pdmu = pdmu;
	}
	/**
	 * Metodo que contiene la logica para cambiar el nombre de usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.buscarUsuario(pdmu.getJtfNom().getText())) { //Si el usuario a modificar existe
			if(pdmu.getJtfNom().getText().equals("admin")){ //Si el usuario es admin
				pdmu.getLblInfo().setText("No se puede cambair de nombre a admin");
				pdmu.getLblInfo().setForeground(Color.red);
				pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				pdmu.getJtfNom().setText("");
			}else {
				if(!superm.buscarUsuario(pdmu.getJtfNewNom().getText())) { //Si el nuevo nombre de usuario no existe en la base de datos
					superm.modificarNombre(pdmu.getJtfNewNom().getText(), pdmu.getJtfNom().getText());
					if(superm.buscarUsuario(pdmu.getJtfNewNom().getText())) {
						pdmu.getLblInfo().setText("Nombre cambiado correctamente");
						pdmu.getLblInfo().setForeground(Color.green);
						pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
						pdmu.getJtfNom().setText("");
						pdmu.getJtfNewNom().setText("");
					}
				}else {
					pdmu.getLblInfo().setText("Ese nombre de usuario ya existe");
					pdmu.getLblInfo().setForeground(Color.red);
					pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
					pdmu.getJtfNewNom().setText("");
				}
			}
		}else {
			pdmu.getLblInfo().setText("El usuario no existe");
			pdmu.getLblInfo().setForeground(Color.red);
			pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			pdmu.getJtfNom().setText("");
		}
	}
}
