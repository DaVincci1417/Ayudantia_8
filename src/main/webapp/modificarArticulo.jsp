<%@ page import="Model.Data.DBGenerator" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.lang.model.type.ArrayType" %>
<%@ page import="Model.Data.DAO.ArticuloDAO" %>
<%@ page import="Model.Articulo" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/14/2023
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mostrar usuarios</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<%
    Connection con;
    String Driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String clave = "";
    Class.forName(Driver);
    con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/TiendaElectronica",user,clave);
    PreparedStatement prepared;
    ResultSet resultSet;
    String nombreArticulo = request.getParameter("nombreArticulo");
    prepared = con.prepareStatement("select * from articulo where nombre_articulo="+nombreArticulo);
    resultSet = prepared.executeQuery();
    while (resultSet.next()){
%>
<h1 class="encabezado"> Modificar Articulo</h1>
<form action="" method="post">
    <div class="centrado">
        <label> Nombre: </label>
        <input readonly="" value="<%= resultSet.getString("nombre_articulo")%>" type="text" class="campoTexto">

        <label> Tipo: </label>
        <select name="tipo" value="value="<%= resultSet.getString("tipo_articulo")%>"">
            <optgroup label="Seleccionar Tipo"></optgroup>
            <option>Computacion</option>
            <option>Linea Blanca</option>
            <option>Procesadores</option>
            <option>Accesorios</option>
            <option>Monitores y proyectoes</option>
        </select>

        <label> Peso: </label>
        <input name="peso" type="number" class="campoTexto" value="value="<%= resultSet.getInt("peso")%>"">

        <label> Precio: </label>
        <input name="precio" type="number" class="campoTexto" value="<%= resultSet.getInt("precio")%>">

        <br><br>

        <input type="submit" value="Agregar Articulo" class="boton">
        <br><br>
        <a class="boton" href="index.jsp">Volver</a>
    </div>
</form>
<%}%>
</body>
</html>
<%
    String tipoArticulo;
    int peso, precio;
    tipoArticulo = request.getParameter("tipo");
    if(tipoArticulo != null && request.getParameter("peso") != null && request.getParameter("precio") != null){
        prepared = con.prepareStatement("update articulo set tipo_articulo='"+tipoArticulo+"',peso='"+Integer.parseInt(request.getParameter("peso"))+"',precio='"+request.getParameter("precio")+"'where nombre_articulo="+nombreArticulo);
        prepared.executeUpdate();
        response.sendRedirect("index.jsp");
    }
%>
