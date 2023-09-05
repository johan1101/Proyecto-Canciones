
package servlets;

import com.umariana.mundo.MetodosServlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {
    
    //Array el que va almacenar los videos
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
   
    //Metodo GET para listar videos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Aqui viene los datos por GET
         MetodosServlets.listarVideosSvVideoGet(request, response, getServletContext());
    }

    //Metodo POST para agregar video
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Aqui vienen los datos por POST
        MetodosServlets.agregarVideoSvVideoPost(request, response, getServletContext());
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
