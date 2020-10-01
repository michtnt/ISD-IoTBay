<%-- 
    Document   : shipping
    Created on : 4 Jun 2020, 12:03:28 pm
    Author     : tayla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipping</title>
        <link rel="stylesheet" type="text/css" href="./css/main.css">
    </head>
    <body>
        
        <h1>Shipping</h1>
        <form action="FinishOrderServlet" method="post">
            <table>
                <tr>
                    <td> <label for="billingAddress">Billing Address: </label></td>
                    <td><input type="text" name="billingAddress"></td>
                </tr>
                <tr>
                    <td><label for="shippingAddress">Shipping Address: </label></td>
                    <td><input type="text" name="shippingAddress"></td>
                </tr>
            </table>
            <input type="submit" value="Proceed to Confirmation">
        </form>
    </body>
</html>
