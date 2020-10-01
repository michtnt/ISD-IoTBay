<%-- 
    Document   : cart
    Created on : 26 May 2020, 3:40:54 pm
    Author     : tayla
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="IoTBay.model.dao.OrderLineDBManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="IoTBay.mvp.model.OrderLine"%>
<%@page import="IoTBay.mvp.model.Orders"%>
<%@page import="IoTBay.mvp.model.Product"%>
<% 
    Orders order = (Orders)session.getAttribute("order");
    ArrayList<OrderLine> orderLines = (ArrayList<OrderLine>) session.getAttribute("orderLines");
    request.setAttribute("orderLines", orderLines);
    session.setAttribute("orderLines", orderLines);
            %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" type="text/css" href="./css/main.css">
    </head>
    <body>
        
        <h1>View Cart</h1>
        <table>
                <tr>
                    <th>Product Name</th>
                    <th></th>
                    <th>Quantity</th>
                    <th></th>
                    <th>Total Price</th>
                </tr>
        <c:forEach items="${orderLines}" var="orderLine">
            
            <tr>
                <td>${orderLine.productName}</td> 
                <td>
                    <form method="post" action="QuantityUp">
                    <input type="hidden" name="orderLineID" value="${orderLine.orderlineID}">
                    <input type="hidden" name="productID" value="${orderLine.productID}">
                    <input type="submit" value="Up">
                    </form>
                    </td>                
                <td>${orderLine.quantity}</td>
                <td><form method="post" action="QuantityDown">
                    <input type="hidden" name="orderLineID" value="${orderLine.orderlineID}">
                    <input type="hidden" name="productID" value="${orderLine.productID}">
                    <input type="submit" value="Down">
                    </form></td>
                <td>${orderLine.totalPrice}</td>
            </tr>
            
            
        </c:forEach>
            <tr></tr>
            <tr>
                <td>Total Price:</td>
                <td>${order.totalPrice}<td>
            </tr>
            <tr>
                <td>Tax: </td>
                <td>${order.tax}</td>
            </tr>
            </table>
            <% 
            session.setAttribute("totalPrice", order.getTotalPrice());
            session.setAttribute("tax", order.getTax());
            %>
        <form action="ShippingServlet" method="post">
            <input type="submit" value="Continue to Shipping">
        </form>
    </body>
</html>
