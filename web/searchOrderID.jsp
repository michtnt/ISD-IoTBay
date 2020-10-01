<%-- 
    Document   : searchOrderID
    Created on : 4 Jun 2020, 1:52:51 pm
    Author     : tayla
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.mvp.model.OrderLine"%>
<%@page import="IoTBay.mvp.model.Orders"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Order ID</title>
    </head>
    <% 
        Orders order = (Orders)request.getAttribute("order");
        ArrayList<OrderLine> orderLines = (ArrayList<OrderLine>)request.getAttribute("orderLines");
        request.setAttribute("orderLines", orderLines);
        ArrayList<Orders> orders = (ArrayList<Orders>)session.getAttribute("orders");;
        request.setAttribute("orders", orders);
        int searchOrderID = Integer.parseInt(request.getParameter("searchOrderID").toString());
        request.setAttribute("searchOrderID", searchOrderID);
    %>
    
    <body>
        <div class="navbar">
            <a href="userUpdate.jsp">User Management</a>
                <a href="Welcome.jsp">Home</a>
           <a href="contact">Access Logs</a>
           <b href="Logout.jsp">Logout</b> 
          
                        </div>
        <h1>Order Search</h1>
        <c:forEach  items="${orders}" var="order">
            
            <c:choose>
                <c:when test="${order.orderID == searchOrderID}">
                    
                    
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
                </c:when>
                
            </c:choose>
            </c:forEach>
            <a href="index.jsp">Go Home</a>
    </body>
</html>
