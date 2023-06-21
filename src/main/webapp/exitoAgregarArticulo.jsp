<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/14/2023
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title></title>
</head>
<body>
<h1 class="encabezado">
    Tienda de Electronica
</h1>
<h2 class="subtitulo">
    Se ha agregado con exito el articulo
</h2>
<table>
    <form action="agregarArticulo.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Articulo" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="agregarCliente.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Cliente" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="buscarArticulo.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Buscar Articulo" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="listaArticulos" method="get">
        <div class="centrado">
            <input type="submit" value="Modificar Articulo" class="boton" width="max-width" >
        </div>
    </form>
</table>
</body>
</html>