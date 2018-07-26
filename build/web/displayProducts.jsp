<%-- 
    Document   : displayProducts
    Created on : Jul 25, 2018, 8:46:18 PM
    Author     : Arun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Products</title>
        <link rel="stylesheet" href="styles/style.css" type="text/css"/>
    </head>
    <body>
       
        <h1>Products</h1>
        <table>
            <thead>
                <th>Code</th>
                <th>Description</th>    
                <th>Price</th>
                <th></th>
                <th></th>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                    <td><c:out value="${product.code}"/></td>
                    <td><c:out value="${product.description}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><a href="prouductMaint?action=editProduct&amp;code=${product.code}">Edit</a></td>
                    <td><a href="prouductMaint?action=deleteProduct&amp;code=${product.code}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="productMaint" method="get">
            <input type="hidden" name="action" value="addProduct">
            <input type="submit" value="Add Product">
        </form>
    </body>
</html>
