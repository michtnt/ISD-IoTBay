<%-- 
    Document   : OrderCart
    Created on : May 29, 2020, 12:40:12 PM
    Author     : desyliunardi
--%>

<%@page import="IoTBay.mvp.model.Payment_Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <%
            Payment_Order order = (Payment_Order) session.getAttribute("order");
            Integer orderId = (Integer) session.getAttribute("orderId");
            Integer userId = (Integer) session.getAttribute("userId");
            %>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment-Order Cart Page</title>
    </head>
    <body>
        #${userId}
         <h1>In the Order Cart where customer have their product listed and Total Amount</h1>
         <p>Click on check out to finalize your order! </p>
         <h1>Total Amount is ${order.getAmount()}</h1>
         <a  class =" button" href="Payment_Create.jsp?userId=<%=userId %>&orderId=<%=orderId %>&amount=<%= order.getAmount()%>">Checkout</a>
    </body>   
</html>
