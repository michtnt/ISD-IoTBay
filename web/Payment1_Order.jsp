<%-- 
    Document   : index
    Created on : May 26, 2020, 3:29:09 PM
    Author     : desyliunardi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    Integer userId = (Integer) session.getAttribute("userId");
    %>
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment-Order Page</title>
        
    </head>
    <body>
        <h1>In the Order Page. The Registered User/ unRegistered select products and have the total Amount.</h1>
        
        <form action = "Payment1_CreateOrderServlet" method="post">
            <p hidden> <input type= "text" name="username" value="<%=username%>">  </p>
            <p hidden> <input type= "text" name="password" value="<%=password%>">  </p>
            <p hidden> <input type= "text" name="userId" value="<%=userId%>"> </p>
                 <tr>
                    <td> <label for name="amount" class="subtitle">Amount</label> </td>
                    <td><input type ="number" id="amount" name="amount" placeholder="150.0" required></td>
                 </tr>
                
                 <input class= button type="submit" value="Add to Cart">
        </form>
        
    </body>
</html>
