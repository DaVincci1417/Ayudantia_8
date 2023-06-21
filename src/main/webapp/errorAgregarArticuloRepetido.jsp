<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/14/2023
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <title>Agregar Articulo</title>
</head>
<body>
<h1 class="encabezado"> Agregar Articulo</h1>
<h2 class="subtitulo"> Articulo ya existe</h2>
<form action="agregarArticulo" method="post">
  <div class="centrado">
    <label> Nombre: </label>
    <input name="nombreArticulo" type="text" class="campoTexto">

    <label> Tipo: </label>
    <select name="tipo">
      <optgroup label="Seleccionar Tipo"></optgroup>
      <option>Computacion</option>
      <option>Linea Blanca</option>
      <option>Procesadores</option>
      <option>Accesorios</option>
      <option>Monitores y proyectoes</option>
    </select>

    <label> Peso: </label>
    <input name="peso" type="number" class="campoTexto">

    <label> Precio: </label>
    <input name="precio" type="number" class="campoTexto">

    <br><br>

    <input type="submit" value="Agregar Articulo" class="boton">
    <br><br>
    <a class="boton" href="index.jsp">Volver</a>
  </div>
</form>
</body>
</html>
