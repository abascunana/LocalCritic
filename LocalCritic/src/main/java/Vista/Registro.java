package Vista;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registro")
public class Registro extends HttpServlet {
	private SqlUsuarios registerDao;
	
	public void init() {
		registerDao = new SqlUsuarios();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
			
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String password2 = request.getParameter("password2");
		usuarios registerBean = new usuarios();
		
		if(registerDao.existeUsuario(username) == 0) {
		String nuevoPass = hash.sha1(password);
		
		registerBean.setNombreUsuario(username);
		registerBean.setContraseñaUsuario(nuevoPass);
		registerBean.setEmailUsuario(email);
		
		
	
        if (registerDao.registrar(registerBean)) {
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
	
