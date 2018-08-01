<%-- 
    Document   : addProduct
    Created on : Jul 25, 2018, 10:50:50 PM
    Author     : Arun
--%>
<%@ taglib prefix="mma" uri="/WEB-INF/customtags.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
         <link rel="stylesheet" href="styles/style.css" type="text/css"/>
    </head>
    <body>
        <h1>Product</h1>
        <p><mma:ifEmptyMark color="blue" field=""/> marks required fields</p>
        <form action="productMaint" method="POST">
            <label for="name">Code </label>
            <input type="text" name="code"/> 
            <mma:ifEmptyMark color="blue" field="${product.code}"/><br>
            <label for="description">Description </label>
            <input type="text" name="description"> 
            <mma:ifEmptyMark color="blue" field="${product.description}"/><br>
            <label for="price">Price </label>
            <input type="text" name="price"/> 
            <mma:ifEmptyMark color="blue" field="${product.price}"/><br>
            <input type="submit" name="action" value="Add Product"/>
            <input type="submit" name="action" value="View Products">
            <p>${message}</p>
            </form>
    </body>
</html>
