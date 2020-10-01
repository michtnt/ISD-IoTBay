<%-- 
    Document   : staff_home.jsp
    Created on : 15 May 2020, 10:44:54 pm
    Author     : Michelle Tanoto
    Comment    : A page for Admin to view, delete, edit, search staff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="IoTBay.mvp.model.*"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home Portal</title>
         <link rel="stylesheet" href="./css/admin_home.css">
    </head>
    <% 
       Admin admin = (Admin) session.getAttribute("admin"); // current admin user
       Staff searchStaff = (Staff) session.getAttribute("searchStaff"); // searched staff
       String fetchMessage = (String) session.getAttribute("fetchMessage"); // fetch staff list message
       String searchMessage = (String) session.getAttribute("searchMessage"); // searched staff message
       String deleteMessage = (String) session.getAttribute("deleteMessage"); // searched staff message
       ArrayList<Staff> rs = (ArrayList<Staff>) session.getAttribute("staffList"); // staff list
     %>   
    <body>
        <div>
            <div>
                <p class = "title">You are logged in as <b>${admin.getAdminUsername()}</b></p>
            </div>
            <div>
                <div class="button-container">
                    <a href="./admin_create_staff.jsp" class="btn btn-blue">Create Staff</a>
                    <a href="LogoutServlet" class="btn">Log out</a>
                </div>
            </div>
        </div>
            <br />
            <br />
            <div>
                <a href="inventory_manageInventory.jsp">Manage Inventory Menu</a>
            </div>
            <br>
            <br>
            <div>
                <a href="index.html">Manage Customers</a>
            </div>
            <br>
            <br>
           <div>
              <form action="SearchStaffServlet" method="post">
                <input id="search_username" name="search_username" type="text" placeholder="Search staff by username">
                <input id="search_position" name="search_position" type="text" placeholder="Search staff by position">
                <input id="search_submit" value="Search" type="submit">
              </form>
           </div> 
    <% if(searchStaff != null){ %>
    <div>
        <h1 class="title">Search Result</h1>
            <table style="width: 100%" class="fl-table">
             <thead>
                <tr>
                    <th class="subtitle"><b>First Name</b></td>
                    <th class="subtitle"><b>Last Name</b></td>
                    <th class="subtitle"><b>Email</b></td>
                    <th class="subtitle"><b>Address</b></td>
                    <th class="subtitle"><b>Username</b></td>
                    <th class="subtitle"><b>Position</b></td>
                    <th class="subtitle"><b>Active</b></td>
                </tr>
             </thead>
                <tr>
                 <td class="subtitle"><p><%=searchStaff.getStaffFName()%></p></td>
                 <td class="subtitle"><p><%=searchStaff.getStaffLName()%></p></td>
                 <td class="subtitle"><p><%=searchStaff.getStaffEmail()%></p></td>
                 <td class="subtitle"><p><%=searchStaff.getStaffAddress()%></p></td>
                 <td class="subtitle"><p><%=searchStaff.getStaffUsername()%></p></td>
                 <td class="subtitle"><p><%=searchStaff.getStaffPosition()%></p></td>
                 <td class="subtitle"><p><%=searchStaff.getActive()%></p></td>
                 <td class="subtitle"><a href="EditStaffServlet?username=<%= searchStaff.getStaffUsername()%>">Edit</a></td>
                 <td class="subtitle"><a href="DeleteStaffServlet?username=<%= searchStaff.getStaffUsername()%>">Delete</a></td>
             </tr>
         </table>
       <% } else { %>
      <span class="warning"><%=searchMessage != null ? searchMessage : ""%></span>
      <% } %>
    </div>
      <div>
            <h1 class="title">List of Staff</h1>
            <table style="width: 100%"  class="fl-table">
                <thead>
                <tr>
                    <th class="subtitle"><b>First Name</b></td>
                    <th class="subtitle"><b>Last Name</b></td>
                    <th class="subtitle"><b>Email</b></td>
                    <th class="subtitle"><b>Address</b></td>
                    <th class="subtitle"><b>Username</b></td>
                    <th class="subtitle"><b>Position</b></td>
                    <th class="subtitle"><b>Active</b></td>
                </tr>
                </thead>
                <%
               if(rs != null){
                    for(Staff s : rs){
                %>
                <tr>
                    <td class="subtitle"><p><%=s.getStaffFName()%></p></td>
                    <td class="subtitle"><p><%=s.getStaffLName()%></p></td>
                    <td class="subtitle"><p><%=s.getStaffEmail()%></p></td>
                    <td class="subtitle"><p><%=s.getStaffAddress()%></p></td>
                    <td class="subtitle"><p><%=s.getStaffUsername()%></p></td>
                    <td class="subtitle"><p><%=s.getStaffPosition()%></p></td>
                    <td class="subtitle"><p><%=s.getActive()%></p></td>
                    <td class="subtitle"><a href="EditStaffServlet?username=<%= s.getStaffUsername()%>">Edit</a></td>
                    <td class="subtitle"><a href="DeleteStaffServlet?username=<%= s.getStaffUsername()%>">Delete</a></td>
                </tr><% } } else { %> 
            </table>
             <span class="warning"><%=fetchMessage != null ? fetchMessage : ""%></span>
            <% } %>
            <span class="warning"><%=deleteMessage != null ? deleteMessage : ""%></span>
        </div>
    </body>
</html>
