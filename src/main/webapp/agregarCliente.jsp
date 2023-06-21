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
    <title>Agregar Cliente</title>
</head>
<body>
<h1 class="encabezado"> Agregar Cliente</h1>
<form action="agregarCliente" method="post">
    <div class="centrado">
        <label> Nombre: </label>
        <input name="nombreCliente" type="text" class="campoTexto">

        <label> RUT: </label>
        <input name="rut" type="number" class="campoTexto">

        <label> Correo: </label>
        <input name="correo" type="text" class="campoTexto">

        <br><br>

        <input type="submit" value="Agregar Cliente" class="boton">
        <br><br>
        <a class="boton" href="index.jsp">Volver</a>
    </div>
</form>
</body>
</html>
