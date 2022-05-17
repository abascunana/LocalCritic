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
    private Base loginDao;

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

        try {
            if (loginDao.validate(loginBean)) {
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
            e.printStackTrace();
        }
    }
}
