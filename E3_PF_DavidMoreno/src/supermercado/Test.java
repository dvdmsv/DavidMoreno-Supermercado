package supermercado;

import conectar.UsuarioDAO;
import vista.Ventana;

public class Test {

	public static void main(String[] args) {
		Supermercado superm = new Supermercado();
		//superm.usuarioExiste("admddin");
		superm.login();
	}

}
