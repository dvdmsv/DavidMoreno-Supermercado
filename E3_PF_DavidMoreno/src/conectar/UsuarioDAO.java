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
				existe = true;
			}else {
				existe = false;
			}
			return existe;
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
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
			
		}finally {
			conn.desconectar();
		}
		return false;
	}
	
	public boolean loginBD(String nom, String contra) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		boolean correct = false;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE_USUARIO=? AND CONTRASENA=?;");
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, contra);
			ResultSet resultado = preparedStatement.executeQuery();
			if(resultado.isBeforeFirst()) {
				correct = true;
			}else {
				correct = false;
			}
			conn.desconectar();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
		return correct;
	}
	
	public boolean loginAdminBD(String nom, String contra) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		boolean correct = false;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE_USUARIO=? AND CONTRASENA=? AND USUARIO_ADMIN='T';");
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, contra);
			ResultSet resultado = preparedStatement.executeQuery();
			if(resultado.isBeforeFirst()) {
				correct = true;
			}else {
				correct = false;
			}
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
		return correct;
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
			
		}finally {
			conn.desconectar();
		}
	}
	
	public void eliminarUsuarioBD(String nomUsu) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("DELETE FROM usuarios WHERE NOMBRE_USUARIO = ?;");
			preparedStatement.setString(1, nomUsu);
			preparedStatement.executeUpdate();
			conn.desconectar();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}

	public UsuarioDTO getUsuDTO(String nom) {
		return usuDTO;
	}

	public void setUsuDTO(UsuarioDTO usuDTO) {
		this.usuDTO = usuDTO;
	}
}
