package Vista;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registroVideojuego")
public class RegistroVideojuego extends HttpServlet {
	private SqlVideojuego videojuegoDao;
	
	public void init() {
		videojuegoDao = new SqlVideojuego();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
			
		String titulo = request.getParameter("vname");
		String descripcion = request.getParameter("descripcion");
		String genero = request.getParameter("genero");
		String desarrolladora = request.getParameter("desarrolladora");
		String distribuidora  = request.getParameter("distribuidora");
		int fecha = Integer.parseInt(request.getParameter("fecha"));
		String plataforma = request.getParameter("plataforma");
		Videojuego videojuegoBean = new Videojuego();
		
		if(videojuegoDao.existeVidejuego(titulo) == 0) {
		
		
		videojuegoBean.setTituloJuego(titulo);
		videojuegoBean.setDescripcionJuego(descripcion);
		videojuegoBean.setGeneroJuego(genero);
		videojuegoBean.setDesarrolladoraJuego(desarrolladora);
		videojuegoBean.setDistribuidoraJuego(distribuidora);
		videojuegoBean.setAnoLanzamientoJuego(fecha);
		videojuegoBean.setPlataformaJuego(plataforma);
		

        if (videojuegoDao.registrarVideojuego(videojuegoBean)) {
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