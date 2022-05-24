package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerModificarNombre;

public class PanelBotonesModificarUsuario extends JPanel{
	private JButton btModNom, btModContra;
	
	public PanelBotonesModificarUsuario(PanelDatosModificarUsuario pdmu) {
		btModNom = new JButton("Modificar nombre");
		btModNom.addActionListener(new ListenerModificarNombre(pdmu));
		btModContra = new JButton("Modificar contraseña");
		
		this.add(btModNom);
		this.add(btModContra);
		this.setLayout(new GridLayout(1,2));
		this.setBorder(BorderFactory.createEmptyBorder(0,50,50,50));
	}
}
