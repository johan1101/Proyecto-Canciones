
package servlets;

import com.mundo.serializacion1.MetodosServlets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            // Aqui viene los datos por GET
            MetodosServlets.listarVideosSvVideoGet(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo POST para agregar video
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Aqui vienen los datos por POST
            MetodosServlets.agregarVideoSvVideoPost(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
