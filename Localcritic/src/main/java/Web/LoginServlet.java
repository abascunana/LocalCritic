package Web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Web.Base;
import Web.Usuario;


/**
 * LoginBeam = Usuario
 * LoginDao = Base
 * LoginServlet = LoginServlet;
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public int success = 0;
    private Base loginDao;
    public int comprobarsuc() {
 			return success;
 	    	
 	    }
    public void init() {
        loginDao = new Base();
    }

    	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Usuario loginBean = new Usuario();
        loginBean.setNombreDeUsuario(username);
        loginBean.setContrasenaDeUsuario(password);
response.addHeader("Access-Control-Allow-Origin", "*");
        try {
            if (loginDao.validate(loginBean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                success = 1;
            System.out.println( comprobarsuc()); 
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
                success = 0;
                System.out.println( comprobarsuc());      
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().print(comprobarsuc());
    
    }

	
  

}
