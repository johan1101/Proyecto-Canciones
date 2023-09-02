/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.umariana.mundo.Video;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Johan Ordoñez
 */
@WebServlet(name = "SvOpciones", urlPatterns = {"/SvOpciones"})
public class SvOpciones extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

            // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();
            ArrayList<Video> misVideos = (ArrayList<Video>) misesion.getAttribute("listaDiscos");

            // Obtener el valor de generoSeleccionado desde el parámetro "genero"
            String generoSeleccionado = request.getParameter("genero");
      
            // Coloca misVideos en la sesión
            misesion.setAttribute("generoSeleccionado", generoSeleccionado);
            
            // Si la lista de videos no está en la sesión, cárgala aquí
            if (misVideos == null) {
                misVideos = new ArrayList<>();
                // Agrega los videos a misVideos aquí
            }

            // Coloca misVideos en la sesión
            misesion.setAttribute("listaDiscos", misVideos);           

            //Nos redirecciona a la misma pagina
            response.sendRedirect("buscarCategoria.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
