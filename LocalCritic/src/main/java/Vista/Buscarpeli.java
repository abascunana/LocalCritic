package Vista;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Servlet que crea la barra de búsqueda
@WebServlet("/peli1")
public class Buscarpeli extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = "";
		try {
			resultado = BasesPelicula.getSelectPelicula();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Mi cara cuando");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);
		
	}

}
