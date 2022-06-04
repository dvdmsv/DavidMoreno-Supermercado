package conectar;

import java.sql.PreparedStatement;

import modelo.InventarioDTO;
import modelo.UsuarioDTO;
import modelo.VentasDTO;

public class VentasDAO {
	VentasDTO venDTO = new VentasDTO();
	
	public void anadirVentaBD(VentasDTO venta) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO ventas VALUES(null,?,?,?,?,?);");
			preparedStatement.setString(1, venta.getCodProducto());
			preparedStatement.setString(2, venta.getNomProducto());
			preparedStatement.setString(3, venta.getCantidVendida());
			preparedStatement.setString(4, venta.getFechaVenta());
			preparedStatement.setString(5, venta.getNumEmpleado());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
}
