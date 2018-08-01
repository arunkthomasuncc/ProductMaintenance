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
       
        <h2>Are you sure you want to delete this product?</h2>

        <form action="productMaint" method="POST">
            <label>Code: ${code}</label><br>

            <label>Description: ${description}</label><br>
  
            <label>Price: ${price}</label><br>

            <input type="hidden" name="productId" value="${productId}"/>
            <input type="submit" name="action" value="Yes"/> 
            <input type="submit" name="action" value="No"/> 
            
            </form>
    </body>
</html>
