package Vista;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registroLibro")
public class  RegistroLibro extends HttpServlet {
	private SqlLibro libroDao;
	
	public void init() {
		libroDao = new SqlLibro();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
			
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		String titulo = request.getParameter("titulo");
		String sinopsis = request.getParameter("sinopsis");
		String genero = request.getParameter("genero");
		String escritor = request.getParameter("escritor");
		String editorial = request.getParameter("editorial");		
		int fecha = Integer.parseInt(request.getParameter("fecha"));
		int numpag = Integer.parseInt(request.getParameter("numpag"));
		int ultimaedicion = Integer.parseInt(request.getParameter("ultimaedicion"));
		
		Libro libroBean = new Libro();
		
		if(libroDao.existeLibro(titulo) == 0) {
		

		libroBean.setIsbn(isbn);
		libroBean.setTituloLibro(titulo);
		libroBean.setSinopsisLibro(sinopsis);
		libroBean.setGeneroLibro(genero);
		libroBean.setEscritor(escritor);
		libroBean.setEditorial(editorial);
		libroBean.setAnoLanzamientoLibro(fecha);
		libroBean.setNumPag(numpag);
		libroBean.setUltimaEdicion(ultimaedicion);
		

		try {
            if (libroDao.registrarLibro(libroBean)) {
                System.out.println("Bien");
                if(libroDao.InsertarEnObra(libroBean));
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
