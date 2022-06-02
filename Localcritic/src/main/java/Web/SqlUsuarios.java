package Web;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlUsuarios extends Base{
	
	public boolean registrar(Usuario usr){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO usuarios (nombreUsuario,tipoUsuario,emailUsuario,contraseñaUsuario,karma,reviewNum,mediaValUsuario) VALUES(?,?,?,?,0,0,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setString(1,usr.getNombreUsuario());
			ps.setString(2,"Messi");
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
	public boolean logearse(Usuario usr)throws ClassNotFoundException {
		boolean status = false;
		PreparedStatement ps = null;
		Connection pepe = getConexion();
		System.out.print(pepe);
		try {
			ps = pepe.prepareStatement("select * from usuarios where nombreUsuario = ? and contraseñaUsuario = ? ");
			ps.setString(1, usr.getNombreUsuario());
            ps.setString(2, usr.getContrasenaUsuario());

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} {
		
        
        
        return status;
    }
	}
	

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
	
public boolean esEmail(String correo) {

    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+´)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    Matcher mather = pattern.matcher(correo);
    return mather.find();

	}
}