package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.InventarioDTO;
import vista.panelusuario.VentanaPanelCesta;
import vista.panelusuario.VentanaPanelInventario;
/**
 * Clase que contiene lasconsultas de la base de datos de Inventario
 * @author David
 *
 */
public class InventarioDAO {
	/**
	 * Objeto InventarioDTO
	 */
	InventarioDTO invDTO = new InventarioDTO();
	
	/**
	 * Metodo encargado de buscar un producto en la base de datos
	 * @param nom nombre del campo a buscar
	 * @param vpi panel de inventario
	 * @param tipoBusqueda tipo de busqueda a realizar
	 */
	public void buscarProductoBD(String nom, VentanaPanelInventario vpi, int tipoBusqueda) { //Recibe un nombre, el JFrame de VentanaPanelInventario y un int indicando el tipo de busqueda a realizar
		PreparedStatement preparedStatement = null;
		Conectar conn = new Conectar();
		
		try {
			if(tipoBusqueda == 1) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE NOMBRE_PRODUCTO LIKE ?;");
			}else if(tipoBusqueda == 2) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE CODIGO_PRODUCTO LIKE ?;");
			}else if(tipoBusqueda == 3) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE FAMILIA_PRODUCTO LIKE ?;");
			}
			preparedStatement.setString(1, "%" + nom + "%");
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				for(int i=1; i<=resultado.getMetaData().getColumnCount(); i++) {
						vpi.getData()[0] = resultado.getString(1);
						vpi.getData()[1] = resultado.getString(2);
						vpi.getData()[2] = resultado.getString(3);
						vpi.getData()[3] = resultado.getString(4);
						vpi.getData()[4] = resultado.getString(5);
						vpi.getData()[5] = resultado.getString(6);			
				}
				vpi.getModelo().addRow(vpi.getData());
			}
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que obtiene el codigo de un producto por su nombre
	 * @param nom nombre del producto
	 * @return cod codigo del producto
	 */
	public int getCodProdBD(String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		int cod = 0;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT CODIGO_PRODUCTO from inventario WHERE NOMBRE_PRODUCTO=?;");
			preparedStatement.setString(1, nom);
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				cod = resultado.getInt(1);
			}
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
		return cod;
	}
	/**
	 * Metodo que bucsca un producto por su codigo
	 * @param cod codigo del producto
	 * @param vpc panel de la cesta
	 */
	public void buscarProductoPorCodBD(String cod, VentanaPanelCesta vpc) { //Recibe un codigo, el JFrame de VentanaPanelCesta
		PreparedStatement preparedStatement = null;
		Conectar conn = new Conectar();
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE CODIGO_PRODUCTO LIKE ?;");
			preparedStatement.setString(1,cod);
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				for(int i=1; i<=resultado.getMetaData().getColumnCount(); i++) { //Da tantas vueltas como columnas 
					//Se van obteniendo los datos y almacenando en el array de VentanaPanelCesta
					vpc.getData()[0] = resultado.getString(2); //Nombre
					vpc.getData()[2] = resultado.getString(5); //Precio
					vpc.getData()[3] = resultado.getString(6); //IVA
				}
			}
		}catch(Exception e) {
			System.out.print("Codigo erroneo");
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que comprueba si un producto existe en la base de datos por su codigo
	 * @param cod codigo del producto
	 * @return boolean si existe o no
	 */
	public boolean productoExisteBD(String cod) {
		PreparedStatement preparedStatement = null;
		Conectar conn = new Conectar();
		boolean existe = false;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE CODIGO_PRODUCTO LIKE ?;");
			preparedStatement.setString(1,cod);
			ResultSet resultado = preparedStatement.executeQuery();
			if(resultado.isBeforeFirst()) {
				existe = true;
			}
		}catch(Exception e) {
			
			
		}finally {
			conn.desconectar();
		}
		return existe;
	}
	/**
	 * Metodo que comprueba si un producto existe en la base de datos por su nombre
	 * @param nomProd nombre del producto
	 * @return boolean si existe o no
	 */
	public boolean productoExistePorNomBD(String nomProd) {
		PreparedStatement preparedStatement = null;
		Conectar conn = new Conectar();
		boolean existe = false;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE NOMBRE_PRODUCTO = ?;");
			preparedStatement.setString(1, nomProd);
			ResultSet resultado = preparedStatement.executeQuery();
			if(resultado.isBeforeFirst()) {
				existe = true;
			}
		}catch(Exception e) {
			
			
		}finally {
			conn.desconectar();
		}
		return existe;
	}
	/**
	 * Metodo que devuelve el stock disponible de un producto en la base de datos seg�n su codigo
	 * @param cod codigo del producto
	 * @return stock cantidad disponible del producto
	 */
	public int stockDisponibleBD(String cod) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		int stock = 0;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT CANTIDAD_PRODUCTO FROM inventario WHERE CODIGO_PRODUCTO =?;");
			preparedStatement.setString(1, cod);
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				stock = resultado.getInt(1);
			}
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
		return stock;
	}
	/**
	 * Metodo que crea un producto en la base de datos
	 * @param prod objeto InventarioDTO
	 */
	public void crearProductoBD(InventarioDTO prod) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO INVENTARIO VALUES(NULL,?,?,?,?,?);");
			preparedStatement.setString(1, prod.getNomProducto());
			preparedStatement.setString(2, prod.getFamProducto());
			preparedStatement.setInt(3, prod.getCantidProducto());
			preparedStatement.setDouble(4, prod.getPrecioProducto());
			preparedStatement.setDouble(5, prod.getIvaProducto());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que elimina un producto de la base de datos segun su codigo
	 * @param cod codigo del producto
	 */
	public void eliminarProductoBD(String cod) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		try {
			preparedStatement = conn.getConnect().prepareStatement("DELETE FROM inventario WHERE CODIGO_PRODUCTO=?;");
			preparedStatement.setString(1, cod);
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que cambia el stock de un producto en la base de datos
	 * @param cantid cantidad de stock a fijar
	 * @param cod codigo del producto
	 */
	public void cambiarStockBD(int cantid, String cod) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		try {
			preparedStatement = conn.getConnect().prepareStatement("UPDATE inventario SET CANTIDAD_PRODUCTO=? WHERE CODIGO_PRODUCTO=?;");
			preparedStatement.setInt(1, cantid);
			preparedStatement.setString(2, cod);
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
}
