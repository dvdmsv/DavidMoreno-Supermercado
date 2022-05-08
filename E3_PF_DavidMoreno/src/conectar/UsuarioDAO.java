package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.UsuarioDTO;

public class UsuarioDAO {
	UsuarioDTO usuDTO = new UsuarioDTO();
	
	public void buscarUsuarioBD(String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE_USUARIO=?;");
			preparedStatement.setString(1, nom);
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				for(int i=1; i<=resultado.getMetaData().getColumnCount(); i++) {
					System.out.print(resultado.getString(i) + " | ");
				}
			}
			
			conn.desconectar();
			
		}catch(Exception e) {
			
		}
	}
	
	public void crearUsuarioBD(UsuarioDTO usuDTO) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO USUARIOS VALUES(?,?,?,?);");
			preparedStatement.setString(1, usuDTO.getNomUsu());
			preparedStatement.setInt(2, usuDTO.getNumEmpl());
			preparedStatement.setString(3, usuDTO.getContr());
			preparedStatement.setString(4, usuDTO.getUsuAdmin());
			preparedStatement.executeUpdate();
			conn.desconectar();
		}catch(Exception e) {
			
		}
	}
}
