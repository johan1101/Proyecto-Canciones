/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mundo.serializacion1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Johan Ordoñez
 */
public class MetodosServlets {
    
    public static void videosRecomendadosSvEliminar(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, FileNotFoundException, ClassNotFoundException{
        // Aquí obtén la lista de videos de la sesión si está disponible
            
    }
    
    public static void eliminarVideoSvEliminarPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{
        HttpSession misesion = request.getSession();
        //ArrayList<Video> misVideos = (ArrayList<Video>) misesion.getAttribute("listaDiscos");
        
        ArrayList<Video> misVideos = new ArrayList<>();
        Persistencia.leerArchivo(misVideos, context);
         
        // Obtener el valor de cancionEliminar desde el parámetro "genero"
        int cancionEliminar = Integer.parseInt(request.getParameter("id"));
        
        // Coloca cancionEliminar en la sesión
        misesion.setAttribute("cancionEliminar", cancionEliminar);
                
        // Coloca misVideos en la sesión
        misesion.setAttribute("listaDiscos", misVideos);           

        //Nos redirecciona a la misma pagina
        response.sendRedirect("eliminarVideo.jsp");     
    }
    
    public static void buscarNombreSvOpcionesPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{

            String rutaRelativa = "/data/discosAgregados.txt";
            String rutaAbsoluta = context.getRealPath(rutaRelativa);
            File archivo = new File(rutaAbsoluta);
            // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();
            ArrayList<Video> misVideos = new ArrayList<>();
            Persistencia.leerArchivo(misVideos, context);

            // Obtener el valor de generoSeleccionado desde el parámetro "genero"
            String nombreSeleccionado = request.getParameter("nombre");
      
            // Coloca misVideos en la sesión
            misesion.setAttribute("nombreSeleccionado", nombreSeleccionado);
            
            misesion.setAttribute("archivo", archivo);

            // Coloca misVideos en la sesión
            misesion.setAttribute("listaDiscos", misVideos);           

            //Nos redirecciona a la misma pagina
            response.sendRedirect("buscarNombre.jsp");
    }
    
    public static void buscarCategoriaSvOpcionesGet(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{
        // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();
            ArrayList<Video> misVideos = new ArrayList<>();
            Persistencia.leerArchivo(misVideos, context);

            // Obtener el valor de generoSeleccionado desde el parámetro "genero"
            String generoSeleccionado = request.getParameter("genero");
      
            // Coloca misVideos en la sesión
            misesion.setAttribute("generoSeleccionado", generoSeleccionado);
            
            // Coloca misVideos en la sesión
            misesion.setAttribute("listaDiscos", misVideos);           

            //Nos redirecciona a la misma pagina
            response.sendRedirect("buscarCategoria.jsp");
    }
    
    public static void listarVideosSvVideoGet(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{
        // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();
            
            ArrayList<Video> misVideos = (ArrayList<Video>) misesion.getAttribute("listaDiscos");

            // Si la lista de videos no está en la sesión, cárgala aquí
            if (misVideos == null) {
                misVideos = new ArrayList<>();
                Persistencia.leerArchivo(misVideos, context);
                misesion.setAttribute("listaDiscos", misVideos);
            }else{
                misesion.setAttribute("listaDiscos", misVideos);
            }
            
            // Luego, redirige a listarVideos.jsp
            response.sendRedirect("listarVideos.jsp");
    }
    
    
    public static void agregarVideoSvVideoPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{
        
        HttpSession session = request.getSession();
        ArrayList <Video> misVideos = (ArrayList<Video>) session.getAttribute("listaDiscos");
        
        //Crear una nueva lista si no existe
        if(misVideos == null){
            misVideos = new ArrayList<>();
            Persistencia.leerArchivo(misVideos, context);
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
        
        Persistencia.escribirArchivo(misVideos, context);
        
        //Agregar el arrayList completo de la solicitud como atributo
        session.setAttribute("listaDiscos", misVideos);
        
        
        
        //Redireccionar a la pagina de destino
        response.sendRedirect("agregarVideo.jsp");
}
}
