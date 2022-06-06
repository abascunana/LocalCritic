package Vista;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/lista")
public class EnviarLista extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String resultado = null;
        resultado = BasesPelicula.ListaObras();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().append(resultado);
    }

}