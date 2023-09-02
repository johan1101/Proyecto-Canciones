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
    <meta charset="UTF-8">
    <title>Mostrar Canciones Registradas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            background-color: #012030;
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
            color: #DAFDBA;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Canciones Registradas</h1>
        <ul>
            <% 
                // Código Java para recorrer la lista de canciones
                for (Video video : misVideos) {
            %>
            <li>
                <strong>Título:</strong> <%= video.getTitulo() %><br>
                <strong>Autor:</strong> <%= video.getAutor() %><br>
                <strong>Año:</strong> <%= video.getAnio() %><br>
                <strong>Categoría:</strong> <%= video.getCategoria() %><br>
                <strong>URL:</strong> <a href="<%= video.getUrl() %>"><%= video.getUrl() %></a><br>
                <strong>Letra:</strong><br>
                <%= video.getLetra() %>
            </li>
            <% } %>
        </ul>
    </div>
</body>
</html>
