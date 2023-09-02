<%-- 
    Document   : index
    Created on : 29/08/2023, 10:34:41 a. m.
    Author     : Johan Ordoñez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <base target="_top">
  <title>Pagina Principal</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #ffffff;
    }

    header {
      background-color: #223240;
      color: #ffffff;
      padding: 35px;
      text-align: center;
    }



    nav {
      
      background-color: #347355;
      padding: 20px;
      text-align: center;
      border-radius: 0px;
    }

    

    nav a {

      text-decoration: none;
      color: #ffffff;
      margin: 0 40px;
      transition: color 0.5s;
      padding: 15px 10px;
      border-radius: 10px;
    }

    nav a:hover {
      background-color: #3B8C66;
    }

    main {
      width: 50%;
      padding:70px;
      background-color: #ffffff;
      height: 230px;
    }

    .Imagen_1 {
      background-color: #ffffff;
      padding: 0px;
      position: absolute;
      top: 43%;
      right: 0;
      width: 40%;
      height: 300px;
      text-align: right;
    }

  .Imagen_1 main_2 {
    width: 100%; /* La imagen ocupa todo el ancho del main_2 */
    height: 100%; /* La altura se ajustará automáticamente */
  }

  .Imagen_1 img {
    width: 100%; /* La imagen ocupa todo el ancho de main_2 */
    height: 99%; /* La altura se ajustará automáticamente */
    margin-top: 10px;
  }

    .Imagen_1 img:hover {
      transform: scale(1.1); /* Cambia el valor para ajustar el nivel de agrandamiento */
    }

    h2 {
      color: #336699;
      margin: px;
      padding: 0px;
      margin: -35px 0 0 0;
    }

    main p  {
      margin: 30px 0 0 0;
    }

    ul {
      list-style: center;
      padding-left: 20;
      padding: 25;
      margin: 40px 0 0 0;
    }

    li {
      margin-bottom: 25px;
    }

    header_2 {
      padding: 0px;
      margin: 0;
    }

    header_2 h4{
      background-color: #223240;
      color: #ffffff;
      padding: 35px;
      text-align: center;
      margin: 0px 0 0 0;
    }

    ul li:hover {
      transform: scale(1.0); /* Cambia el valor para ajustar el nivel de agrandamiento */
      text-decoration: underline;
    }

    
  </style>
</head>

<body>
  <header>
    <h1>Bienvenido a la Magia de la Música</h1>
    <p>Crea Tu Propia Lista de Música Favorita</p>
  </header>
  <nav>
    <a href="agregarVideo.jsp">Agregar canción</a>
    <a href="listarVideos.jsp">Buscar canción</a>
    <a href="#">Canciones recomendadas</a>
    <a href="#">Eliminar canción</a>
  </nav>
  <main>
    <h2>Pregúntate: ¿Por qué es importante la música?</h2>
    <p>Hay muchas razones, pero las principales son:</p>
    <ul>
      <li>La música nos conecta emocionalmente.</li>
      <li>Expresa lo que las palabras no pueden.</li>
      <li>Mejora nuestro estado de ánimo.</li>
      <li>Ayuda a relajarse y reducir el estrés.</li>
    </ul>
    
  </main>

  <div class="Imagen_1">
  <main_2>
     <img src="https://1.bp.blogspot.com/-qouMFaRWPPc/Xt_dsho-CKI/AAAAAAAAAUo/RwYpXGuxk_QzHTzz8KrvV5AxLolcqqD8ACLcBGAsYHQ/s1600/mefmusicaycuentos.jpg" alt="Java Logo">
  </main_2>
  </div>

  <header_2>
    <h4>&copy; 2023 Johan Ordoñez. Todos los derechos reservados.</h4>
  </header_2>

</body>

</html>