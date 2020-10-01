<%-- 
    Document   : viewOrderHistory
    Created on : 4 Jun 2020, 1:18:35 pm
    Author     : tayla
--%>

<%@page import="IoTBay.mvp.model.OrderLine"%>
<%@page import="IoTBay.model.dao.OrderLineDBManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.mvp.model.Orders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History</title>
    </head>
    <% 
        ArrayList<Orders> orders = (ArrayList<Orders>)session.getAttribute("orders");
        session.setAttribute("orders", orders);
        request.setAttribute("orders", orders);
    %>
    <body>
        <div class="navbar">
            <a href="userUpdate.jsp">User Management</a>
                <a href="Welcome.jsp">Home</a>
           <a href="contact">Access Logs</a>
           <b href="Logout.jsp">Logout</b> 
          
                        </div>
        <h1>Order History</h1>
        <form action="GetOrderLines" method="post">
            <table>
                <tr>
                    <td><label for="searchOrderID">Search:</label></td>
                    <td><input type="text" name="searchOrderID"></td>
                    <td><input type="submit" value="Search"></td>
                </tr>
            </table>
        </form>
        <table>
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Total Price</th>
                </tr>
        <c:forEach items="${orders}" var="order">            
                <tr>
                    <td>${order.orderID}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.totalPrice}</td>
                </tr>
                
            
        </c:forEach>
                </table>
    </body>
</html>
