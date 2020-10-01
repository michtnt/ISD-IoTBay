<%-- 
    Document   : searchResult
    Created on : 31/05/2020, 12:39:04 AM
    Author     : rebeccagalletta
--%>

<%@page import="IoTBay.mvp.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body>
        
        <%
            Product product = (Product) session.getAttribute("product");
            String found = (String) session.getAttribute("found");
        %>
        
        <h1>Search Results</h1>
        
        <% if (product != null)  { %>
        <table>
            <tr>
                <td>
                    <b>Product ID: </b>
                </td>
                <td>
                    <p><%=product.getProductid()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Product Name: </b>
                </td>
                <td>
                    <p><%=product.getProductname()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Brand: </b>
                </td>
                <td>
                    <p><%=product.getBrand()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Price: </b>
                </td>
                <td>
                    <p><%=product.getPrice()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Stock: </b>
                </td>
                <td>
                    <p><%=product.getStock()%></p>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Description: </b>
                </td>
                <td>
                    <p><%=product.getDescription()%></p>
                </td>
            </tr>
        </table>

        <a href="inventory_updateItem.jsp">Update this Item</a>
        
        <a href="inventory_deleteItem.jsp">Delete this Item</a> <br>
        
        <a href="inventory_searchItem.jsp">Return to Search Page</a>
        <% } else {%>
        <span><%=(found != null ? found : "")%></span>
        <% } %>
    </body>
</html>
