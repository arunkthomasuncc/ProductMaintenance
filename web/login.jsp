<%-- 
    Document   : Login JSP
    Created on : Aug 6, 2018, 1:15:18 PM
    Author     : Shashi
--%>
<%@taglib prefix="mma" uri="/WEB-INF/customtags.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Maintenance</title>
    <link rel="stylesheet" href="styles/style.css" type="text/css"/>
</head>
<body>
    <h1>Login Form</h1>
    <p>Please enter a username and password to continue</p>
    
   <p><mma:ifEmptyMark color="red" field=""/> marks required fields</p>
        <p>${message}</p>
        <form action="productMaint" method="POST">
            <div class="block">
            <label for="username"> Username: </label>
            <input type="text" name="username" value="${username}"/> 
            <mma:ifEmptyMark color="red" field="${username}"/><br>
            </div>
            <div class="block">
            <label for="password">Password: </label>
            <input type="password" name="password" value="${password}"/> 
            <mma:ifEmptyMark color="red" field="${password}"/><br>
            </div>
            <div class="buttons">
            <input type="submit" name="action" value="Login"/>
            </div>
          </form>
</body>
</html>