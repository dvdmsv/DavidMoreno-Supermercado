package supermercado;

import conectar.UsuarioDAO;
import modelo.UsuarioDTO;

public class Supermercado {
	
	
	public void buscarUsuario() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.buscarUsuarioBD("admin");
	}
	
	public void crearUsuario() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		UsuarioDTO usuDTO = new UsuarioDTO("hola", 54, "admin", "F");
		usuDAO.crearUsuarioBD(usuDTO);
	}
}
