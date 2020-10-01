<%-- 
    Document   : PaymentSuccess
    Created on : May 29, 2020, 2:30:53 PM
    Author     : desyliunardi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    Integer userId = (Integer) session.getAttribute("userId");
    String username = (String) session.getAttribute("username");
    %>
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Success Page</title>
    </head>
    <body>
        ${userId}
        <p style="text-align: right; color: black; font-size:20px"> <a class = button href = "Payment_ShowHistoryServlet?username=<%=username%>&userId=<%=userId%>"> <i>View Payment History </i></a></p>
        <h2>Purchase#${paymentId} </h2>                                                     
        <h1>Your order and payment are confirmed!</h1>                                  
        <p> We will let you know when your order is ready for collection through your email address.</p>        
        
        <p style="text-align: center; color: black; font-size:20px"> <a class = button href ="Payment_Search.jsp"> <i>Search Payment</i></a></p>    
    
    </body>
</html>
