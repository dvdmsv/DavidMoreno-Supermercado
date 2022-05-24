package vista.paneladmin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controlador.ListenerEliminarUsuario;

public class VentanaPanelEliminarUsuario extends JFrame{
	private JLabel lblNombreUsu, lblInfo;
	private JTextField jtfNombreUsu;
	private JButton eliminar;
	
	public VentanaPanelEliminarUsuario() {
		JPanel panel = new JPanel();
		lblNombreUsu = new JLabel("Nombre de usuario");
		lblInfo = new JLabel();
		jtfNombreUsu = new JTextField();
		eliminar = new JButton("Eliminar");
		
		
		panel.add(lblNombreUsu);
		panel.add(jtfNombreUsu);
		panel.add(eliminar);
		panel.add(lblInfo);
		
		eliminar.addActionListener(new ListenerEliminarUsuario(this));
		
		panel.setLayout((new GridLayout(4, 2)));
		panel.setBorder(BorderFactory.createEmptyBorder(50,100,100,100));
		this.getContentPane().add(panel);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(new Dimension(600, 400));
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}

	public JTextField getJtfNombreUsu() {
		return jtfNombreUsu;
	}
}
