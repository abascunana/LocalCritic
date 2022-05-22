package Vista;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * LoginBeam = Usuario
 * LoginDao = Base
 * LoginServlet = LoginServlet;
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private SqlUsuarios loginDao;

    public void init() {
        loginDao = new SqlUsuarios();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        usuarios loginBean = new usuarios();
       

        loginBean.setNombreUsuario(username);
        loginBean.setContraseñaUsuario(password);


            try {
				if (loginDao.logearse(loginBean)) {
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
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }
}