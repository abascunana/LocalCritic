package Vista;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Consigue el t�tulo de la obra recogiendo el ID de la misma
@WebServlet("/ConseguirTitulo")
public class ConseguirTitulo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = "";
		resultado = SqlCritica.conseguirNombre(Integer.parseInt(request.getParameter("ID")));
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);	
	}
}
