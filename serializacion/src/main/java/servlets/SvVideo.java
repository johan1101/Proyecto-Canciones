
package servlets;

import com.umariana.mundo.Video;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {
    
    //Array el que va almacenar los videos
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Aqui viene los datos por POST
         // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();
            
            if(misesion.getAttribute("listaDiscos") != null){
               ArrayList<Video> misVideos = (ArrayList<Video>) misesion.getAttribute("listaDiscos");

            // Si la lista de videos no está en la sesión, cárgala aquí
            if (misVideos == null) {
                misVideos = new ArrayList<>();
            }

            // Coloca misVideos en la sesión
            misesion.setAttribute("listaDiscos", misVideos);  
            }else{
                ArrayList <Video> misVideos = new ArrayList<>();
                Video miVideo = new Video(0, "", "", "", "", "", "");
                misVideos.add(miVideo);
                
                misesion.setAttribute("listaDiscos", misVideos);
            }
           

            // Luego, redirige a listarVideos.jsp
            response.sendRedirect("listarVideos.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        ArrayList <Video> misVideos = (ArrayList<Video>) session.getAttribute("listaDiscos");
        
        //Crear una nueva lista si no existe
        if(misVideos == null){
            misVideos = new ArrayList<>();
        }
        
        
       // Aqui viene los datos por POST
       String idVideo = request.getParameter("idvideo");
       String titulo = request.getParameter("titulo");
       String autor = request.getParameter("autor");
       String anio = request.getParameter("anio");
       String categoria = request.getParameter("categoria");
       String url = request.getParameter("url");
       String letra = request.getParameter("letra");
     

        //Ingresar los datos al objeto
        Video miVideo = new Video(Integer.parseInt(idVideo), titulo, autor, anio, categoria, url, letra);        
        misVideos.add(miVideo);
        
        //Agregar el arrayList completo de la solicitud como atributo
        session.setAttribute("listaDiscos", misVideos);
        
        //Redireccionar a la pagina de destino
        response.sendRedirect("agregarVideo.jsp");

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
