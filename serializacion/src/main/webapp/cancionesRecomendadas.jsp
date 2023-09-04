<%-- 
    Document   : cancionesRecomendadas
    Created on : 4/09/2023, 11:34:53 a. m.
    Author     : Johan Ordoñez
--%>

<%@page import="com.umariana.mundo.Persistencia"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.mundo.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Canciones Recomendadas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #012030;
            margin: 0;
            padding: 0;
        }
        .container {
            background-color: #273D59;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            margin: 20px auto;
            padding: 20px;
            max-width: 800px;
        }
        h1 {
            color: #ffffff;
            text-align: center;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            color: #A3D9C9;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }
        footer {
            background-color: #223240;
            color: #ffffff;
            text-align: center;
            padding: 10px;
        }
        input[type="button"] {
            background-color: #3B8C66;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        input[type="button"]:hover {
          color: #3B8C66;
            background-color: #ffffff;
        }
        .vacio {
             color: #A3D9C9;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Canciones Recomendadas</h1>
        <form action="SvEliminar" method="GET">
            <ul>
                <% 
                    //Obtener el arrayList de la solicitud
                    
                    File archivo = new File("C:\\Users\\Johan Ordoñez\\Desktop\\Proyecto Videos\\Discossss-main\\Discossss-main\\Laboratorio_3-master\\serializacion\\data\\discosRecomendados.txt");
                    ArrayList<Video> misVideos = new ArrayList<>();
                    Persistencia.leerArchivo(misVideos);
                    if (misVideos == null && (archivo.exists() && archivo.length() < 10)) {
                       %> <strong class="vacio">No hay canciones registradas</strong> <%
                    }
                    if (misVideos == null){
                        ArrayList<Video> misVideo = new ArrayList<>();
                        Persistencia.leerArchivo(misVideo);
                            for (Video video : misVideo) {
                %>
                    <li>
                        <strong>Id:</strong> <%= video.getIdVideo()%><br>
                        <strong>Título:</strong> <%= video.getTitulo() %><br>
                        <strong>Autor:</strong> <%= video.getAutor() %><br>
                        <strong>Año:</strong> <%= video.getAnio() %><br>
                        <strong>Categoría:</strong> <%= video.getCategoria() %><br>
                        <strong></strong> <a> </a><br>
                        <strong>URL:</strong> <a href=<%= video.getUrl() %><%= video.getUrl() %></a><br>
                        <strong></strong> <a> </a><br>
                        <strong>Letra:</strong><br>
                        <%= video.getLetra() %>
                    </li>
                    <% } } %>
                    <%
                    if(misVideos != null ){
                          for (Video video : misVideos) {
                    %>
                    <li>
                        <strong>Id:</strong> <%= video.getIdVideo()%><br>
                        <strong>Título:</strong> <%= video.getTitulo() %><br>
                        <strong>Autor:</strong> <%= video.getAutor() %><br>
                        <strong>Año:</strong> <%= video.getAnio() %><br>
                        <strong>Categoría:</strong> <%= video.getCategoria() %><br>
                        <strong></strong> <a> </a><br>
                        <strong>URL:</strong> <a href=<%= video.getUrl() %><%= video.getUrl() %></a><br>
                        <strong></strong> <a> </a><br>
                        <strong>Letra:</strong><br>
                        <%= video.getLetra() %>
                    </li>
                    <% } } %>
                    
                   
                  
            </ul>
        </form>    
    </div>
    <footer>
      <input type="button" value="Regresar" onclick="window.location.href='buscarVideos.jsp';">
    </footer>
</body>
</html>

