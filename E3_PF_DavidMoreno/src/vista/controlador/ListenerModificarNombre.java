package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.PanelBotonesModificarUsuario;
import vista.paneladmin.PanelDatosModificarUsuario;

public class ListenerModificarNombre implements ActionListener{
	private PanelDatosModificarUsuario pdmu;
	private Supermercado superm = new Supermercado();
	
	public ListenerModificarNombre(PanelDatosModificarUsuario pdmu) {
		this.pdmu = pdmu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(superm.buscarUsuario(pdmu.getJtfNom().getText())) { //Si el usuario a modificar existe
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
		}else {
			pdmu.getLblInfo().setText("El usuario no existe");
			pdmu.getLblInfo().setForeground(Color.red);
			pdmu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 15));
			pdmu.getJtfNom().setText("");
		}
		
	}

}
