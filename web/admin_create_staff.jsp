<%-- 
    Document   : staff_create
    Created on : 15 May 2020, 11:05:00 pm
    Author     : Michelle Tanoto
    Comment    : A page for admin to create staff 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Staff Portal</title>
        <link rel="stylesheet" href="./css/admin_create_staff.css">
        <%
          String created = (String) session.getAttribute("created");  
        %>
    </head>
    <body>
     <div class="main-component">
       <div class="dashboard-form-container with-bg has-subheading">
         <h1 class="form-title">Create Staff Portal</h1>
         <form action="CreateStaffServlet" method="post">
            <table>
                <tr>
                    <td>
                        <label for="first-name" class="subtitle">First Name</label>
                    </td>
                    <td>
                        <input type ="text" id="name" name="firstName" placeholder="John" required><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="last-name" class="subtitle">Last Name</label>
                    </td>
                    <td>
                        <input type="text" id="name" name="lastName" placeholder="Doe">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="address" class="subtitle">Address</label>                     
                    </td>
                    <td>
                        <input type="text" id="address" name="address" placeholder="Australia">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="email" class="subtitle">Email</label>                     
                    </td>
                    <td>
                        <input type="email" id="email" name="email" placeholder="johndoe@gmail.com" required>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for name="position" class="subtitle">Position</label>                     
                    </td>
                    <td>
                        <select id="position" name="position">
                            <option value="Manager">Manager</option>
                            <option value="Admin">Admin</option>
                            <option value="Sales Person">Sales Person</option>
                            <option value="IT Support">IT Support</option>
                        </select>
                    </td>
                </tr>
                <tr class="break"><td colspan=2></td></tr>
                <tr>
                    <td>
                        <label for name="username" class="subtitle">Username</label>                     
                    </td>
                    <td>
                        <input type="text" id="username" name="username" placeholder="unicornfart90" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="password" class="subtitle">Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="password" name="password" placeholder="strong_password" required>
                    </td>
                </tr>
                <tr class="break"><td colspan=2></td></tr>
            </table>
            <input type="submit" value="Create" class="btn btn-blue">
        </form>
           <div class="button-container">
                <p><a class="btn" href="./admin_home.jsp">Cancel</a></p>
           </div>
         <span><%= created != null ? created : "" %></span>
       </div>
     </div>
    </body>
</html>

