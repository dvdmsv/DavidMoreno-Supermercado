package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.UsuarioDTO;

public class UsuarioDAO {
	UsuarioDTO usuDTO = new UsuarioDTO();
	
	public boolean buscarUsuarioBD(String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		boolean existe = false;
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE_USUARIO=?;");
			preparedStatement.setString(1, nom);
			ResultSet resultado = preparedStatement.executeQuery();
			if(resultado.isBeforeFirst()) {
				while(resultado.next()) {
					for(int i=1; i<=resultado.getMetaData().getColumnCount(); i++) {
						System.out.print(resultado.getString(i) + " | ");
					}
					existe = true;
				}
			}else {
				System.out.print("El usuario no existe");
				existe = false;
			}
			conn.desconectar();
			return existe;
		}catch(Exception e) {
			
		}
		return false;
	}
	
	public boolean usuarioExisteBD(String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		boolean existe = false;
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE_USUARIO=?;");
			preparedStatement.setString(1, nom);
			ResultSet resultado = preparedStatement.executeQuery();
			if(resultado.isBeforeFirst()) {
				existe = true;
			}else {
				existe = false;
			}
			conn.desconectar();
			return existe;
		}catch(Exception e) {
			
		}
		return false;
	}
	
	public void crearUsuarioBD(UsuarioDTO usuDTO) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO USUARIOS VALUES(?,null,?,?);");
			preparedStatement.setString(1, usuDTO.getNomUsu());
			//preparedStatement.setInt(2, usuDTO.getNumEmpl());
			preparedStatement.setString(2, usuDTO.getContr());
			preparedStatement.setString(3, usuDTO.getUsuAdmin());
			preparedStatement.executeUpdate();
			conn.desconectar();
		}catch(Exception e) {
			
		}
	}

	public UsuarioDTO getUsuDTO(String nom) {
		return usuDTO;
	}

	public void setUsuDTO(UsuarioDTO usuDTO) {
		this.usuDTO = usuDTO;
	}
}
