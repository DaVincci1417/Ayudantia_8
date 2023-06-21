<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/14/2023
  Time: 3:32 PM
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
<table>
    <form action="buscarArticuloPorNombre.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Por Nombre" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="buscarArticuloPorTipo.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Por Tipo" class="boton">
        </div>
    </form>
    <p>

    </p>
    <div class="centrado">
        <a class="boton" href="index.jsp">Volver</a>
    </div>
</table>
</body>
</html>
