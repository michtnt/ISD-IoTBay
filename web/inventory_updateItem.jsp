<%-- 
    Document   : updateItem
    Created on : 12/05/2020, 4:06:13 PM
    Author     : rebeccagalletta
--%>

<%@page import="IoTBay.mvp.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Item</title>
    </head>
    <body>
        <h1>Update Item</h1>
        
        <%
            Product product = (Product) session.getAttribute("product");
            String updated = (String) session.getAttribute("updated");
        %>
                
        <% if (product != null)  { %>
        <form action="UpdateItemServlet" method="post">
            <table>
                <input type="hidden" id="oldproductname" name="oldproductname" value="${product.getProductname()}">
                <tr>
                    <th></th>
                    <th>Current Details</th>
                    <th>New Details</th>
                </tr>
                <tr>
                    <td>
                        <label for="productid"><b>Product ID</b></label>
                    </td>
                    <td>
                        <p><%=product.getProductid()%></p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="productname"><b>Product Name</b></label>
                    </td>
                    <td>
                        <p><%=product.getProductname()%></p>
                    </td>
                    <td>
                        <input type="text" id="productname" name="productname"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="brand"><b>Product Brand</b></label>
                    </td>
                    <td>
                        <p><%=product.getBrand()%></p>
                    </td>
                    <td>
                        <input type="text" id="brand" name="brand"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="price"><b>Product Price</b></label>
                    </td>
                    <td>
                        <p><%=product.getPrice()%></p>
                    </td>
                    <td>
                        <input type="text" id="price" name="price"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="stock"><b>Product Stock</b></label>
                    </td>
                    <td>
                        <p><%=product.getStock()%></p>
                    </td>
                    <td>
                        <input type="text" id="stock" name="stock"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for name="description"><b>Product Description</b></label>
                    </td>
                    <td>
                        <p><%=product.getDescription()%></p>
                    </td>
                    <td>
                        <input type="text" id="description" name="description"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td>
                        <input type="submit" value="Update Item">
                    </td>
                </tr>
            </table>
        </form> 
        <% } else {%>
        <span><%=(updated != null ? updated : "")%></span>
        <% } %>
        <br>
        <a href="inventory_searchItem.jsp">Back to Search Page</a><br>
        <a href="inventory_manageInventory.jsp">Back to Inventory Management Menu</a>
    </body>
</html>
