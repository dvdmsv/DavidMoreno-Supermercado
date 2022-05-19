package supermercado;

import java.util.ArrayList;

import conectar.InventarioDAO;
import conectar.UsuarioDAO;
import conectar.VentasDAO;
import modelo.UsuarioDTO;
import vista.login.VentanaLogin;
import vista.panelusuario.VentanaPanelInventario;

public class Supermercado {
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private InventarioDAO invDAO = new InventarioDAO();
	private VentasDAO venDAO = new VentasDAO();
	
	public void login() {
		VentanaLogin vL = new VentanaLogin();
	}
	
	public boolean loginCorrecto(String nom, String contra) {
		if(usuDAO.loginBD(nom, contra)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean loginAdmin(String nom, String contra) {
		if(usuDAO.loginAdminBD(nom, contra)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void buscarUsuario(String nomUsu) {
		usuDAO.buscarUsuarioBD(nomUsu);
	}
	
	public void crearUsuario() {
		UsuarioDTO usuDTO = new UsuarioDTO("hola", 000, "admin", "F");
		usuDAO.crearUsuarioBD(usuDTO);
	}
	
	public void buscarProducto(String nom, VentanaPanelInventario vpi, int tipoBusqueda) {
		invDAO.buscarProductoBD(nom, vpi, tipoBusqueda);
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
