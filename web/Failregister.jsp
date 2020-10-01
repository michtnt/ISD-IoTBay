<%-- 
    Document   : Register
    Created on : 24/04/2020, 10:32:46 AM
    Author     : Bailey
--%>

 

<%@page import="IoTBay.mvp.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>

 

     <body>
        
   <div class="main-component">
       <div class="dashboard-form-container with-bg has-subheading">
        <h1 class="form-title">Register</h1>
       <form action = "userController">
            <table>
                <tr>
                    <td>
                        <label for="email">Email</label>
                    </td>
                    <td>
                        <input type ="text" id="email" name="email" required><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="firstName">First Name</label>
                    </td>
                    <td>
                        <input type="text" id="firstName" name="firstName" required>
                    </td>
               
                </tr>
                <tr>
                    <td>
                        <label for name="lastName">Last Name</label>
                    </td>
                    <td>
                        <input type="text" id="lastName" name="lastName" required>
                    </td>
               
                </tr>
                <tr>
                    <td>
                        <label for name="password">Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="password" name="password" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="username">Username</label>                     
                    </td>
                    <td>
                        <input type="username" id="userName" name="username" required>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for name="address">Address</label>                     
                    </td>
                    <td>
                        <input type="address" id="address" name="address" required>
                    </td>
                </tr>
              
            </table>
            <input type="submit" value="Register" class ="btn btn-blue" : blue button>
          
            <p class="warning"> That email is taken, please try a different one. </p> 
        </form>
       </div>
   </div>
    </body>
 
</html>