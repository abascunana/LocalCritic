package Vista;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Vista.Conexion;
import Vista.Usuario;

//Realiza el login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public int success = 0;
    private Conexion loginDao;

    public void init() {
        loginDao = new Conexion();
    }
    

    	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.print(password);
        Usuario loginBean = new Usuario();
        loginBean.setNombreUsuario(username);
        loginBean.setContrasenaUsuario(password);
        response.addHeader("Access-Control-Allow-Origin", "*");
        try {
            if (loginDao.validate(loginBean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                success = 1;
                System.out.println(success);
     
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
               
              
                success = 0;
               
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      
        response.getWriter().print(success);
    }

	 
 

}