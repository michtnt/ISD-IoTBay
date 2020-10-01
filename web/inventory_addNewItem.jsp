<%-- 
    Document   : addNewItem
    Created on : 12/05/2020, 3:57:10 PM
    Author     : rebeccagalletta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="IoTBay.mvp.model.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Item</title>
    </head>
    <body>
        
        <%
            String added = (String)session.getAttribute("added");
        %>
        
        
        <h1>Add New Item</h1>
        
        <form action= "AddNewItemServlet" method="post" autocomplete="off">
            <table>
                <tr>
                    <td>
                        <label for name="productname">Product Name: </label>
                    </td>
                    <td>
                        <input type="text" id="productname" name="productname"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="brand">Product Brand: </label>
                    </td>
                    <td>
                        <input type="text" id="brand" name="brand"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="price">Product Price: </label>
                    </td>
                    <td>
                        <input type="text" id="price" name="price"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="stock">Stock: </label>
                    </td>
                    <td>
                        <input type="text" id="stock" name="stock"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="description">Description: </label>
                    </td>
                    <td>
                        <input type="text" id="description" name="description"><br>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Add New Item">
        </form>
        <br>
        <a href="inventory_manageInventory.jsp">Back to Inventory Management Menu</a><br>
        <span><%= (added != null ? added : "")%></span>
    </body>
</html>
