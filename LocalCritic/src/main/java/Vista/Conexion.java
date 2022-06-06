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
	private final static String base = "localCritic";
	private final static String user = "Main";
	private final static String password = "Localcritic1";
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
    public boolean validate(Usuario usuario) throws ClassNotFoundException, SQLException {
        boolean status = false;

        PreparedStatement ps = null;
    	ResultSet rs = null;
    	Connection con = getConexion();
    	String sql = "select * from usuarios where nombreUsuario = ? and contraseñaUsuario = ? ";

            // Step 2:Create a statement using connection object
            ps = con.prepareStatement(sql); 
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContrasenaUsuario());

            System.out.println(ps);
             rs = ps.executeQuery();
            status = rs.next();

        
        return status;
    }
}