package conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.UsuarioDTO;
/**
 * Clase que contien todas las consultas a la base de datos Usuarios
 * @author David
 *
 */
public class UsuarioDAO {
	/**
	 * Objeto UsuarioDTO
	 */
	UsuarioDTO usuDTO = new UsuarioDTO();
	/**
	 * Metodo que comprueba si un usuario existe en la base de datos por su nombre
	 * @param nom nombre de usuario
	 * @return boolean si existe o no
	 */
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

	/**
	 * Metodo que comprueba si el nombre y la contraseña introducidas dan algun resultado
	 * @param nom nombre de usuario
	 * @param contra contraseña del usuario
	 * @return boolean si obtiene resultados la consulta
	 */
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
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
		return correct;
	}
	/**
	 * Metodo que comprueba si el usuario que se loguea tiene permisos de administrador
	 * @param nom nombre de usuario
	 * @param contra contraseña de usuario
	 * @return boolean si la consulta retorna resultados
	 */
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
	/**
	 * Metodo que crea un usuario e la base de datos
	 * @param usuDTO objeto UsuarioDTO
	 */
	public void crearUsuarioBD(UsuarioDTO usuDTO) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("INSERT INTO USUARIOS VALUES(?,null,?,?);");
			preparedStatement.setString(1, usuDTO.getNomUsu());
			preparedStatement.setString(2, usuDTO.getContr());
			preparedStatement.setString(3, usuDTO.getUsuAdmin());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que elimina un usuario de la base de datos
	 * @param nomUsu nombre de usuario
	 */
	public void eliminarUsuarioBD(String nomUsu) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("DELETE FROM usuarios WHERE NOMBRE_USUARIO = ?;");
			preparedStatement.setString(1, nomUsu);
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que modifica el nombre de usuario en la base de datos
	 * @param newNom nuevo nombre para el usuario
	 * @param nom antiguo nombre del usuario
	 */
	public void modificarNombreBD(String newNom, String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		
		try {
			preparedStatement = conn.getConnect().prepareStatement("UPDATE usuarios SET NOMBRE_USUARIO=? WHERE NOMBRE_USUARIO=?;");
			preparedStatement.setString(1, newNom);
			preparedStatement.setString(2, nom);
			preparedStatement.executeUpdate();
		}catch(Exception e){
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que modifica el permiso de administrador para un usuario
	 * @param nom nombre de usuario
	 * @param opc opcion elegida
	 */
	public void modificarPermisoBD(String nom, int opc) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		try {
			if(opc == 1) {
				preparedStatement = conn.getConnect().prepareStatement("UPDATE usuarios SET USUARIO_ADMIN='T' WHERE NOMBRE_USUARIO=?;");
				preparedStatement.setString(1, nom);
				preparedStatement.executeUpdate();
			}else if(opc == 2) {
				preparedStatement = conn.getConnect().prepareStatement("UPDATE usuarios SET USUARIO_ADMIN='F' WHERE NOMBRE_USUARIO=?;");
				preparedStatement.setString(1, nom);
				preparedStatement.executeUpdate();
			}
		}catch(Exception e){
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que modifica la contraseña de un usuario en la base de datos
	 * @param nomUsu nombre de usuario
	 * @param newContra nueva contraseña
	 */
	public void modificarContraBD(String nomUsu, String newContra) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		try {
			preparedStatement = conn.getConnect().prepareStatement("UPDATE usuarios SET CONTRASENA=? WHERE NOMBRE_USUARIO=?;");
			preparedStatement.setString(1, newContra);
			preparedStatement.setString(2, nomUsu);
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			conn.desconectar();
		}
	}
	/**
	 * Metodo que obtiene el codigo de un usuario en base a su nombre
	 * @param nom nombre del usuario
	 * @return codUsu codigo de usuario
	 */
	public int getCodUsuarioBD(String nom) {
		PreparedStatement preparedStatement;
		Conectar conn = new Conectar();
		int codUsu = 0;
		try {
			preparedStatement = conn.getConnect().prepareStatement("SELECT NUMERO_EMPLEADO FROM usuarios WHERE NOMBRE_USUARIO like ?;");
			preparedStatement.setString(1, nom);
			ResultSet resultado = preparedStatement.executeQuery();
			while(resultado.next()) {
				return codUsu = resultado.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("Error al buscar: " + e);
		}finally {
			conn.desconectar();
		}
		return codUsu;
	}
}
