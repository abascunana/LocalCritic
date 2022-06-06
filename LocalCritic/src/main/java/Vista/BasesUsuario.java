package Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasesUsuario extends Conexion{

	public static String selectUsuario(String usuario) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		String resultado = "";		
		String sql = "Select * from usuarios where nombreUsuario = ?";
		ps= con.prepareStatement(sql);
		ps.setString(1,usuario);
		
		rs = ps.executeQuery();
		if(rs.next()) {
			resultado = resultado +  "<div class=\"backgroundContainerPerfil\">"+
            "<div class=\"profileContainer\">"+
            "<div class=\"profilelUpperDiv\">"+
                "<div class=\"profileUsernameKarmaCritica\">"+
                    "<div class=\"profileUsername\">"+
                        "<h1 class=\"fichaTecnicaTitle\">"+rs.getString("nombreUsuario")+"</h1>"+
                    "</div>"+
                    "<div class=\"profileKarmaCritica\">"+
                        "<p class=\"profileKarmaNum\">"+rs.getInt("karma")+"</p>"+
                        "<p class=\"profileCriticaNum\">"+rs.getInt("reviewNum")+"</p>"+
                    "</div>"+
                    "<div class=\"profileUserTypeInfo\">"+
                        "<p class=\"profileUserType\">"+rs.getString("tipoUsuario")+"</p>"+
                    "</div>"+
                "</div>"+
                "<div class=\"grid\">"+
                    "<h1 class=\"profileMediaVal\">"+rs.getInt("mediaValUsuario")+"</h1>"+
                    "<p class=\"profileMediaValText\">Media de Valoraciones</p>"+
                "</div>"+
            "</div>"+
        "</div>"+
    "</div>" + BasesCritica.selectCriticaPerfil(rs.getInt("usuarioID"),rs.getString("nombreUsuario"));
			return resultado;
		}
		return resultado;
	}
}
