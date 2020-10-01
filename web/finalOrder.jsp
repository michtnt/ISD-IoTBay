<%-- 
    Document   : finalOrder
    Created on : 4 Jun 2020, 12:41:33 pm
    Author     : tayla
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.mvp.model.OrderLine"%>
<%@page import="IoTBay.mvp.model.Orders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
        <link rel="stylesheet" type="text/css" href="./css/main.css">
    </head>
    <% 
        Orders order = (Orders)session.getAttribute("order");
        
        ArrayList<OrderLine> orderLines = (ArrayList<OrderLine>) session.getAttribute("orderLines");
        request.setAttribute("orderLines", orderLines);
    %>
    <body>
        <div class="navbar">
            <a href="userUpdate.jsp">User Management</a>
                <a href="Welcome.jsp">Home</a>
           <a href="contact">Access Logs</a>
           <b href="Logout.jsp">Logout</b> 
          
                        </div>
        <h1>Order Confirmation</h1>
        <table>
            <tr>
                <td>Order ID: </td>
                <td>${order.orderID}</td>
            </tr>
            <tr>
                <td>Order Date: </td>
                <td>${order.orderDate}</td>
            </tr>
            <tr>
                <td>Shipping Address: </td>
                <td>${order.shippingAddress}</td>
            </tr>
            <tr>
                <td>Billing Address: </td>
                <td>${order.billingAddress}</td>
            </tr>
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
                <td></td>                
                <td>${orderLine.quantity}</td>
                <td></td>
                <td>${orderLine.totalPrice}</td>
            </tr>                       
        </c:forEach>
            <tr></tr>
            <tr>
                <td>Price:</td>
                <td>${order.totalPrice}<td>
            </tr>
            <tr>
                <td>Tax: </td>
                <td>${order.tax}</td>
            </tr>
            <tr>
                <td>Total Price: </td>
                <td>${order.totalPrice + order.tax}</td>
            </tr>
            </table>
            <form action="DeleteOrder" method="post">
                <input type="submit" value="Cancel Order">
            </form>
            <a href="Payment_Create.jsp?userId=<%= order.getUserID() %>&orderId=<%= order.getOrderID() %>&amount=<%= order.getTotalPrice()%>">Create Payment</a>
    </body>
</html>
