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
        <title>Update Product</title>
         <link rel="stylesheet" href="styles/style.css" type="text/css"/>
    </head>
    <body>
        <h1>Product</h1>
        <p><mma:ifEmptyMark color="red" field=""/> marks required fields</p>
        <p>${message}</p>
        <form action="productMaint" method="POST">
            <div class="block">
            <label for="code"> Code: </label>
            <input type="text" name="code" value="${code}"/> 
            <mma:ifEmptyMark color="red" field="${code}"/><br>
            </div>
            <div class="block">
            <label for="description">Description: </label>
            <input class="description" type="text" name="description" value="${description}"/> 
            <mma:ifEmptyMark color="red" field="${description}"/><br>
            </div>
            <div class="block">
            <label for="price">Price: </label>
            <input type="text" name="price"  value="${price}"/> 
            <mma:ifEmptyMark color="red" field="${price}"/><br>
            </div>
            <div class="buttons">
            <input type="submit" name="action" value="Add Product"/>
            <input type="submit" name="action" value="View Products">
            </div>
            
            </form>
    </body>
</html>
