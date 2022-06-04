package conectar;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.VentasDTO;
import vista.paneladmin.VentanaPanelVentas;

public class VentasDAO {
	VentasDTO venDTO = new VentasDTO();
	
	public void anadirVentaBD(VentasDTO venta) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO ventas VALUES(NULL,?,?,?,?,?);");
			preparedStatement.setInt(1, venta.getCodProducto());
			preparedStatement.setString(2, venta.getNomProducto());
			preparedStatement.setInt(3, venta.getCantidVendida());
			preparedStatement.setString(4, venta.getFechaVenta());
			preparedStatement.setInt(5, venta.getNumEmpleado());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			System.out.println("Error al insertar venta: "+e);
		}finally {
			conn.desconectar();
		}
	}
	
	public void buscarVentaBD(String nom, VentanaPanelVentas vpv, int tipoBusqueda) {
		PreparedStatement preparedStatement = null;
		Conectar conn = new Conectar();
		
		try {
			if(tipoBusqueda == 1) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM ventas WHERE CODIGO_PRODUCTO LIKE ?;");
			}else if(tipoBusqueda == 2) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM ventas WHERE NUMERO_EMPLEADO LIKE ?;");
			}
			preparedStatement.setString(1, "%" + nom + "%");
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				for(int i=1; i<=resultado.getMetaData().getColumnCount(); i++) {
					vpv.getData()[0] = resultado.getString(1);
					vpv.getData()[1] = resultado.getString(2);
					vpv.getData()[2] = resultado.getString(3);
					vpv.getData()[3] = resultado.getString(4);
					vpv.getData()[4] = resultado.getString(5);
					vpv.getData()[5] = resultado.getString(6);			
				}
				vpv.getModelo().addRow(vpv.getData());
			}
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
}
