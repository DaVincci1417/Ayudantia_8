<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Tienda Electronica</title>
</head>
<body>
<h1 class="encabezado">
    Tienda de Electronica
</h1>
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
    <form action="listaArticulosModificar.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Modificar Articulo" class="boton" width="max-width" >
        </div>
    </form>

</table>
</body>
</html>