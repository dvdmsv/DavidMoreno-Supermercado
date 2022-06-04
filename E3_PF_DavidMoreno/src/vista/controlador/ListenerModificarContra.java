package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.PanelDatosModificarUsuario;
/**
 * Clase que contiene la logica para modificar la contraseña
 * @author David
 *
 */
public class ListenerModificarContra implements ActionListener{
	/**
	 * JPanel que contiene los datos del usuario
	 */
	private PanelDatosModificarUsuario pdmu;
	/**
	 * Clase que contiene todos los metodos de la aplicacion
	 */
	private Supermercado superm = new Supermercado();
	/**
	 * Contructor de la clase ListenerModificarContra
	 * @param pdmu JPanel que contiene los datos del usuario
	 */
	public ListenerModificarContra(PanelDatosModificarUsuario pdmu) {
		this.pdmu = pdmu;
	}
	/**
	 * Metodo que contiene la logica para modificar la contraseña
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.buscarUsuario(pdmu.getJtfNom().getText())) { //Si el usuario existe en la base de datos
			System.out.println("Existe");
			if(superm.loginCorrecto(pdmu.getJtfNom().getText(), superm.generarHash(pdmu.getJpswContr().getText()))) { //Si la contraseña del usuario es correcta
				System.out.println("Contra correcta");
				if(!pdmu.getJpswContr().getText().equals(pdmu.getJpswNewContr().getText())) { //Si la contraseña actual NO es igual que la nueva
					superm.modificarContra(pdmu.getJtfNom().getText(), superm.generarHash(pdmu.getJpswNewContr().getText()));
					pdmu.getLblInfo().setText("Contraseña cambiada correctamente");
					pdmu.getLblInfo().setForeground(Color.green);
					pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
					pdmu.getJtfNom().setText("");
					pdmu.getJpswContr().setText("");
					pdmu.getJpswNewContr().setText("");
				}else {
					pdmu.getLblInfo().setText("Las contraseñas son iguales");
					pdmu.getLblInfo().setForeground(Color.red);
					pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
					pdmu.getJpswNewContr().setText("");
				}
			}else {
				pdmu.getLblInfo().setText("Contrasena actual incorrecta");
				pdmu.getLblInfo().setForeground(Color.red);
				pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
				pdmu.getJpswContr().setText("");	
			}
		}else {
			pdmu.getLblInfo().setText("El usuario no existe");
			pdmu.getLblInfo().setForeground(Color.red);
			pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			pdmu.getJtfNom().setText("");
		}
	}

}
