<%-- 
    Document   : addProduct
    Created on : Jul 25, 2018, 10:50:50 PM
    Author     : Arun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
         <link rel="stylesheet" href="styles/style.css" type="text/css"/>
    </head>
    <body>
        <h1>Product</h1>
        <form action="productMaint" method="POST">
            <label for="name">Code </label>
            <input type="text" name="code"/> <br>
            <label for="description">Description </label>
            <input type="text" name="description"> <br>
            <label for="price">Price </label>
            <input type="text" name="price"/> <br>
            <input type="submit" name="action" value="Add Product"/>
            <input type="submit" name="action" value="View Products">
            <p>${message}</p>
            </form>
    </body>
</html>
