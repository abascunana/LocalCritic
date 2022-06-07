package Vista;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Genera el perfil del usuario
@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = "";
		try {
			int id = SqlCritica.conseguirIdUsuario(request.getParameter("usuario"));
			int karma = SqlCritica.karma(id);
	    	SqlCritica.UpdateKarma(id, karma);
			resultado = BasesUsuario.selectUsuario(request.getParameter("usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);
	}

}
