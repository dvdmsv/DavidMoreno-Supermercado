package modelo;
/**
 * Clase que crea el objeto UsuarioDTO
 * @author David
 *
 */
public class UsuarioDTO {
	/**
	 * Nombre de usuario
	 */
	private String nomUsu;
	/**
	 * Numero de empleado
	 */
	private int numEmpl;
	/**
	 * Contraseña
	 */
	private String contr;
	/**
	 * Permisos de admin
	 */
	private String usuAdmin;
	/**
	 * Constructor de UsuarioDTO
	 * @param nomUsu Nombre de usuario
	 * @param numEmpl Numero de empleado
	 * @param contr Contraseña
	 * @param usuAdmin Permisos de admin
	 */
	public UsuarioDTO(String nomUsu, int numEmpl, String contr, String usuAdmin) {
		this.nomUsu=nomUsu;
		this.numEmpl=numEmpl;
		this.contr=contr;
		this.usuAdmin=usuAdmin;
	}
	/**
	 * Constructor vacio de UsuarioDTO
	 */
	public UsuarioDTO() {
		this.nomUsu="";
		this.numEmpl=0;
		this.contr="";
		this.usuAdmin="";
	}
	/**
	 * Devuelve el nombre de usuario
	 * @return nomUsu
	 */
	public String getNomUsu() {
		return nomUsu;
	}
	/**
	 * Devuelve el numero de usuario
	 * @return numEmpl
	 */
	public int getNumEmpl() {
		return numEmpl;
	}
	/**
	 * Devuelve la contraseña
	 * @return contr
	 */
	public String getContr() {
		return contr;
	}
	/**
	 * Devuelve si es admin
	 * @return usuAdmin
	 */
	public String getUsuAdmin() {
		return usuAdmin;
	}
}
