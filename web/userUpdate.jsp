<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.model.controller.updateController"%>
<%@page import="IoTBay.mvp.model.accessLogs"%>
<%@page import="IoTBay.model.controller.checkLogin"%>
<%@page import="IoTBay.mvp.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Update</title>
    </head>

 

     <body style="background-color:skyblue">
        
     <%
          User user = (User)session.getAttribute("user");       
     %> 
     <link rel="stylesheet" type="text/css" href="./css/main.css">
     <div class="main-component">
         <div class="dashboard-form-container with-bg has-subheading">
             
         <h1 class="form-title">User Update</h1>
       <form  method="post" action= "updateController">
            <table>
                <tr>
                    <td>
                        <label for="email">Update Email</label>
                    </td>
                    <td>
                        <input type ="text" id="regiEmail" placeholder="${user.email}" name="regiEmail"><br>
                    </td>
                     <td> 
                         <input type="submit" name="email" value="Update">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="firstName">Update First Name</label>
                    </td>
                    <td>
                        <input type="text" id="regiFirstName" placeholder="${user.firstName}" name="regiFirstName">
                    </td>
                     <td> 
                         <input type="submit" name="firstName" value="Update">
                    </td>
               
                </tr>
                <tr>
                    <td>
                        <label for name="lastName">Update Last Name</label>
                    </td>
                    <td>
                        <input type="text" id="regiLastName" placeholder="${user.lastName}" name="regiLastName">
                    </td>
                     <td> 
                         <input type="submit" name="lastName" value="Update">
                    </td>
               
                </tr>
                <tr>
                    <td>
                        <label for name="password">Update Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="regiPassword" placeholder="${user.password}" name="regiPassword">
                    </td>
                     <td> 
                         <input type="submit" name="password" value="Update">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="username">Update Username</label>                     
                    </td>
                    <td>
                        <input type="username" id="regiUsername" name="regiUsername">
                    </td>
                     <td> 
                         <input type="submit" name="username" value="Update">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for name="address">Update Address</label>                     
                    </td>
                    <td>
                        <input type="address" class = "btn btn-blue"id="regiAddress" placeholder="${user.address}" name="regiAddress">
                    </td>
                    <td> 
                         <input type="submit" name="address" value="Update">
                    </td>
                </tr>
                <tr>
                    <td> 
                         <input type="submit" name="delete" value="Delete Account">
                    </td>
                </tr>
              
            </table>
            <input type="submit" name="done" value="Done">
           
        </form>
         </div> 

 

</body> 
</html>