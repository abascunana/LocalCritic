package Web;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecogerCritica
 */
@WebServlet("/RecogerCritica")
public class RecogerCritica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = "";
		
		try {
			resultado = BasesCritica.selectCritica("Peli de verdad");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultado);
	}

}
