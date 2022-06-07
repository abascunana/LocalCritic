package Vista;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//Registra usuarios
@WebServlet("/registroUsuario")
public class RegistroUsuario extends HttpServlet {
	private SqlUsuarios registerDao;
	
	public void init() {
		registerDao = new SqlUsuarios();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
			
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String tipo = request.getParameter("tipoUsuario");
		System.out.print(tipo);
		System.out.print(request.getParameter("tipoUsuario"));
		Usuario registerBean = new Usuario();
		
		if(registerDao.existeUsuario(username) == 0) {
		
		
		registerBean.setNombreUsuario(username);
		registerBean.setContrasenaUsuario(password);
		registerBean.setEmailUsuario(email);
		registerBean.setTipoUsuario(tipo);;
		System.out.print(registerBean.getTipoUsuario());
		System.out.print(registerBean.getNombreUsuario());
		
		
	
        if (registerDao.registrar(registerBean)) {
            //HttpSession session = request.getSession();
            // session.setAttribute("username",username);
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
	
