/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mundo.serializacion1.MetodosServlets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Johan Ordoñez
 */
@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");     
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        processRequest(request, response);
    }

  
     /**
     * Maneja las solicitudes HTTP POST.
     *
     * @param request La solicitud HTTP que contiene los parámetros y datos del cliente.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error en el servlet.
     * @throws IOException Si ocurre un error de E/S durante la manipulación de la solicitud o respuesta.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Procesa la solicitud HTTP POST utilizando el método "processRequest"
        processRequest(request, response);

        try {
            // Llama al método "eliminarVideoSvEliminarPost" para gestionar la eliminación del video
            MetodosServlets.eliminarVideoSvEliminarPost(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            // Registra cualquier excepción de tipo ClassNotFoundException que pueda ocurrir
            Logger.getLogger(SvEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
