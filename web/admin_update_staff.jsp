<%-- 
    Document   : admin_update_staff
    Created on : 22 May 2020, 12:47:10 pm
    Author     : Michelle Tanoto
    Comment    : A page for admin to update staff details
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="IoTBay.mvp.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Staff Portal</title>
        <link rel="stylesheet" href="./css/admin_update_staff.css">
    </head>
    <body>
        <%
            Staff staff = (Staff) session.getAttribute("staff");
            String updated = (String) session.getAttribute("updated");
            String oldUsername = (String) session.getAttribute("oldUsername");
        %>
     <div class="main-component">
       <div class="dashboard-form-container with-bg has-subheading">
         <h1 class="form-title">Update Staff Details</h1>
         <form action = "UpdateStaffServlet" method="post">
            <table>
                        <input type ="hidden" id="oldUsername" name="oldUsername" placeholder="Kylo" required value="${oldUsername}"><br>
                <tr>
                    <td>
                        <label for="first-name" class="subtitle">First Name</label>
                    </td>
                    <td>
                        <input type ="text" id="name" name="firstName" placeholder="Kylo" required value="${staff.getStaffFName()}"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="last-name" class="subtitle">Last Name</label>
                    </td>
                    <td>
                        <input type="text" id="name" name="lastName" placeholder="Ren" value="${staff.getStaffLName()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="address" class="subtitle">Address</label>                     
                    </td>
                    <td>
                        <input type="text" id="address" name="address" placeholder="Alaska" value="${staff.getStaffAddress()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="email" class="subtitle">Email</label>                     
                    </td>
                    <td>
                        <input type="email" id="email" name="email" placeholder="kylo@gmail.com" value="${staff.getStaffEmail()}">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for name="email" class="subtitle">Position</label>                     
                    </td>
                    <td>
                        <select id="position" value="${staff.getStaffPosition()}" name="position">
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
                        <input type="text" id="username" name="username" placeholder="squirel101" required value="${staff.getStaffUsername()}"> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="email" class="subtitle">Password</label>                     
                    </td>
                    <td>
                        <input type="password" id="password" name="password" placeholder="P4$$W0rD" required value="${staff.getStaffPassword()}">
                    </td>
                </tr>
              <tr>
                  <td>
                    <label for="active" class="subtitle">Active</label><br>
                  </td>
                  <td>
                     <input type="checkbox" id="active" name="active" value="TRUE">
                  </td>
              </tr>
                <tr class="break"><td colspan=2></td></tr>
            </table>
            <input type="submit" value="Update" class="btn btn-blue">
        </form>
           <div class="button-container">
                <p><a class="btn" href="./admin_home.jsp">Cancel</a></p>
           </div>
         <span><%=(updated != null ? updated : "")%></span>
       </div>
     </div>
    </body>
</html>


