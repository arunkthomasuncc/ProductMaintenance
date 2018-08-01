<%-- 
    Document   : editProducts
    Created on : Jul 30, 2018, 8:12:06 PM
    Author     : gabec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
        <link rel="stylesheet" href="styles/style.css" type="text/css"/>
    </head>
    <body>
       
        <h1>Product</h1>
        <form action="editProduct" method="POST">
            <label for="code">Code </label>
            <input type="text" name="code"/>${product.code}<br>
            <label for="description">Description </label>
            <input type="text" name="description">${product.description} <br>
            <label for="price">Price </label>
            <input type="text" name="price"/>${product.price} <br>
            <input type="submit" name="action" value="Update Product"/>
            <p>${message}</p>
            </form>
    </body>
</html>
