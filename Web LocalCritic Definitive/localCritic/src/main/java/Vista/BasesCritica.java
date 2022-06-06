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

        String sql = "Select * from criticas where obraID ="+id;
        try {
            ps = con.createStatement();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                resultado = resultado + 
        		"<hr class=\"separador\">"+
            		
        		"<div class=\"criticaContent\">"+
	                "<h1 class=\"fichaTecnicaVal\">"+rs.getInt("valCritica")+"</h1>"+
	                "<p class=\"criticaPrensaName\">"+ SqlCritica.conseguirUsuario(rs.getInt("usuarioID"))+"</p>"+
	                "<p class=\"criticaText\">"+rs.getString("textocritica")+"</p>"+
	                "<br>"+
	                "<div class=\"UpDownContainer\">"+
		                "<div class=\"InnerUpDownContainer\">"+
			                "<p class=\"upvotes\">"+rs.getInt("upvotes")+"</p>"+
			                "<input class=\"botonUp\" type=\"button\" onclick=\"UpvoteRefresh("+ rs.getString("criticaID")+")\"></input> "+"<br>"+
			            "</div>"+
		                "<div class=\"InnerUpDownContainer\">"+
			                "<p class=\"downvotes\">"+ rs.getInt("downvotes")+"</p>"+
			                "<input class=\"botonDown\" type=\"button\" onclick=\"DownvoteRefresh("+ rs.getString("criticaID")+")\"></input> "+"<br>"+
			            "</div>"+
		            "</div>"+
	            "</div>";
            }

    }catch (SQLException e) {
        e.printStackTrace();
        return "mi cara cuando";
    }
        return resultado;
	
}
	public static String selectCriticaPerfil(int id,String nombre) throws SQLException {
        Statement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String resultado = "";

        String sql = "Select * from Criticas where usuarioID ="+id;
        try {
            ps = con.createStatement();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                resultado = resultado +
            "<div class=\"backgroundContainer\">"+
                "<div class=\"profileCriticas\">"+
	                "<div class=\"perfilTituloCriticasContainer\">"+
	                	"<h1 class=\"criticaTitleMedia\">Cr�ticas de "+nombre+"</h1>"+
	                "</div>"+
	                	
	                "<hr class=\"separador\">"+
	                
	                "<div class=\"criticaContent\">"+
		                "<h1 class=\"fichaTecnicaVal\">"+rs.getInt("valCritica")+"</h1>"+
		                "<p class=\"criticaPrensaName\">"+ SqlCritica.conseguirUsuario(rs.getInt("usuarioID"))+"</p>"+
		                "<p class=\"criticaText\">"+rs.getString("textocritica")+"</p>"+
		                "<br>"+
		                "<div class=\"UpDownContainer\">"+
			                "<div class=\"InnerUpDownContainer\">"+
				                "<p class=\"upvotes\">"+rs.getInt("upvotes")+"</p>"+
				                "<input class=\"botonUp\" type=\"button\" onclick=\"UpvoteRefresh("+ rs.getString("criticaID")+")\"></input> "+"<br>"+
				            "</div>"+
			                "<div class=\"InnerUpDownContainer\">"+
				                "<p class=\"downvotes\">"+ rs.getInt("downvotes")+"</p>"+
				                "<input class=\"botonDown\" type=\"button\" onclick=\"DownvoteRefresh("+ rs.getString("criticaID")+")\"></input> "+"<br>"+
				            "</div>"+
			            "</div>"+
		            "</div>"+
	            "</div>"+
            "</div>";
            }

    }catch (SQLException e) {
        e.printStackTrace();
        return "mi cara cuando";
    }
        return resultado;
	
}
}