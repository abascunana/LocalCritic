package Vista;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registroCancion")
public class RegistroCancion extends HttpServlet {
	private SqlCancion cancionDao;
	
	public void init() {
		cancionDao = new SqlCancion();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
			
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String artista = request.getParameter("artista");
		int fecha = Integer.parseInt(request.getParameter("fecha"));
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		String productora = request.getParameter("productora");
		Cancion cancionBean = new Cancion();
		
		if(cancionDao.existeCancion(titulo) == 0) {
		
		
		cancionBean.setTituloCancion(titulo);
		cancionBean.setGeneroCancion(genero);
		cancionBean.setArtista(artista);
		cancionBean.setAnoLanzamientoCancion(fecha);
		cancionBean.setDuracionCancion(duracion);
		cancionBean.setProductoraCancion(productora);
		

        if (cancionDao.registrarCancion(cancionBean)) {
            //HttpSession session = request.getSession();
            // session.setAttribute("username",username);
            response.sendRedirect("loginsuccess.jsp");
            System.out.println("Bien");
        } else {
            HttpSession session = request.getSession();
            //session.setAttribute("user", username);
            //response.sendRedirect("login.jsp");
            System.out.println("Mal");
        	}
		}else {
			System.out.print("messi");
		}
	}
}
