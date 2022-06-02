package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Vista.Usuario;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//he añadido lo de allowPublicKeyRetrieval porque en mi caso me daba error sin, si molesta se quita
	private final static String base = "LocalCritic?allowPublicKeyRetrieval=true&useSSL=false";
	private final static String user = "root";
	private final static String password = "1234";
	private final static String url = "jdbc:mysql://localhost:3306/" + base;
	private static Connection con = null;
	
	public static Connection getConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

	//Método para asegurarse de la existencia de un usuario por nombre y contraseña
    public boolean validate(Usuario usuario) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");
/**Cambiar credenciales y puertos**/
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LocalCritic?allowPublicKeyRetrieval=true&useSSL=false", "root", "1234");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usuarios where nombreUsuario = ? and contraseñaUsuario = ? ")) {
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getContrasenaUsuario());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
           
        }
        return status;
    }
}
