package Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BasesCritica extends Conexion{
	
	public static String selectCritica(String obra) throws SQLException {
		Statement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		int id = SqlCritica.BuscarID(obra);
		String resultado = "";
		
		String sql = "Select * from Criticas where obraID ="+id;
		try {
			ps = con.createStatement();
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				resultado = resultado + "<div class=\"fichaTecnicaContainer\">"+ 
						"<h1 class=0\"fichaTecnicaTitle\" name =\"titulo\">" + SqlCritica.conseguirNombre(rs.getInt("obraID")) +"</h1>\r\n"
						+ "<h1 class=\"fichaTecnicaVal\">"+rs.getString("textoCritica")+"</h1>\r\n"
						+ "\r\n"
						+ "<p class=\"fichaTecnicaText\">Nota:"+rs.getInt("valCritica")+" </p>\r\n"
						+ "<p class=\"fichaTecnicaText\">Upvotes:"+rs.getInt("upvotes")+"</p>\r\n"
						+ "<p class=\"fichaTecnicaText\">Downvotes:"+rs.getInt("downvotes")+ "</p>\r\n"
						+ "\r\n"
						+ "<br>\r\n"
						+ "<p class=\"fichaTecnicaText\">Director:"+obra+ "</p>\r\n"
						+ "</div>";
				System.out.print(resultado);
			}
			
	}catch (SQLException e) {
		e.printStackTrace();
		return "mi cara cuando";
	}
		return resultado;
			
		}
}
