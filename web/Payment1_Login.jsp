<%-- 
    Document   : admin_login.jsp
    Created on : 22 May 2020, 12:29:32 pm
    Author     : misel
    Comment    : Admin Login Portal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment-User Login Page</title>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            String existErr =(String) session.getAttribute("existErr");
            String usernameErr = (String) session.getAttribute("usernameErr");
            String passErr = (String) session.getAttribute("passErr");
         %>
        <div class="main-component">
            <div class="dashboard-form-container with-bg has-subheading">
              <h1 class="form-title"> Login</h1>
              <form action = "Payment1_LoginServlet" method="post">
                <table>
                 <tr>
                     <td> <label for name="username" class="subtitle">Username</label></td>
                     <td> <input type="text" id="username" name="username" required placeholder="<%=(usernameErr != null ? usernameErr : "Enter Username")%>"></td>
                </tr>
                <tr>
                     <td> <label for name="email" class="subtitle">Password</label></td>
                     <td> <input type="password" id="password" name="password" required placeholder="<%=(passErr != null ? passErr : "Enter Password")%>"></td>
                </tr>
                <tr class="break"><td colspan=2></td></tr>
               </table>
            <input type="submit" value="Login" class="btn btn-blue">
            </form>
               <span class="warning"><%=(existErr != null ? existErr : "")%></span>
          </div>
        </div>
    </body>
    <p> Click <a href ="Payment1_Register.jsp">Register</a> to create an account!</p>
     <jsp:include page="/ConnServlet" flush="true" />
</html>

