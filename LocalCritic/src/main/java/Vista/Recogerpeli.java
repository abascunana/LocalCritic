package Vista;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/peli2")
public class Recogerpeli extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = "";
		resultado = BasesPelicula.selectPelicula(request.getParameter("titulo"));
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);
		
	}

}
