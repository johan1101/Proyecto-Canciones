
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
    }

    /**
     * Maneja las solicitudes HTTP POST para agregar videos.
     *
     * @param request La solicitud HTTP que contiene los parámetros y datos del cliente.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error en el servlet.
     * @throws IOException Si ocurre un error de E/S durante la manipulación de la solicitud o respuesta.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Llama al método "agregarVideoSvVideoPost" del servlet "MetodosServlets" para agregar un video
            MetodosServlets.agregarVideoSvVideoPost(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            // Registra cualquier excepción de tipo ClassNotFoundException que pueda ocurrir
            Logger.getLogger(SvVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
