  %-- 
    Document   : Main
    Created on : 24/04/2020, 10:32:55 AM
    Author     : Bailey
--%>

<%@page import="IoTBay.mvp.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="./css/style.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
          <div class="main-component">
<center>
            <h1>Main Page</h1>
            
        
                <%
            User user = (User)session.getAttribute("user");
        %>
        
        <center>
            <form action =userUpdate.jsp method="post">
                <p><input type="submit" value="Register"></p>
             </form>
             
            <h1>Welcome, <%=user.getFirstName()%> <%=user.getLastName()%> </h1>
            <p> You have logged in with email, <%=user.getEmail()%>  </P> 
            <p> You live at ${user.address} </P> 
            <p> You picked the username ${user.username}
            <form action =Logout.jsp method="post">
            <p> <input type="submit" value="Logout"> </P>
            <p> Your id is ${user.userId} </p>
            </center>
                  </form>
            </div> 
        </body>
    
</html>
