<%-- 
    Document   : buscarCategoria
    Created on : 2/09/2023, 10:32:06 a. m.
    Author     : Johan Ordoñez
--%>

<%@page import="com.mundo.serializacion1.Persistencia"%>
<%@page import="java.io.File"%>
<%@page import="com.mundo.serializacion1.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar por categoria</title>
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
        label {
            color: #fff;
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
        <h1>Canciones Registradas</h1>
        <form action="SvOpciones" method="GET">
            <!-- Agrega el menú desplegable para seleccionar el género -->
            <label for="genero">Seleccionar género:</label>
            <select id="genero" name="genero">
                <option value="Pop">Pop</option>
                <option value="Rock">Rock</option>
                <option value="Hip-Hop">Hip-Hop</option>
                <option value="Electronica">Electronica</option>
                <option value="Otra">Otra</option>
            </select>
            <input type="submit" value="Filtrar"><br>
            <%         
                String seleccion = (String) request.getSession().getAttribute("generoSeleccionado");
            %>
            <label for="genero">Genero: 
                <% if (seleccion != null && !seleccion.isEmpty()) { %>
                    <%= seleccion %>
                <% } %>
            </label>
            <ul>
                <% 
                    //Obtener el arrayList de la solicitud
                    ArrayList<Video> misVideos = new ArrayList();
                    ServletContext context = getServletContext();
                    Persistencia.leerArchivo(misVideos, context);
               
                    if (misVideos.isEmpty()) {
                       %> <strong class="vacio">No hay canciones registradas</strong> <%
                    }
                    else{       
                    // Creamos un arrayList para alamacenar los elementos seleccionados
                    ArrayList<Video> categoria = new ArrayList<>();

                    // Código Java para recorrer y agregar las canciones de la categoria escodiga al arrayList nuevo
                    for (Video video : misVideos) {
                        if (video.getCategoria().equals(seleccion)) {
                        categoria.add(video);
                        }
                    }
                    for(Video cate : categoria){
                %>
                <li>
                    <strong>Id:</strong> <%= cate.getIdVideo()%><br>
                    <strong>Título:</strong> <%= cate.getTitulo() %><br>
                    <strong>Autor:</strong> <%= cate.getAutor() %><br>
                    <strong>Año:</strong> <%= cate.getAnio() %><br>
                    <strong>Categoría:</strong> <%= cate.getCategoria() %><br>
                    <strong></strong> <a> </a><br>
                    <strong>URL:</strong> <%= cate.getUrl() %><br>
                    <strong></strong> <a> </a><br>
                    <strong>Letra:</strong><br>
                    <%= cate.getLetra() %>
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
