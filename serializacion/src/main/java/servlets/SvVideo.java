
package servlets;

import com.umariana.mundo.Persistencia;
import com.umariana.mundo.Video;
import java.io.File;
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
         // Aqui viene los datos por GET
         // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();
            
            ArrayList<Video> misVideos = (ArrayList<Video>) misesion.getAttribute("listaDiscos");

            // Si la lista de videos no está en la sesión, cárgala aquí
            if (misVideos == null) {
                misVideos = new ArrayList<>();
                Persistencia.leerArchivo(misVideos);
                misesion.setAttribute("listaDiscos", misVideos);
            }else{
                misesion.setAttribute("listaDiscos", misVideos);
            }
            
            
            
          
            // Luego, redirige a listarVideos.jsp
            response.sendRedirect("listarVideos.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File archivo = new File("C:\\Users\\Johan Ordoñez\\Desktop\\Proyecto Videos\\Discossss-main\\Discossss-main\\Laboratorio_3-master\\serializacion\\data\\discosAgregados.txt");
        
        HttpSession session = request.getSession();
        ArrayList <Video> misVideos = (ArrayList<Video>) session.getAttribute("listaDiscos");
        
        //Crear una nueva lista si no existe
        if(misVideos == null){
            misVideos = new ArrayList<>();
            Persistencia.leerArchivo(misVideos);
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
        
        Persistencia.escribirArchivo(misVideos);
        
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
