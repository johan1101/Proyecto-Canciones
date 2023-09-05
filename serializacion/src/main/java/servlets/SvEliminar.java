/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.umariana.mundo.MetodosServlets;
import com.umariana.mundo.Persistencia;
import com.umariana.mundo.Video;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        processRequest(request, response);
        // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();
            
            ArrayList<Video> misRecomendados = new ArrayList<>();
            Persistencia.leerRecomendados(misRecomendados);

            // Si la lista de videos no está en la sesión, cárgala aquí
            if (misRecomendados == null) {
                misRecomendados = new ArrayList<>();
                Persistencia.leerRecomendados(misRecomendados);
                misesion.setAttribute("listaRecomendados", misRecomendados);
            }else{
                misesion.setAttribute("listaRecomendados", misRecomendados);
            }
            
            // Luego, redirige a listarVideos.jsp
            response.sendRedirect("index.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        MetodosServlets.eliminarVideoSvEliminarPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
