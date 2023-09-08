/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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


/**
 *
 * @author Johan Ordoñez
 */
@WebServlet(name = "SvOpciones", urlPatterns = {"/SvOpciones"})
public class SvOpciones extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
    

     /**
     * Maneja las solicitudes HTTP GET.
     *
     * @param request La solicitud HTTP que contiene los parámetros y datos del cliente.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error en el servlet.
     * @throws IOException Si ocurre un error de E/S durante la manipulación de la solicitud o respuesta.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Procesa la solicitud HTTP GET utilizando el método "processRequest"
        processRequest(request, response);

        try {
            // Llama al método "buscarCategoriaSvOpcionesGet" para buscar videos por categoría
            MetodosServlets.buscarCategoriaSvOpcionesGet(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            // Registra cualquier excepción de tipo ClassNotFoundException que pueda ocurrir
            Logger.getLogger(SvOpciones.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            // Llama al método "buscarNombreSvOpcionesPost" para buscar videos por nombre
            MetodosServlets.buscarNombreSvOpcionesPost(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            // Registra cualquier excepción de tipo ClassNotFoundException que pueda ocurrir
            Logger.getLogger(SvOpciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

