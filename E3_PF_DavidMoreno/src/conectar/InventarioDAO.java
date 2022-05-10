package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.InventarioDTO;

public class InventarioDAO {
	InventarioDTO invDTO = new InventarioDTO();
	
	public void buscarProductoBD(String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE NOMBRE_PRODUCTO LIKE ?");
			preparedStatement.setString(1, "%" + nom + "%");
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				for(int i=1; i<resultado.getMetaData().getColumnCount(); i++) {
					System.out.print(resultado.getString(i) + " | ");
				}
				System.out.println("");
			}
			
		}catch(Exception e) {
			
		}
	}
}
