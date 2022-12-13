package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase que representa la conexión con la base de datos.
 * @author Leticia
 *
 */
public class DatabaseConnection {

	/**
	 * Variable de tipo Connection que representa la conexión
	 */
	Connection connection;
	/**
	 * Función que realiza la conexión con la base de datos
	 * @return
	 */
	public Connection getConnection () {
		String dbName = "bd_animales_razas";
		String userName = "root";
		String password = "Midna1993";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/" + dbName,
					userName,
					password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
