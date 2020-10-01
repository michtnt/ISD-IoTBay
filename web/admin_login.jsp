<%-- 
    Document   : admin_login.jsp
    Created on : 22 May 2020, 12:29:32 pm
    Author     : Michelle Tanoto
    Comment    : Admin Login Portal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Portal</title>
         <link rel="stylesheet" href="./css/admin_login.css">
    </head>
    <body>
        <%
            String existErr =(String) session.getAttribute("existErr");
            String usernameErr = (String) session.getAttribute("usernameErr");
            String passErr = (String) session.getAttribute("passErr");
         %>
        <div class="main-component">
            <div class="dashboard-form-container with-bg has-subheading">
              <h1 class="form-title">Admin Login</h1>
              <form action = "LoginServlet" method="post">
                <table>
                 <tr>
                    <td>
                        <label for name="username" class="subtitle">Username</label>                     
                    </td>
                    <td>
                        <input type="text" id="username" name="username" required placeholder="<%=(usernameErr != null ? usernameErr : "Enter Username")%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="email" class="subtitle">Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="password" name="password" required placeholder="<%=(passErr != null ? passErr : "Enter Password")%>">
                    </td>
                </tr>
              <tr class="break"><td colspan=2></td></tr>
            </table>
            <input type="submit" value="Login" class="btn btn-blue">
        </form>
               <span class="warning"><%=(existErr != null ? existErr : "")%></span>
          </div>
        </div>
    </body>
     <jsp:include page="/ConnServlet" flush="true" />
</html>

