package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conectar {
	public static ResultSet resultSet; //Contiene los resultados de una consulta SQL
	public static Connection connect;
	public static Statement statement;
	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String user = "root";
	final private String password = "root";
	 private static final String url = "jdbc:mysql://localhost:3306/supermercadogalileo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 
	 public Conectar() {
		 try {
			 Class.forName(driver);
			 
			 connect = DriverManager.getConnection(url, user, password);
			 
			 statement = connect.createStatement();
			 
			 if(connect == null) {
				 System.out.println("Conexion no establecida");
			 }else {
				// System.out.println("Conexion establecida");
			 }
		 }catch(Exception e) {
			 System.out.println("Conexion no establecida");
		 }
	 }

	public static ResultSet getResultSet() {
		return resultSet;
	}

	public static void setResultSet(ResultSet resultSet) {
		Conectar.resultSet = resultSet;
	}

	public Connection getConnect() {
		return connect;
	}

	public static void setConnect(Connection connect) {
		Conectar.connect = connect;
	}

	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		Conectar.statement = statement;
	}

	public String getDriver() {
		return driver;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public static String getUrl() {
		return url;
	}
	
	public void desconectar(){
		connect = null;
        if (connect == null){
           // System.out.println("Conexion terminada");
        }
    }
}

