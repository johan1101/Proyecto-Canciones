<%-- 
    Document   : buscarVideos
    Created on : 2/09/2023, 8:42:44 a. m.
    Author     : Johan Ordoñez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Discos</title>
    <style>
        body {
            background-image: url('https://media.istockphoto.com/vectors/treble-clef-neon-icon-musical-note-music-school-logo-night-club-logo-vector-id1406984684?k=20&m=1406984684&s=170667a&w=0&h=YVjA44YZyvi-CDbDRCkcAWSngyifwUY4gWzqWErHPIw=');
            background-size: cover;
            background-repeat: no-repeat;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #223240;
            color: #ffffff;
            padding: 30px;
            text-align: center;
        }

        h1 {
            margin: 0;
            padding: 0;
        }

        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 0px 100px rgba(0, 0, 0, 0.2);
            margin: 20px auto;
            padding: 50px 70px;
            max-width: 600px;
            text-align: center;
        }

        .options {
            display: flex;
            justify-content: space-around;
            margin-top: 40px;
        }

        .options a {
            text-decoration: none;
            color: #3B8C66;
            font-weight: bold;
            padding: 10px 70px;
            border: 2px solid #3B8C66;
            border-radius: 20px;
            transition: background-color 0.3s, color 0.3s;
            margin-right: 5px;
        }

        .options a:hover {
            background-color: #3B8C66;
            color: #ffffff;
        }

        .image-container {
            text-align: center;
            margin-top: 30px;
        }

        .image-container img {
            max-width: 50%;
            height: 80%;
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

    </style>
</head>

<body>
    <header>
        <h1>Encuentra tu canción</h1>
    </header>

    <div class="container">
        <h2>Selecciona una opción</h2>
        <div class="options">
            <a href="listarVideos.jsp">Mostrar canciones registradas</a>
            <a href="buscarCategoria.jsp">Buscar por categoría</a>
            <a href="buscarNombre.jsp">Buscar por nombre</a>
        </div>

        <div class="image-container">
            <!-- Puedes agregar aquí una imagen llamativa -->
            <img src="https://th.bing.com/th/id/OIP.W3GAP7TeTk1HS8DJUAH8_QHaHa?pid=ImgDet&rs=1" alt="Imagen llamativa">
        </div>
    </div>

    <footer>
      <input type="button" value="Regresar" onclick="window.location.href='index.jsp';">
    </footer>
</body>

</html>
