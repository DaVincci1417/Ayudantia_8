<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="Model.Data.DBGenerator" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.lang.model.type.ArrayType" %>
<%@ page import="Model.Data.DAO.ArticuloDAO" %>
<%@ page import="Model.Articulo" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
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
    prepared = con.prepareStatement("select * from articulo");
    resultSet = prepared.executeQuery();
%>
<div class="centrado">
    <h1 class="encabezado">Articulos de la Tienda</h1>
    <br><br>
    <table class="table">
        <tr>
            <th class="th centrado">Nombre Articulo</th>
            <th class="th centrado">Tipo Articulo</th>
            <th class="th centrado">Peso</th>
            <th class="th centrado">Precio</th>
            <th class="th centrado"></th>
        </tr>
        <%
            while(resultSet.next()){
        %>
        <tr>
            <td class="td centrado"><%= resultSet.getString("nombre_articulo")%></td>
            <td class="td centrado"><%= resultSet.getString("tipo_articulo")%> </td>
            <td class="td centrado"><%= resultSet.getInt("peso")%></td>
            <td class="td centrado"><%= resultSet.getInt("precio")%></td>
            <td class="td centrado">
                <a href="modificarArticulo.jsp?nombre_articulo=<%= resultSet.getString("nombre_articulo")%>" class="boton">Modificar</a>
            </td>
        </tr>
        <%}%>
    </table>
    <br><br>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
