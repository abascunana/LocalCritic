package Web;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/critica")
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
	
		try {
			valCritica = Integer.parseInt(request.getParameter("valCritica"));
			textoCritica = request.getParameter("textoCritica");
			obraID = Integer.parseInt(request.getParameter("obraID"));
		}
		catch(Exception e) {
			   e.printStackTrace();
			   System.out.println("ahaahahahahhahahahah");
		}
		Critica criticaBean = new Critica();
		criticaBean.setValCritica(valCritica);
		criticaBean.setTextoCritica(textoCritica);
		criticaBean.setUsuarioID(1);
		criticaBean.setObraID(obraID);
		

		try {
		    if (criticaDao.registrarCritica(criticaBean)) {
		        System.out.println("Bien");
		           response.sendRedirect("loginsuccess.jsp");
		            System.out.println("Bien2");
		    } else {
		        System.out.println("Mal");
		        }
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
    }
	}
