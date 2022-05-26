package vista.paneladmin;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.controlador.ListenerModificarContra;
import vista.controlador.ListenerModificarNombre;
import vista.controlador.ListenerModificarPermiso;

public class PanelBotonesModificarUsuario extends JPanel{
	private JButton btModNom, btModContra, btModAdmin;
	
	public PanelBotonesModificarUsuario(PanelDatosModificarUsuario pdmu) {
		btModNom = new JButton("Modificar nombre");
		btModNom.addActionListener(new ListenerModificarNombre(pdmu));
		
		btModContra = new JButton("Modificar contraseña");
		btModContra.addActionListener(new ListenerModificarContra(pdmu));
		
		btModAdmin = new JButton("Modificar permiso");
		btModAdmin.addActionListener(new ListenerModificarPermiso(pdmu));
		
		this.add(btModNom);
		this.add(btModContra);
		this.add(btModAdmin);
		this.setLayout(new GridLayout(1,3));
		this.setBorder(BorderFactory.createEmptyBorder(0,50,50,50));
	}
}
