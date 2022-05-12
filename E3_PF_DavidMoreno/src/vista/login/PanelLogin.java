package vista.login;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelLogin extends JPanel{
	private Usuario usuario;
	private Contrasena contrasena;
	
	
	public PanelLogin() {
		this.setBorder(new TitledBorder("Login"));
		usuario = new Usuario();
		contrasena = new Contrasena();
		
		this.add(usuario);
		this.add(contrasena);
		this.setLayout(new GridLayout(1,2));
	}
}
