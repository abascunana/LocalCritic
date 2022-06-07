package Vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlUsuarios extends Conexion {
	
	public boolean registrar(Usuario usr){
		//Inserta un usuario en la base de datos
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO usuarios (nombreUsuario,tipoUsuario,emailUsuario,contraseñaUsuario,karma,reviewNum,mediaValUsuario) VALUES(?,?,?,?,0,0,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setString(1,usr.getNombreUsuario());
			ps.setString(2,usr.getTipoUsuario());
			ps.setString(3,usr.getEmailUsuario());
			ps.setString(4,usr.getContrasenaUsuario());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
	//Logea a un usuario en la base de datos
	public boolean logearse(Usuario usr)throws ClassNotFoundException {
		boolean status = false;
		PreparedStatement ps = null;
		Connection pepe = getConexion();
		System.out.print(pepe);
		try {
			ps = pepe.prepareStatement("select * from usuarios where nombreUsuario = ? and contraseñaUsuario = ? ");
			ps.setString(1, usr.getNombreUsuario());
            ps.setString(2, usr.getContrasenaUsuario());

            ResultSet rs = ps.executeQuery();
            status= rs.next(); 
            System.out.println(ps);
            return status;
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} {
		
        
        
        return status;
    }
	}
//Selecciona el tipo de usuario con su usuario
public static String SelectTipoUsuario(String usuario ) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "Select tipoUsuario from usuarios where nombreUsuario = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,usuario);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
			return "fallo";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fallo";
		}
		
			
		} 
	
//Comprueba si existe el usuario
public int existeUsuario(String usuario ) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "Select count(usuarioID) from usuarios where nombreUsuario = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,usuario);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		
			
		}
}