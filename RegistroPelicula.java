package Vista;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registroPelicula")
public class  RegistroPelicula extends HttpServlet {
	private SqlPelicula peliculaDao;
	
	public void init() {
		peliculaDao = new SqlPelicula();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
			
		String titulo = request.getParameter("titulo");
		String sinopsis = request.getParameter("sinopsis");
		String genero = request.getParameter("genero");
		String actor = request.getParameter("actor");
		int fecha = Integer.parseInt(request.getParameter("fecha"));
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		String director = request.getParameter("director");
		String productora = request.getParameter("productora");
		Pelicula peliculaBean = new Pelicula();
		
		if(peliculaDao.existePelicula(titulo) == 0) {
		
		
		peliculaBean.setTituloPelicula(titulo);
		peliculaBean.setSinopsisPelicula(sinopsis);
		peliculaBean.setGeneroPelicula(genero);
		peliculaBean.setActor(actor);
		peliculaBean.setAnoLanzamientoPelicula(fecha);
		peliculaBean.setDuracionPelicula(duracion);
		peliculaBean.setDirector(director);
		peliculaBean.setProductoraPelicula(productora);
		

		try {
            if (peliculaDao.registrarPelicula(peliculaBean)) {
                System.out.println("Bien");
                if(peliculaDao.InsertarEnObra(peliculaBean));
                    response.sendRedirect("loginsuccess.jsp");
                    System.out.println("Bien2");
            } else {
                System.out.println("Mal");
                }
        } catch (IOException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }else {
            System.out.print("messi");
        }
    }
	}

