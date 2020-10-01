<%-- 
    Document   : searchItem
    Created on : 29/05/2020, 12:11:53 PM
    Author     : rebeccagalletta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="IoTBay.mvp.model.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Inventory</title>
    </head>
    <body>
        <%
            String found = (String) session.getAttribute("found");
        %>
        <h1>Search Inventory</h1>
        
        <form action= "SearchItemServlet" method="post" autocomplete="off">
            <label for="productid">Product Name: </label>
            <input type="text" name="productname" ><input type="submit" value="Search Item"></form><br>
        
        <a href="inventory_manageInventory.jsp">Back to Inventory Management Menu</a>
        <br>
        <% //}else {%>
        <span><%=(found != null ? found : "")%></span>
        <% //} %>
    </body>
</html>
