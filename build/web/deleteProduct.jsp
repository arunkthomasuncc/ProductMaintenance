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
       
        <h1>Are you sure you want to delete this product?</h1>

        <form action="productMaint" method="POST">
            <div class="block">
            <label >Code: </label>${code}<br>
            </div>
            <div class="block">
            <label>Description: </label>${description}<br>
            </div>
            <div class="block">
            <label>Price:</label>${price}<br>
            </div>

            <input type="hidden" name="productId" value="${productId}"/>
            <div class="buttons">
            <input class="delete" type="submit" name="action" value="Yes"/> 
            <input class="delete" type="submit" name="action" value="No"/> 
            
            </div>
            </form>
    </body>
</html>
