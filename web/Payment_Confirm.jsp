<%-- 
    Document   : PaymentSuccess
    Created on : May 17, 2020, 11:15:57 PM
    Author     : desyliunardi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Payment Confirmation</title>
    </head>
    
    <body>

        <%
            Integer paymentId = (Integer) session.getAttribute("paymentId");
        %>
        
        <p> userid #${userId}</p>
        <div class='center'>
            
        <p style="text-align: right; color: black; font-size:20px"> <i> Today's Date : <script> document.write(new Date().toLocaleDateString()); </script> </i></p>
        <h2 style="text-align: left"> Order #${orderId} </h2>
        <h2 style="font-size:30px; text-align:center ;">Confirm Purchase ?</h2>
        
        <form action = "Payment_Success.jsp" method="post">  
            

            <h3 style=' text-align: center'>Total Amount A$${order.getAmount()} </h3>
            <div class="center"><table style="text-align: center">
           
            <p style=' text-align: center'> Payment Method  = ${payment.getPaymentMethod()} </p>
            <p style=' text-align: center'>    Date Paid    = ${payment.getDatePaid()} </p>
            <p style=' text-align: center'>   Card Number   = ${payment.getCardNumber()} </p>
            <p style=' text-align: center'>   Expiry Date   = ${payment.getExpiryDate()} </p>
            <p style=' text-align: center'>       CVV       = ${payment.getCvv()} </p>
            <p style=' text-align: center'>  Name On Card   = ${payment.getNameOnCard()}</p>
    
            <input class= button type="submit" value="Confirm" >
             
        </form>
            <p> <a class ="buttonpaycon" id="column-left" href="Payment_DeleteServlet?paymentId=<%=paymentId%>">Cancel</a></p>
                    
            <p> <a class= "buttonpaycon" id="column-right" href="Payment_EditServlet?paymentId=<%=paymentId%>">Edit</a> </p>
            </div>        
            
    </body>
</html>
