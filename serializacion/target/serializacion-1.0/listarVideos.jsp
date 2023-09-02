<%-- 
    Document   : listarVideos
    Created on : 30/08/2023, 10:15:20 a. m.
    Author     : Sistemas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.mundo.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar videos</h1>
        <form action ="SvVideo" method="GET">
        </form>
        <input type = "submit" value="Mostar videos agregados">
        <%
           //Obtener el arrayList de la solicitud 
           ArrayList<Video> misVideos = (ArrayList)request.getSession().getAttribute("misVideo");

           //Mostrar los datos del array
           for(Video v : misVideos)
           {
             out.println("idVideo" + v.getIdVideo()+"<br>");
             out.println("Titulo" + v.getTitulo());
             out.println("Autor" + v.getAutor());
             out.println("Año" + v.getAnio());
             out.println("Categoria" + v.getCategoria());
             out.println("Url" + v.getUrl());
             out.println("Letra" + v.getLetra());
             
           }
        %>
        
        
        <ul>
            <li><a href="index.jsp">Regresar</a></li>
        </ul>
    </body>
</html>
