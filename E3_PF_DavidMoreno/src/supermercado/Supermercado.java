package supermercado;

import conectar.InventarioDAO;
import conectar.UsuarioDAO;
import modelo.UsuarioDTO;

public class Supermercado {
	
	
	public void buscarUsuario() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.buscarUsuarioBD("admin");
	}
	
	public void crearUsuario() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		UsuarioDTO usuDTO = new UsuarioDTO("hola", 000, "admin", "F");
		usuDAO.crearUsuarioBD(usuDTO);
	}
	
	public void buscarProducto() {
		InventarioDAO invDAO = new InventarioDAO();
		invDAO.buscarProductoBD("Banana");
		
	}
}
