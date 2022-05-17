package vista.login;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaLogin extends JFrame {
	private PanelLogin pl = new PanelLogin(this);
	FondoImagen fondo = new FondoImagen();
	
	public VentanaLogin() {
		super("Galimerca");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.decode("#04FCFC"));
		this.setContentPane(fondo);
		this.setPreferredSize(new Dimension(500,300));
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	public void login() {
		this.add(pl);
	}
	
	public void cerrarVentana() {
		this.dispose();
	}

	public PanelLogin getPl() {
		return pl;
	}

	public void setPl(PanelLogin pl) {
		this.pl = pl;
	}
}
