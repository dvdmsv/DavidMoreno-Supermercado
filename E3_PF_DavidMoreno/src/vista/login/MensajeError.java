package vista.login;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MensajeError extends JPanel {
	private JLabel lb;
	
	public MensajeError() {
		lb = new JLabel();
		
		this.add(lb);
		this.setBackground(Color.decode("#04FCFC"));
	}

	public JLabel getLb() {
		return lb;
	}

	public void setLb(JLabel lb) {
		this.lb = lb;
	}
}