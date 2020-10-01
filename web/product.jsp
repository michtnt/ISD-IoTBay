<%-- 
    Document   : product
    Created on : 27 May 2020, 9:55:26 pm
    Author     : tayla
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="IoTBay.model.dao.OrderDBManager"%>
<%@page import="IoTBay.mvp.model.Orders"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="IoTBay.mvp.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
        <%
    
    
            int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
            ArrayList<Product> inventory = (ArrayList<Product>) session.getAttribute("inventory");
            String show = (String) session.getAttribute("show");
    
        %>

        <form action="CartServlet" method="post">
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
                </table>

            </form>
                <% } else { %>
            <span><%=(show != null ? show : "")%></span>
                <%}%>
            <form action="OrderLineServlet" method="post">
                <input type="submit" value="Go to Cart"/>
            </form>
                    
        
    </body>
</html>
