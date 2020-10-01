<%-- 
    Document   : FindPayment
    Created on : May 28, 2020, 1:46:29 AM
    Author     : desyliunardi
--%>


<%@page import="IoTBay.mvp.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>             
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Search Page</title>
    </head>
           <%              
              String searchMessage = (String) session.getAttribute("searchMessage");
              Payment searchPayment = (Payment) session.getAttribute("searchPayment");           
           %>
    <body width='700px'>
        <p style="text-align: right; color: black; font-size:20px"> <a class = button href = "Payment1_Order.jsp"> <i>Go to HomePage</i></a>
        <a class = button href = "Payment1_LogoutServlet"> <i>Logout</i></a></p>
        <h2>Search Payment details by payment ID and Date Paid!</h2>
       
        <form action="Payment_SearchServlet" method="post">
            
        <p>#${paymentId} </p>
        <table>
            <tr> <td><label for name="search_paymentId" class="subtitle">Payment ID </label></td>
                 <td><input type ="text" id="search_paymentId" name="search_paymentId" placeholder= "search by paymentId" required ></td>
            </tr>
                
                <tr> <td><label for name="search_datePaid" class="subtitle">Date Paid </label></td>
                    <td><input type ="date" id="search_datePaid" name="search_datePaid" placeholder= "search by datepaid" required ></td>
                </tr>
                <tr> <td><input id="search" class="button" type="submit" value="search"></td></tr>
        </table>
        </form>
            <% if(searchPayment != null){ %>
            <b><p>Payment Details!</p></b>
       
        
        <table>
	<thead>
                <tr>
                    <th><b>Payment Id</b></th>
                    <th><b>Date Paid</b></th>
                    <th><b>OrderId</b></th>
                    <th><b>Payment Method</b></th>
                    <th><b>Card Number</b></th>
                    <th><b>CVV</b></th>
                    <th><b>Name On Card</b></th>
                    <th><b>Expiry Date</b></th>
                </tr>
        </thead>
        <tbody> 
                <tr>
                    <td><p>${paymentId}</p></td>
                    <td><p><%=searchPayment.getDatePaid()%></p></td>
                    <td><p>${orderId}</p></td>
                    <td><p><%=searchPayment.getPaymentMethod()%></p></td>
                    <td><p><%=searchPayment.getCardNumber()%></p></td>
                    <td><p><%=searchPayment.getCvv()%></p></td>
                    <td><p><%=searchPayment.getNameOnCard()%></p></td>
                    <td><p><%=searchPayment.getExpiryDate()%></p></td>
                </tr> 
        </tbody>
        </table> 
        
            <%  } else { %>
            <span><%=(searchMessage != null ? searchMessage : "")%></span>
            <% } %>
            
    </body>
</html>
