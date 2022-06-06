package Vista;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/critic")
public class  Criticaservlet extends HttpServlet {
	private SqlCritica criticaDao;
	
	public void init() {
		criticaDao = new SqlCritica();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		int valCritica = 0;
		String textoCritica = "";
		int obraID = 0;
		int UsuarioID = 0;
		int nota = 0;
	
		try {
			valCritica = Integer.parseInt(request.getParameter("valCritica"));
			textoCritica = request.getParameter("textoCritica");
			obraID = SqlCritica.BuscarID(request.getParameter("titulo"));
			UsuarioID = SqlCritica.conseguirIdUsuario(request.getParameter("nombreusuario"));
			
			
		}
		catch(Exception e) {
			   e.printStackTrace();
			   System.out.println("ahaahahahahhahahahah");
		}
		
		Critica criticaBean = new Critica();
		criticaBean.setValCritica(valCritica);
		criticaBean.setTextoCritica(textoCritica);
		criticaBean.setUsuarioID(UsuarioID);
		criticaBean.setObraID(obraID);
		

		try {
		    if (criticaDao.registrarCritica(criticaBean)) {
		        System.out.println("Bien");
		        nota = SqlCritica.calcularMediaObra(obraID);
		        
		        	SqlCritica.updateMedia(nota,obraID);
		        	int numCriticas = SqlCritica.numCriticas(UsuarioID);
		        	SqlCritica.UpdateNumCriticas(UsuarioID, numCriticas);
		        	int karma = SqlCritica.karma(UsuarioID);
		        	SqlCritica.UpdateKarma(UsuarioID, karma);
		        	int media = SqlCritica.MediaValUsuario(obraID, UsuarioID);
		        	SqlCritica.UpdateMediaValUsuario(UsuarioID, media);
		        	
		        
		           response.sendRedirect("loginsuccess.jsp");
		    } else {
		        System.out.println("Mal");
		        }
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
    }
	}
