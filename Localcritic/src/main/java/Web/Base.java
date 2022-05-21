package Web;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Web.Usuario;

public class Base {
	
    public boolean validate(Usuario usuario) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");
/**Cambiar credenciales y puertos**/
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/sys?allowPublicKeyRetrieval=true&useSSL=false", "root", "123");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usuarios where nombreUsuario = ? and contraseñaUsuario = ? ")) {
            preparedStatement.setString(1, usuario.getNombreDeUsuario());
            preparedStatement.setString(2, usuario.getContrasenaDeUsuario());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}