package supermercado;

import conectar.InventarioDAO;
import conectar.UsuarioDAO;
import conectar.VentasDAO;
import modelo.UsuarioDTO;
import vista.login.VentanaLogin;

public class Supermercado {
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private InventarioDAO invDAO = new InventarioDAO();
	private VentasDAO venDAO = new VentasDAO();
	
	public void run() {
		this.login();
	}
	
	public void login() {
		VentanaLogin vL = new VentanaLogin();
		vL.login();
		
	}
	
	public void buscarUsuario(String nomUsu) {
		usuDAO.buscarUsuarioBD(nomUsu);
	}
	
	public void crearUsuario() {
		UsuarioDTO usuDTO = new UsuarioDTO("hola", 000, "admin", "F");
		usuDAO.crearUsuarioBD(usuDTO);
	}
	
	public void buscarProducto() {
		invDAO.buscarProductoBD("1");
	}
	
	public void anadirVenta() {
		venDAO.anadirVentaBD(5, "pollo", "carnes", 5, "2022-05-10", 1000);
	}
	
	public boolean usuarioExiste(String nomUsu) {
		if(usuDAO.usuarioExisteBD(nomUsu)) {
			return true;
		}else {
			return false;
		}
	}
}
