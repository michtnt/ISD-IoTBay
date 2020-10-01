<%-- 
    Document   : viewOrder
    Created on : 3 Jun 2020, 5:21:11 pm
    Author     : tayla
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
    int orderId = (int) session.getAttribute("orderId");
    int userId = (int) session.getAttribute("userId");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order</title>
    </head>
    <body>
        
        <jsp:include page="/OrderLineServlet" flush="true"/>
        <jsp:useBean id="orderLines" type="java.util.ArrayList" scope="session"/>
        <h1>View Order</h1>
        <c:forEach items="${orderLines}" var="orderLine">
            <tr>
                <td>${orderLine.productName}</td> 
                <td>
                    <form method="post" action="QuantityUp">
                    <input type="hidden" id="orderLineId" value="${orderLine.orderLineId}">
                    <input type="hidden" id="productId" value="${orderLine.productId}">
                    <input type="submit" value="Up">
                    </form>
                    </td>                
                <td>${orderLine.quatity}</td>
                <td><form method="post" action="QuantityDown">
                    <input type="hidden" id="orderLineId" value="${orderLine.orderLineId}">
                    <input type="hidden" id="productId" value="${orderLine.productId}">
                    <input type="submit" value="Up">
                    </form></td>
                <td>${orderLine.totalPrice}</td>
            </tr>
            
        </c:forEach>
            <tr>
                <th>Total Price:</th>
                <th><th>
            </tr>
            
        
</html>
