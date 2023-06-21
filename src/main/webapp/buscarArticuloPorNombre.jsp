<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/14/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Buscar Articulo</title>
</head>
<body>
<h1 class="encabezado">
    Buscar Articulo
</h1>
<h2 class="subtitulo">
    Buscar por Nombre
</h2>
<form action="buscarArticuloTipo" method="post">
    <div class="centrado">
        <label> Nombre: </label>
        <input name="nombreArticulo" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="Modificar" class="boton">
        <br><br>
        <a class="boton" href="buscarArticulo.jsp">Volver</a>
    </div>
</form>
</body>
</html>
