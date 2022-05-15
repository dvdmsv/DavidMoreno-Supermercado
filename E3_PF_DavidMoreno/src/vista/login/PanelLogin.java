package vista.login;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelLogin extends JPanel{
	private Usuario usuario;
	private Contrasena contrasena;
	private BotonLogin botLogin;
	private MensajeError mensajeErr;
	
	public PanelLogin() {
		this.setBorder(new TitledBorder("Iniciar sesion"));
		this.setBackground(Color.decode("#04FCFC"));
		usuario = new Usuario();
		contrasena = new Contrasena();
		mensajeErr = new MensajeError();
		botLogin = new BotonLogin(usuario, contrasena, mensajeErr);
		
		this.add(usuario);
		this.add(contrasena);
		this.add(botLogin);
		this.add(mensajeErr);
		this.setLayout(new GridLayout(4,1));
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Contrasena getContrasena() {
		return contrasena;
	}


	public void setContrasena(Contrasena contrasena) {
		this.contrasena = contrasena;
	}


	public BotonLogin getBotLogin() {
		return botLogin;
	}


	public void setBotLogin(BotonLogin botLogin) {
		this.botLogin = botLogin;
	}


	public MensajeError getMensajeErr() {
		return mensajeErr;
	}


	public void setMensajeErr(MensajeError mensajeErr) {
		this.mensajeErr = mensajeErr;
	}
	
	
}
