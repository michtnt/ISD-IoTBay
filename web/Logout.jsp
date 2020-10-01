<%-- 
    Document   : Logout
    Created on : 24/04/2020, 10:33:03 AM
    Author     : Bailey
--%>

 

<%@page import="IoTBay.mvp.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="./css/main.css">
    </head>
    <body>
        <div class="main-component">
       <form method="post" action="logout">
                        <%
            User user = (User)session.getAttribute("user");
            String loginpass = user.getPassword(); 
            String loginemail = user.getEmail(); 
        %>
        
        
        <p class="title"><%=user.getUsername()%>, you have successfully logged out.</p>
        <p class="title"> See you next time! </p>
     
       
        <input type="submit" value="Return to index" class = "btn btn-blue" : blue button>
         </form>
        </div>
    </body>
</html>