package Vista;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlCritica extends Conexion{
	
	public boolean registrarCritica(Critica cri){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO criticas (valCritica,textoCritica,upvotes,downvotes,usuarioID,obraID) VALUES(?,?,?,?,?,?)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setLong(1,cri.getValCritica());
			ps.setString(2,cri.getTextoCritica());
			ps.setLong(3,0);
			ps.setLong(4,0);
			ps.setLong(5,cri.getUsuarioID());
			ps.setLong(6,cri.getObraID());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
	public static int BuscarID(String obra) throws SQLException {
	    PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select obraID from obras where tituloObra = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setString(1,obra);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getInt(1);}
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return 1;
	    }
	    return 0;


	}
	public static String conseguirNombre(int id){
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "Select tituloObra from obras where obraID= ?";
	    Connection pepe = Conexion.getConexion();

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getString(1);}
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return "nada";
	    }
	    return "nada";


	}
	
	

}
