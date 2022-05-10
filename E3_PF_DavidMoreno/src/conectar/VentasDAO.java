package conectar;

import java.sql.PreparedStatement;

import modelo.InventarioDTO;
import modelo.UsuarioDTO;
import modelo.VentasDTO;

public class VentasDAO {
	VentasDTO venDTO = new VentasDTO();
	
	public void anadirVentaBD(int codProducto, String nomProducto, String famProducto, int cantidVendida, String fechaVenta, int numEmpleado) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO ventas VALUES(null, ?, ?, ?, ?, ?, ?);");
			preparedStatement.setInt(2, codProducto);
			preparedStatement.setString(3, nomProducto);
			preparedStatement.setString(4, famProducto);
			preparedStatement.setInt(5,cantidVendida);
			preparedStatement.setString(6, fechaVenta);
			preparedStatement.setInt(7, numEmpleado);
			preparedStatement.executeUpdate();
			conn.desconectar();
		}catch(Exception e) {
			
		}
	}
}
