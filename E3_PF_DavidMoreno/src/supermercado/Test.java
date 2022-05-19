package supermercado;

import conectar.UsuarioDAO;
import vista.login.VentanaLogin;
import vista.panelusuario.VentanaPanelUsuario;

public class Test {

	public static void main(String[] args) {
		Supermercado superm = new Supermercado();
		superm.login();
		//VentanaPanelUsuario vp = new VentanaPanelUsuario();
		//superm.buscarProducto();
	}

}
