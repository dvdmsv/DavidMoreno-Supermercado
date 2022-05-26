package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.InventarioDTO;
import vista.panelusuario.VentanaPanelCesta;
import vista.panelusuario.VentanaPanelInventario;

public class InventarioDAO {
	InventarioDTO invDTO = new InventarioDTO();
	
	
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
	
	public int stockDisponibleBD(String cod) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		int stock = 0;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT CANTIDAD_PRODUCTO FROM inventario WHERE CODIGO_PRODUCTO = ?;");
			preparedStatement.setString(1, cod);
			ResultSet resultado = preparedStatement.executeQuery();
			//stock = resultado.getInt(1);
			while(resultado.next()) {
				stock = resultado.getInt(1);
			}
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
		return stock;
	}
	
	public void crearProductoBD(InventarioDTO prod) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO INVENTARIO VALUES(NULL,?,?,?,?,?);");
			preparedStatement.setString(1, prod.getNomProducto());
			preparedStatement.setString(2, prod.getFamProducto());
			preparedStatement.setInt(3, prod.getCantidProducto());
			preparedStatement.setFloat(4, prod.getPrecioProducto());
			preparedStatement.setFloat(5, prod.getIvaProducto());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}

	public void setInvDTO(InventarioDTO invDTO) {
		this.invDTO = invDTO;
	}
	
	
}
