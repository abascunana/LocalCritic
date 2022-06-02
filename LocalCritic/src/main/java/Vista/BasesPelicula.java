package Vista;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BasesPelicula extends Conexion {
	
public static String getSelectPelicula() throws SQLException, ClassNotFoundException {
	Statement st = null;
	ResultSet rs = null;
	Connection con = getConexion();
	
	String sql = "Select tituloPelicula from peliculas";
	
	try {
		st = con.createStatement();
		rs = st.executeQuery(sql);
		String resultado = "<form>"
				+ "<input type=\"search\" id=\"llistat\">"
				+"<button type=\"button\" onclick=\"cercar()\">Buscar obra</button>";
		//while(rs.next()) {
			//resultado = resultado + "<option value=\""+rs.getString("tituloPelicula")+"\">"+rs.getString("tituloPelicula")+"</option>";
		//}
		resultado = resultado + "</form>";
		rs.close();
		st.close();
		con.close();
		
		return resultado;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "messi";
	
	}
		
	}
	


public static  String selectPelicula(String pelicula ) {
	
	Statement ps = null;
	ResultSet rs = null;
	Connection con = getConexion();
	String resultado = "";
	
	
	String sql;
	if(pelicula.equals("")){
		sql = "Select * from peliculas";
		try {
			ps = con.createStatement();
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				resultado = resultado + "<div class=\"fichaTecnicaContainer\">"
						+ "<h1 class=\"fichaTecnicaTitle\">" +rs.getString("tituloPelicula") +"</h1>\r\n"
						+ "<h1 class=\"fichaTecnicaVal\">"+rs.getString("mediaValPelicula")+"</h1>\r\n"
						+ "\r\n"
						+ "<p class=\"fichaTecnicaText\">Sinopsis:"+rs.getString("sinopsisPelicula")+" </p>\r\n"
						+ "<p class=\"fichaTecnicaText\">Elenco:"+rs.getString("actor")+"</p>\r\n"
						+ "<p class=\"fichaTecnicaText\">Año de lanzamiento:"+rs.getInt("anoLanzamientoPelicula")+ "</p>\r\n"
						+ "\r\n"
						+ "<br>\r\n"
						+ "<p class=\"fichaTecnicaText\">Director:"+rs.getString("director")+ "</p>\r\n"
						+ "<p class=\"fichaTecnicaText\">Productora:"+rs.getString("productoraPelicula")+"</p>\r\n"
						+ "<p class=\"fichaTecnicaText\">Género:"+rs.getString("generoPelicula")+"</p>\r\n"
						+ "<p class=\"fichaTecnicaText\">Duración:" +rs.getInt("duracionPelicula")+"</p>\r\n"
						+ "</div>";
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "mi cara cuando";
		}

	}else {
		sql = "Select * from peliculas where tituloPelicula like '%"+pelicula+"%'";
	
	try {
		ps = con.createStatement();
		rs = ps.executeQuery(sql);
		while(rs.next()) {
		resultado = resultado + "<div class=\"fichaTecnicaContainer\">"+ 
				"<h1 class=\"fichaTecnicaTitle\">" + rs.getString("tituloPelicula") +"</h1>\r\n"
				+ "<h1 class=\"fichaTecnicaVal\">"+rs.getString("mediaValPelicula")+"</h1>\r\n"
				+ "\r\n"
				+ "<p class=\"fichaTecnicaText\">Sinopsis:"+rs.getString("sinopsisPelicula")+" </p>\r\n"
				+ "<p class=\"fichaTecnicaText\">Elenco:"+rs.getString("actor")+"</p>\r\n"
				+ "<p class=\"fichaTecnicaText\">Año de lanzamiento:"+rs.getString("anoLanzamientoPelicula")+ "</p>\r\n"
				+ "\r\n"
				+ "<br>\r\n"
				+ "<p class=\"fichaTecnicaText\">Director:"+rs.getString("director")+ "</p>\r\n"
				+ "<p class=\"fichaTecnicaText\">Productora:"+rs.getString("productoraPelicula")+"</p>\r\n"
				+ "<p class=\"fichaTecnicaText\">Género:"+rs.getString("generoPelicula")+"</p>\r\n"
				+ "<p class=\"fichaTecnicaText\">Duración:" +rs.getString("duracionPelicula")+"</p>\r\n"
				+ "</div>";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "mi cara cuando";
	}
	return resultado;
	
		}
	return resultado;
	}
@SuppressWarnings("unchecked")
public static String ListaObras() {


    Statement st = null;
    ResultSet rs = null;
    Connection con = getConexion();
    String titulo = "<h1>";
    String titulo2 = ""; 
    String sql = "Select tituloPelicula from peliculas";

     try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                titulo = titulo +rs.getString("tituloPelicula") + ",";
            }
            titulo = titulo + "</h1>";
            rs.close();
            st.close();
            con.close();
            System.out.println(titulo);
            return titulo;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return titulo;

            }
	}
}