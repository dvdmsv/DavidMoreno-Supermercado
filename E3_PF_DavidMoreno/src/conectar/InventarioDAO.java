package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.InventarioDTO;

public class InventarioDAO {
	InventarioDTO invDTO = new InventarioDTO();
	
	public ArrayList<String> buscarProductoBD(String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		ArrayList<String> infoProd = new ArrayList<String>();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM inventario WHERE NOMBRE_PRODUCTO LIKE ?");
			preparedStatement.setString(1, "%" + nom + "%");
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				for(int i=1; i<=resultado.getMetaData().getColumnCount(); i++) {
					infoProd.add(resultado.getString(i));
				}
				
				
			}
			
		}catch(Exception e) {
			
		}
		return infoProd;
	}
}
