<%-- 
    Document   : editProducts
    Created on : Jul 30, 2018, 8:12:06 PM
    Author     : gabec
--%>
<%@ taglib prefix="mma" uri="/WEB-INF/customtags.tld" %>
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
        <p><mma:ifEmptyMark color="red" field=""/> marks required fields</p>
        <p>${message}</p>
        <form action="productMaint" method="POST">
            <label for="code">Code </label>
            <input type="text" name="code" value="${code}"/>
            <mma:ifEmptyMark color="red" field="${code}"/><br>
            <label for="description">Description </label>
            <input type="text" name="description" value="${description}"/> 
            <mma:ifEmptyMark color="red" field="${description}"/><br>
            <label for="price">Price </label>
            <input type="text" name="price" value="${price}"/> 
            <mma:ifEmptyMark color="red" field="${price}"/><br>
            <input type="hidden" name="productId" value="${productId}"/>
            <input type="hidden" name="oldCode" value="${oldCode}"/>
            <input type="submit" name="action" value="Update Product"/>
            <input type="submit" name="action" value="View Products"> 
            
            </form>
    </body>
</html>
