<%-- 
    Document   : Welcome
    Created on : 24/04/2020, 10:25:16 AM
    Author     : Bailey
--%>

 


<%@page import="IoTBay.mvp.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.model.controller.checkLogin"%>
<%@page import="IoTBay.mvp.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
    </head>
    <link rel="stylesheet" type="text/css" href="./css/IOT.css">
     <body>
         <jsp:include page="/HomePageServlet"/>
         <form action =Main.jsp method="post">
           <%
             User user = checkLogin.getInstanceUser(); 
             session.setAttribute("user", user);
             
            %>
            
            
          <div class="navbar">
            <a href="userUpdate.jsp">User Management</a>
                <a href="Welcome.jsp">Home</a>
           <a href="contact">Access Logs</a>
           <a href="Logout.jsp">Logout</a> 
          
                        </div>
                

 

                <div class="main">
           
                    <center> 
            <h2>Welcome, <%=user.getFirstName()%> <%=user.getLastName()%> </h2>
            <p> userid #${userID}</p>
            <h2><%=user.getUserId()%></h2>
                

             
         </form>
            <form action="OrderLineServlet" method="post">
                <input type="submit" value="Cart"/>
            </form>
            <form action="OrderHistory" method="post">
                <input type="submit" value="Order History"/>
            </form>
            
        <%
            ArrayList<Product> inventory = (ArrayList<Product>) session.getAttribute("inventory");
            String show = (String) session.getAttribute("show");
        %> 
            <form action="UserCartServlet" method="post">
            <table>
                <tr>
                    <th>
                        <b>Product ID</b>
                    </th>
                    <th>
                        <b>Product Name</b>
                    </th>
                    <th>
                        <b>Brand</b>
                    </th>
                    <th>
                        <b>Price</b>
                    </th>
                    <th>
                        <b>Stock</b>
                    </th>
                    <th>
                        <b>Description</b>
                    </th>
                </tr>
                <%
                    if (inventory != null) {
                        for (Product p: inventory){

                %>
                <tr>
                    <td><p><%=p.getProductid()%></p></td>
                    <td><p><%=p.getProductname()%></p></td>
                    <td><p><%=p.getBrand()%></p></td>
                    <td><p><%=p.getPrice()%></p></td>
                    <td><p><%=p.getStock()%></p></td>
                    <td><p><%=p.getDescription()%></p></td>
                    <input type="hidden" name="productName" value="<%=p.getProductname()%>">
                    <input type="hidden" name="productID" value="<%=p.getProductid()%>">
                    <input type="hidden" name="price" value="<%=p.getPrice()%>">
                    <td><input type="submit" value="Add to Cart"></td>
                </tr>
                <%}%>
                <% } else { %>
                <span><%=(show != null ? show : "")%></span>
                <%}%>
            </table>
            </form>
            <br>
            
            </div>
     </center> 
    </body>
</html>