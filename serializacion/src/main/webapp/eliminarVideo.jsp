<%-- 
    Document   : eliminarVideo
    Created on : 2/09/2023, 10:40:23 p. m.
    Author     : Johan Ordoñez
--%>

<%@page import="com.umariana.mundo.Persistencia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.mundo.Video"%>
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
        .eli {
            color: #A3D9C9;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }
        input[type="text"], input[type="submit"] {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .No {
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
        <h1>Eliminar cancion</h1>
        <form action="SvEliminar" method="POST">
            <label for="id">Ingrese el id de la cancion que desea eliminar:</label><br><br>
            <input type="text" id="id" name="id" required pattern="[0-9]+" title="Por favor, ingrese solo números">
            <input type="submit" value="Eliminar"><br>
            <ul>
                <% 
                    // Obtener el valor de cancionEliminar de la sesión
                    Integer seleccion = (Integer) request.getSession().getAttribute("cancionEliminar");
                    if (seleccion != null) {
                        // Ahora puedes usar "seleccion" como un entero
                        int idCancionEliminar = seleccion.intValue();
                        //Obtener el arrayList de la solicitud
                        
                        ArrayList<Video> misVideos = (ArrayList<Video>)request.getSession().getAttribute("listaDiscos");
                       
                        // Creamos un arrayList para alamacenar los elementos seleccionados
                        ArrayList<Video> cancionEliminar = new ArrayList<>();
                        
                        //Creamos un arrayList para almacenar los elementos sin el video eliminado
                        ArrayList<Video> nuevaLista = new ArrayList<>();
                        
                        ArrayList<Video> comprobar = new ArrayList<>();

                        if(misVideos == null){
                            misVideos = new ArrayList<>();
                            Persistencia.leerArchivo(misVideos);
                        }

                        // Código Java para recorrer y agregar las canciones de la categoria escogiga al arrayList nuevo
                        for (Video video : misVideos) {
                        
                            if(video.getIdVideo() != idCancionEliminar) {
                            nuevaLista.add(video);                          
                        }else{
                            comprobar.add(video);
                            cancionEliminar.add(video);
                            nuevaLista.remove(video);
                        }           
                        }
                        Persistencia.escribirArchivo(nuevaLista);
                    if (seleccion != null && comprobar.isEmpty()) {
                        %>
                        <strong class="No">Cancion no encontrada</strong>
                    <%
                    }else { 
                    for(Video prueba: nuevaLista){
                    System.out.println(prueba.getIdVideo());
                    }
                        for(Video cate : cancionEliminar){
                        %>
                        <strong class="eli">Este disco fue eliminado con exito</strong><br>
                        <strong></strong><br>
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
                     
                     <% } } }%>
            </ul>
        </form>    
    </div>
    <footer>
      <input type="button" value="Regresar" onclick="window.location.href='index.jsp';">
    </footer>
</body>
</html>

