package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Clase que se encarga de realizar una conexión con la base de datos
 */
public class Conectar {
	/**
	 * Contiene los resultados de la consulta SQL
	 */
	public static ResultSet resultSet; //Contiene los resultados de una consulta SQL
	/**
	 * Conexion con la base de datos
	 */
	public static Connection connect;
	/**
	 * Declaracion SQL
	 */
	public static Statement statement;
	/**
	 * Driver para la conexion
	 */
	final private String driver = "com.mysql.cj.jdbc.Driver";
	/**
	 * Nombre de usuario de la base de datos
	 */
	final private String user = "root";
	/**
	 * Contraseña de la base de datos
	 */
	final private String password = "root";
	/**
	 * URL para conectarse conla base de datos
	 */
	 private static final String url = "jdbc:mysql://localhost:3306/supermercadogalileo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 /**
	  * Constructor de Conectar
	  */
	 public Conectar() {
		 try {
			 Class.forName(driver);
			 
			 connect = DriverManager.getConnection(url, user, password);
			 
			 statement = connect.createStatement();
			 
			 if(connect == null) {
				 System.out.println("Conexion no establecida");
			 }else {
				//System.out.println("Conexion establecida");
			 }
		 }catch(Exception e) {
			 System.out.println("Conexion no establecida");
		 }
	 }
	 /**
	  * Metodo que devuelve la conexión con la base de datos
	  * @return connect
	  */
	public Connection getConnect() {
		return connect;
	}
	/**
	 * Metodo que se encarga de desconectar la aplicacion de la base de datos
	 */
	public void desconectar(){
		connect = null;
        if (connect == null){
           // System.out.println("Conexion terminada");
        }
    }
}

