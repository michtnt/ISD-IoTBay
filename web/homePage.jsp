<%-- 
    Document   : homePage
    Created on : 08/06/2020, 10:23:53 AM
    Author     : rebeccagalletta
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.mvp.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay</title>
        
    </head>
    
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    
    <body>
        <% 
            int userID = 1;
            session.setAttribute("userID", userID);
            request.setAttribute("userID", userID);
            userID = Integer.parseInt(session.getAttribute("userID").toString());
            %>
        <jsp:include page="/HomePageServlet"/>
        <h1>IoTBay</h1>
        
        <a href="Login.jsp">Login</a>
        <a href="Register.jsp">Register</a>
         <a href="Payment1_Register.jsp">Payment_Register</a>
        <form action="OrderServlet" method="post">
            
            
            <input type="hidden" name="userID" value="<%=userID%>">
            <input class="button" type="submit" value="Products">
            
        </form>
       
        
        <jsp:include page="/ConnServlet" flush="true"/>
        
    </body>
</html>
