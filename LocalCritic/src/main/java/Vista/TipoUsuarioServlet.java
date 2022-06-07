package Vista;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Envía el tipo de usuario
@WebServlet("/TipoUsuarioServlet")
public class TipoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = "";
		resultado = SqlUsuarios.SelectTipoUsuario(request.getParameter("nombre"));
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);;
	}

	

}
