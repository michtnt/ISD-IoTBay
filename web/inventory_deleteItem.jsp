<%-- 
    Document   : deleteItem
    Created on : 26/05/2020, 12:51:49 PM
    Author     : rebeccagalletta
--%>

<%@page import="IoTBay.mvp.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Inventory Item</title>
    </head>
    <body>
        
        <%
            Product product = (Product) session.getAttribute("product");
            String deleted = (String) session.getAttribute("deleted");
        %>
        <h1>Delete Inventory Item</h1>

        <% if (product != null)  { %>
        <form action="DeleteItemServlet" method="post">
            <table>
                <input type="hidden" id="oldproductname" name="oldproductname" value="${product.getProductname()}">
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
                <tr>
                    <p>Are you sure you want to delete this item?</p>
                </tr>
                <tr>
                    <input type="submit" value="Delete">
                </tr>
            </table>
        </form>
        <% } else {%>
        <span><%=(deleted != null ? deleted : "")%></span>
        <% } %>
        <br>
        <a href="inventory_searchItem.jsp">Back to Search Page</a>    
    </body>
</html>
