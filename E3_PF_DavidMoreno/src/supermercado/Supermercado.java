package supermercado;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import conectar.InventarioDAO;
import conectar.UsuarioDAO;
import conectar.VentasDAO;
import modelo.InventarioDTO;
import modelo.UsuarioDTO;
import vista.login.VentanaLogin;
import vista.panelusuario.VentanaPanelCesta;
import vista.panelusuario.VentanaPanelInventario;

public class Supermercado {
	private UsuarioDAO usuDAO = new UsuarioDAO();
	private InventarioDAO invDAO = new InventarioDAO();
	private VentasDAO venDAO = new VentasDAO();
	
	public void login() {
		VentanaLogin vL = new VentanaLogin();
	}
	
	public String generarHash(String contra) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(contra.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public boolean loginCorrecto(String nom, String contra) { //Comprueba si el nombre de usuario y la contraseña es correcto
		if(usuDAO.loginBD(nom, contra)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean loginAdmin(String nom, String contra) { //Comprueba si el usuario es admin
		if(usuDAO.loginAdminBD(nom, contra)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean buscarUsuario(String nomUsu) {
		return usuDAO.buscarUsuarioBD(nomUsu);
	}
	
	public void crearUsuario(String nom, String pass, String admin) {
		UsuarioDTO usuDTO = new UsuarioDTO(nom, 0, pass, admin);
		usuDAO.crearUsuarioBD(usuDTO);
	}
	
	public void eliminarUsuario(String nom) {
		usuDAO.eliminarUsuarioBD(nom);
	}
	
	public void modificarNombre(String nom, String newNom) {
		usuDAO.modificarNombreBD(nom, newNom);
	}
	
	public void modificarPermiso(String nom, int opc) {
		usuDAO.modificarPermisoBD(nom, opc);
	}
	
	public void modificarContra(String nom, String newContra) {
		usuDAO.modificarContraBD(nom, newContra);
	}
	
	public void introProd(String nomProd, String famProd, int cantProd, float precProd, float IVA) {
		InventarioDTO prod = new InventarioDTO(5, nomProd, famProd, cantProd, precProd, IVA);
		invDAO.crearProductoBD(prod);
	}
	
	public void buscarProducto(String nom, VentanaPanelInventario vpi, int tipoBusqueda) {
		invDAO.buscarProductoBD(nom, vpi, tipoBusqueda);
	}
	
	public void buscarProductoPorCod(String cod, VentanaPanelCesta vpc) {
		invDAO.buscarProductoPorCodBD(cod, vpc);
	}
	
	public boolean productoExiste(String cod) {
		return invDAO.productoExisteBD(cod);
	}
	
	public int stockDisponible(String nom) {
		return invDAO.stockDisponibleBD(nom);
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
