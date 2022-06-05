package supermercado;

import java.math.BigInteger;
import java.security.MessageDigest;

import conectar.InventarioDAO;
import conectar.UsuarioDAO;
import conectar.VentasDAO;
import modelo.InventarioDTO;
import modelo.UsuarioDTO;
import modelo.VentasDTO;
import vista.login.VentanaLogin;
import vista.paneladmin.VentanaPanelVentas;
import vista.panelusuario.VentanaPanelCesta;
import vista.panelusuario.VentanaPanelInventario;
/**
 * Clase que contiene todos los metodos de la aplicacion
 * @author David
 *
 */
public class Supermercado {
	/**
	 * usuDAO que contiene metodos directos con la base de datos
	 */
	private UsuarioDAO usuDAO = new UsuarioDAO();
	/**
	 * invDAO que contiene metodos directos con la base de datos
	 */
	private InventarioDAO invDAO = new InventarioDAO();
	/**
	 * venDAO que contiene metodos directos con la base de datos
	 */
	private VentasDAO venDAO = new VentasDAO();
	/**
	 * IVA
	 */
	private double IVA4=1.04f;
	/**
	 * IVA
	 */
	private double IVA10=1.10f;
	/**
	 * IVA
	 */
	private double IVA21=1.21f;
	
	/**
	 * Metodo que despliega la ventana de login
	 */
	public void login() {
		VentanaLogin vL = new VentanaLogin();
	}
	/**
	 * Metodo que genera un hash MD5
	 * @param contra contraseña a encriptar
	 * @return hashtext contraseña encriptada
	 */
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
	/**
	 * Metodo que comprueba si un usuario se puede loguear
	 * @param nom nombre de usuario
	 * @param contra contraseña del usuario
	 * @return boolean indicando si el login es correcto o fallido
	 */
	public boolean loginCorrecto(String nom, String contra) { //Comprueba si el nombre de usuario y la contraseña es correcto
		if(usuDAO.loginBD(nom, contra)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Metodo que comprueba si un usuario es admin
	 * @param nom nombre de usuario
	 * @param contra contraseña del usuari
	 * @return indicando si el login es correcto o fallido
	 */
	public boolean loginAdmin(String nom, String contra) { //Comprueba si el usuario es admin
		if(usuDAO.loginAdminBD(nom, contra)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Metodo que busca un usuario
	 * @param nomUsu de usuario
	 * @return boolean indicando su lo ha encontrado
	 */
	public boolean buscarUsuario(String nomUsu) {
		return usuDAO.buscarUsuarioBD(nomUsu);
	}
	/**
	 * Metodo que crea un usuario
	 * @param nom nombre de usuario
	 * @param pass contraseña
	 * @param admin si tiene permisos admin
	 */
	public void crearUsuario(String nom, String pass, String admin) {
		UsuarioDTO usuDTO = new UsuarioDTO(nom, 0, pass, admin);
		usuDAO.crearUsuarioBD(usuDTO);
	}
	/**
	 * Metodo que elimina un usuario
	 * @param nom nombre de usuario
	 */
	public void eliminarUsuario(String nom) {
		usuDAO.eliminarUsuarioBD(nom);
	}
	/**
	 * Metodo que modifica el nombre de un usuario
	 * @param nom nombre de usuario
	 * @param newNom nuevo nombre de usuario
	 */
	public void modificarNombre(String nom, String newNom) {
		usuDAO.modificarNombreBD(nom, newNom);
	}
	/**
	 * Metodo que modifica el permiso de admin
	 * @param nom nombre de usuario
	 * @param opc opc de permiso admin
	 */
	public void modificarPermiso(String nom, int opc) {
		usuDAO.modificarPermisoBD(nom, opc);
	}
	/**
	 * Metodo que modifica la contraseña de un usuario
	 * @param nom nombre de usuario
	 * @param newContra nueva contraseña
	 */
	public void modificarContra(String nom, String newContra) {
		usuDAO.modificarContraBD(nom, newContra);
	}
	/**
	 * Metod que introduce un producto en la base de datos
	 * @param nomProd nombre del producto
	 * @param famProd familia del producto
	 * @param cantProd cantidad del producto
	 * @param precProd precio del producto
	 * @param IVA IVA del producto
	 */
	public void introProd(String nomProd, String famProd, int cantProd, double precProd, double IVA) {
		InventarioDTO prod = new InventarioDTO(5, nomProd, famProd, cantProd, precProd, IVA);
		invDAO.crearProductoBD(prod);
	}
	/**
	 * Metodo que busca un producto
	 * @param nom nombre del producto
	 * @param vpi panel del inventario
	 * @param tipoBusqueda tipo de busqueda a realizar
	 */
	public void buscarProducto(String nom, VentanaPanelInventario vpi, int tipoBusqueda) {
		invDAO.buscarProductoBD(nom, vpi, tipoBusqueda);
	}
	/**
	 * Metodo que busca un producto por el codigo
	 * @param cod codigo del producto
	 * @param vpc panel de la cesta
	 */
	public void buscarProductoPorCod(String cod, VentanaPanelCesta vpc) {
		invDAO.buscarProductoPorCodBD(cod, vpc);
	}
	/**
	 * Metodo que comprueba si un producto existe en la base de datos
	 * @param cod del producto
	 * @return boolean si existe o no
	 */
	public boolean productoExiste(String cod) {
		return invDAO.productoExisteBD(cod);
	}
	/**
	 * Metod que comprueba si un producto existe por el nombre
	 * @param nom del producto
	 * @return boolean si existe o no
	 */
	public boolean productoExistePorNom(String nom) {
		return invDAO.productoExistePorNomBD(nom);
	}
	/**
	 * Metodo que elimina un producto de la base de datos
	 * @param cod codigo del producto
	 */
	public void eliminarProducto(String cod) {
		invDAO.eliminarProductoBD(cod);
	}
	/**
	 * Metodo que devuelve la cantidad de stock disponible de un producto en la base de datos
	 * @param nom nombre del producto
	 * @return catidad de stock disponible
	 */
	public int stockDisponible(String nom) {
		return invDAO.stockDisponibleBD(nom);
	}
	/**
	 * Metodo que descuenta stock de un producto en la base de datos
	 * @param cantid canidad de producto a descontar
	 * @param cod codigo del producto
	 */
	public void descontarStock(int cantid, String cod) {
		int stockFinal = invDAO.stockDisponibleBD(cod) - cantid;
		invDAO.cambiarStockBD(stockFinal, cod);
		
	}
	/**
	 * Metodo que devuelve el codigo de un producto
	 * @param nomProd nombre del producto
	 * @return codigo del producto
	 */
	public int getCodProd(String nomProd) {
		return invDAO.getCodProdBD(nomProd);
	}
	/**
	 * Metodo que añade una venta a la tabla ventas
	 * @param codProducto codigo de producto
	 * @param nomProducto nombre de producto
	 * @param cantidVendida cantidad vendida
	 * @param fechaVenta fecha de venta
	 * @param numEmpleado numero del empleado
	 */
	public void anadirVenta(int codProducto, String nomProducto, int cantidVendida, String fechaVenta, int numEmpleado) {
		VentasDTO venDTO = new VentasDTO(5050, codProducto, nomProducto, cantidVendida, fechaVenta, numEmpleado);
		venDAO.anadirVentaBD(venDTO);
	}
	/**
	 * Metodo que busca una venta en la tabla
	 * @param nom nombre del dato a buscar
	 * @param vpv panel ventas
	 * @param tipoBusqueda tipo de busqueda
	 */
	public void buscarVenta(String nom, VentanaPanelVentas vpv, int tipoBusqueda) {
		venDAO.buscarVentaBD(nom, vpv, tipoBusqueda);
	}
	/**
	 * Metodo que devuelve el codigo de un usuario
	 * @param nomUsu nombre de usuario
	 * @return codigo de usuario
	 */
	public int getCodUsu(String nomUsu) {
		return usuDAO.getCodUsuarioBD(nomUsu);
	}
	/**
	 * Metodo que devuelve el IVA
	 * @return IVA
	 */
	public double getIVA4() {
		return IVA4;
	}
	/**
	 * Metodo que devuelve el IVA
	 * @return IVA
	 */
	public double getIVA10() {
		return IVA10;
	}
	/**
	 * Metodo que devuelve el IVA
	 * @return IVA
	 */
	public double getIVA21() {
		return IVA21;
	}
	/**
	 * Metodo que comprueba si un numero es entero
	 * @param cadena cadena a comprobar
	 * @return boolean si es un numero entero no no
	 */
	public boolean isInt(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		}catch(NumberFormatException nfe) {
			return false;
		}
	}
	/**
	 * Metodo que comprueba si un numero es float o no
	 * @param cadena cadena a comprobar
	 * @return boolean si es un numero entero no no
	 */
	public boolean isFloat(String cadena) {
		try {
			Float.parseFloat(cadena);
			return true;
		}catch(NumberFormatException nfe) {
			return false;
		}
	}
}
