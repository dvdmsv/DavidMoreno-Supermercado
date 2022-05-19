package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.InventarioDTO;
import vista.panelusuario.VentanaPanelInventario;

public class InventarioDAO {
	InventarioDTO invDTO = new InventarioDTO();
	
	
	public void buscarProductoBD(String nom, VentanaPanelInventario vpi, int tipoBusqueda) { //Recibe un nombre, el JFrame de VentanaPanelInventario y un int indicando el tipo de busqueda a realizar
		PreparedStatement preparedStatement = null;
		Conectar conn = new Conectar();
		
		try {
			if(tipoBusqueda == 1) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE NOMBRE_PRODUCTO LIKE ?");
			}else if(tipoBusqueda == 2) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE CODIGO_PRODUCTO LIKE ?");
			}else if(tipoBusqueda == 3) {
				preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE FAMILIA_PRODUCTO LIKE ?");
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
			
		}
	}
}
