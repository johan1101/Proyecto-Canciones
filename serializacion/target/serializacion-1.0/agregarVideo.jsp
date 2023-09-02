<%-- 
    Document   : agregarVideo
    Created on : 29/08/2023, 10:46:13 a. m.
    Author     : Johan Ordoñez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Disco</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://wallpapercave.com/wp/wp9157801.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8); /* Fondo semi-transparente para resaltar el formulario */
            border-radius: 8px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2);
            margin: 20px auto;
            padding: 40px;
            max-width: 420px;
        }
        h1 {
            text-align: center;
        }
        label {
            display: block;
            font-weight: bold;
            margin-top: 10px;
        }
        input[type="text"], textarea, select {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            background: url("arrow.png") no-repeat right center;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        input[type="button"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        input[type="button"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container" >
        <h1>Agregar Disco</h1>
        <form action="SvVideo" method="POST">
            <label for="idvideo">ID Video:</label>
            <input type="text" id="idvideo" name="idvideo" required>
            
            <label for="titulo">Título de la Canción:</label>
            <input type="text" id="titulo" name="titulo" required>
            
            <label for="autor">Autor del Video Musical:</label>
            <input type="text" id="autor" name="autor" required>
            
            <label for="anio">Año de Lanzamiento:</label>
            <input type="text" id="anio" name="anio" required>
            
            <label for="categoria">Categoría:</label>
            <select id="categoria" name="categoria" required>
                <option value="Pop">Pop</option>
                <option value="Rock">Rock</option>
                <option value="Hip-Hop">Hip-Hop</option>
                <option value="Electrónica">Electrónica</option>
                <option value="Otra">Otra</option>
            </select>
            
            <label for="url">URL del Video:</label>
            <input type="text" id="url" name="url" required>
            
            <label for="letra">Letra:</label>
            <textarea id="letra" name="letra" rows="5" required></textarea>
            
            <input type="submit" value="Agregar Disco">
            <input type="button" value="Regresar" style="float: right;" onclick="window.location.href='index.jsp';">

        </form>
    </div>
</body>
</html>
