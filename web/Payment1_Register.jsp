<%-- 
    Document   : Register
    Created on : Apr 20, 2020, 4:38:55 PM
    Author     : desyliunardi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment-User Register Page</title>
    </head>
    <body>
        <form action =Payment1_CreateUserServlet method="post">
            <h1> User Register / Shop Now for anonymous User</h1>   
            <table>
                <tr>
                    <td><label for="username">Username</label></td>
                    <td>
                        <input type ="text" id="username" name="username" placeholder="Enter Username" required><br>
                    </td>
                </tr>
                <tr>
                    <td> <label for name="password">Password</label> </td>
                    <td> <input type="password" id="password" name="password" placeholder="Enter Password" required> </td>
                </tr>
            </table>
            <input type="submit" value="Register">
        </form>
        
        <form action = "Payment1_LoginServlet" method="post"> 
             <input type="submit" value="Shop Now">
        </form>

        <p> Already have an account? Click here to <a href ="Payment1_Login.jsp"> Login </a>
         <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
