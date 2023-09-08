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

    //Metodo para buscar video por categoria
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        try {           
            MetodosServlets.buscarCategoriaSvOpcionesGet(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvOpciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            
        try {
            MetodosServlets.buscarNombreSvOpcionesPost(request, response, getServletContext());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvOpciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

