
package com.mundo.serializacion1;

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
    
    
     /**
     * Procesa la eliminación de un video.
     *
     * @param request La solicitud HTTP que contiene los parámetros.
     * @param response La respuesta HTTP para redireccionar.
     * @param context El contexto ServletContext para gestionar la sesión.
     * @throws IOException Si ocurre un error de E/S durante la redirección.
     * @throws ClassNotFoundException Si la clase del objeto leído no se encuentra.
     */
    public static void eliminarVideoSvEliminarPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{
        HttpSession misesion = request.getSession();
         
        // Obtener el valor de cancionEliminar desde el parámetro "genero"
        int cancionEliminar = Integer.parseInt(request.getParameter("id"));
        
        // Coloca cancionEliminar en la sesión
        misesion.setAttribute("cancionEliminar", cancionEliminar);
                          
        //Nos redirecciona a la misma pagina
        response.sendRedirect("eliminarVideo.jsp");     
    }
    
    
     /**
     * Procesa la búsqueda de un video por nombre.
     *
     * @param request La solicitud HTTP que contiene los parámetros.
     * @param response La respuesta HTTP para redireccionar.
     * @param context El contexto ServletContext para gestionar la sesión.
     * @throws IOException Si ocurre un error de E/S durante la redirección.
     * @throws ClassNotFoundException Si la clase del objeto leído no se encuentra.
     */
    public static void buscarNombreSvOpcionesPost(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{

            HttpSession misesion = request.getSession();

            // Obtener el valor de generoSeleccionado desde el parámetro "genero"
            String nombreSeleccionado = request.getParameter("nombre");
      
            // Coloca misVideos en la sesión
            misesion.setAttribute("nombreSeleccionado", nombreSeleccionado);
                    
            //Nos redirecciona a la misma pagina
            response.sendRedirect("buscarNombre.jsp");
    }
    
    
    /**
     * Procesa la búsqueda de videos por categoría utilizando el método GET.
     *
     * @param request La solicitud HTTP que contiene los parámetros.
     * @param response La respuesta HTTP para redireccionar.
     * @param context El contexto ServletContext para gestionar la sesión.
     * @throws IOException Si ocurre un error de E/S durante la redirección.
     * @throws ClassNotFoundException Si la clase del objeto leído no se encuentra.
     */
    public static void buscarCategoriaSvOpcionesGet(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws IOException, ClassNotFoundException{
        // Aquí obtén la lista de videos de la sesión si está disponible
            HttpSession misesion = request.getSession();

            // Obtener el valor de generoSeleccionado desde el parámetro "genero"
            String generoSeleccionado = request.getParameter("genero");
      
            // Coloca misVideos en la sesión
            misesion.setAttribute("generoSeleccionado", generoSeleccionado);           

            //Nos redirecciona a la misma pagina
            response.sendRedirect("buscarCategoria.jsp");
    }
    
    
     /**
     * Procesa la solicitud para agregar un nuevo video utilizando el método POST.
     *
     * @param request La solicitud HTTP que contiene los parámetros del formulario.
     * @param response La respuesta HTTP para redireccionar.
     * @param context El contexto ServletContext para gestionar la sesión y el archivo.
     * @throws IOException Si ocurre un error de E/S durante la redirección.
     * @throws ClassNotFoundException Si la clase del objeto leído no se encuentra.
     */
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
