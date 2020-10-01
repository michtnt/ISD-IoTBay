<%-- 
    Document   : showInventory
    Created on : 29/05/2020, 9:41:31 PM
    Author     : rebeccagalletta
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.mvp.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Inventory</title>
    </head>
    <body action="ShowInventoryServlet">
        
        <%
            ArrayList<Product> inventory = (ArrayList<Product>) session.getAttribute("inventory");
            String show = (String) session.getAttribute("show");
        %>
        
        <h1>IoTBay Inventory</h1>
        
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
            </tr>
            <%}%>
        </table>
        <br>
        <a href="inventory_manageInventory.jsp">Back to Inventory Management Menu</a><br>
        <% } else { %>
        <span><%=(show != null ? show : "")%></span>
        <%}%>
    </body>
</html>
