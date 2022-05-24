package vista.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supermercado.Supermercado;
import vista.paneladmin.VentanaPanelCrearUsuario;

public class ListenerCrearUsuario implements ActionListener{
	VentanaPanelCrearUsuario vpcu;
	Supermercado superm = new Supermercado();
	
	
	public ListenerCrearUsuario(VentanaPanelCrearUsuario vpcu) {
		this.vpcu = vpcu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nom = vpcu.getJtfNombreUsu().getText();
		String pass = superm.generarHash(vpcu.getJtpswContrasena().getText());
		String admin="F";
		if(vpcu.getAdmin().isSelected()) {
			admin = "T";
		}
		
		if(superm.buscarUsuario(nom)) {
			vpcu.getLblInfo().setText("El usuario ya existe");
			vpcu.getLblInfo().setForeground(Color.red);
			vpcu.getLblInfo().setFont(new Font("Serif", Font.PLAIN, 20));
		}else {
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
