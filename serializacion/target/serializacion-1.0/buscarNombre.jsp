<%-- 
    Document   : buscarNombre
    Created on : 2/09/2023, 4:44:12 p. m.
    Author     : Johan Ordoñez
--%>

<%@page import="com.umariana.mundo.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar por Nombre</title>
    <style>
        body {
            background-image: url('https://media.istockphoto.com/vectors/treble-clef-neon-icon-musical-note-music-school-logo-night-club-logo-vector-id1406984684?k=20&m=1406984684&s=170667a&w=0&h=YVjA44YZyvi-CDbDRCkcAWSngyifwUY4gWzqWErHPIw=');
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
        input[type="text"], input[type="submit"] {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
        label {
            color: #ffffff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Buscar canción</h1>
        <form action="SvOpciones" method="POST">
            <!-- Campo de entrada para el nombre de la canción -->
            <label for="nombre">Nombre de la Canción:</label>
            <input type="text" id="nombre" name="nombre" required>
            <input type="submit" value="Buscar">
            <ul>
                <% 
                    // Obtener el arrayList de la solicitud
                    ArrayList<Video> misVideos = (ArrayList<Video>)request.getSession().getAttribute("listaDiscos");
                    
                    // Obtener el nombre de la canción ingresado por el usuario
                    String nombreCancion = (String) request.getSession().getAttribute("nombreSeleccionado");
                    
                    // Crear un arrayList para almacenar las canciones que coinciden con el nombre
                    ArrayList<Video> cancionesEncontradas = new ArrayList<>();

                    // Recorrer la lista de canciones y agregar las que coincidan con el nombre
                    for (Video video : misVideos) {
                        if (video.getTitulo().equals(nombreCancion)) {
                            cancionesEncontradas.add(video);
                        }
                    }
                    
                    for (Video cancion : cancionesEncontradas) {
                %>
                <li>
                    <strong>Id:</strong> <%= cancion.getIdVideo()%><br>
                    <strong>Título:</strong> <%= cancion.getTitulo() %><br>
                    <strong>Autor:</strong> <%= cancion.getAutor() %><br>
                    <strong>Año:</strong> <%= cancion.getAnio() %><br>
                    <strong>Categoría:</strong> <%= cancion.getCategoria() %><br>
                    <strong>URL:</strong> <a href=<%= cancion.getUrl() %><%= cancion.getUrl() %></a><br>
                    <strong>Letra:</strong><br>
                    <%= cancion.getLetra() %>
                </li>
                <% } %>
            </ul>
        </form>    
    </div>
    <footer>
        <input type="button" value="Regresar" onclick="window.location.href='buscarVideos.jsp';">
    </footer>
</body>
</html>

