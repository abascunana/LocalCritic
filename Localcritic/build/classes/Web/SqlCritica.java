package Web;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlCritica extends Base{
	
	public boolean registrarCritica(Critica cri){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO criticas (valCritica,textoCritica,obraID) VALUES(?,?,?)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setLong(1,cri.getValCritica());
			ps.setString(2,cri.getTextoCritica());
	//		ps.setLong(3,cri.getUpvote());
	//		ps.setLong(4,cri.getDownvote());
//	ps.setLong(3,cri.getUsuarioID());
	ps.setLong(3,cri.getObraID());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
	public int BuscarID(int obraID) throws SQLException {
	    PreparedStatement ps = null;
	    Connection pepe = getConexion();
	    ResultSet rs = null;
	    String sql = "Select obraID from obras where obraID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setLong(1,obraID);
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
	

}