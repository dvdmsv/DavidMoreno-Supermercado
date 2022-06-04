package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.PanelDatosModificarUsuario;
/**
 * Clase que contiene la logica para modificar el permiso de un usuario
 * @author David
 *
 */
public class ListenerModificarPermiso implements ActionListener{
	/**
	 * Panel con los datos para modificar el usuario
	 */
	private PanelDatosModificarUsuario pdmu;
	/**
	 * Clase que contienetodos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	/**
	 * Constructor de ListenerModificarPermiso
	 * @param pdmu Panel con los datos para modificar el usuario
	 */
	public ListenerModificarPermiso(PanelDatosModificarUsuario pdmu) {
		this.pdmu = pdmu;
	}
	/**
	 * Metodo con la logica para modificar el permiso de administrador en un usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(pdmu.getAdmin().isSelected()) { //Si la casilla está marcada
			if(superm.buscarUsuario(pdmu.getJtfNom().getText())) { //Si el usuario existe
				pdmu.getLblInfo().setText("El usuario ahora es admin");
				pdmu.getLblInfo().setForeground(Color.green);
				pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				superm.modificarPermiso(pdmu.getJtfNom().getText(), 1);
				pdmu.getAdmin().setSelected(false);
				pdmu.getJtfNom().setText("");
			}else {
				pdmu.getLblInfo().setText("Usuario no existe");
				pdmu.getLblInfo().setForeground(Color.red);
				pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				pdmu.getJtfNom().setText("");
			}
		}else if(pdmu.getJtfNom().getText().equals("admin")) {
			pdmu.getLblInfo().setText("admin no puede quedarse sin permisos");
			pdmu.getLblInfo().setForeground(Color.red);
			pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			pdmu.getJtfNom().setText("");
		}else {
			superm.modificarPermiso(pdmu.getJtfNom().getText(), 2);
			pdmu.getLblInfo().setText("El usuario ya no es admin");
			pdmu.getLblInfo().setForeground(Color.green);
			pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			pdmu.getJtfNom().setText("");
		}
		
	}

}
