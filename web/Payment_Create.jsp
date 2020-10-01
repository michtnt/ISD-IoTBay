<%-- 
    Document   : CreatePayment
    Created on : May 25, 2020, 10:00:46 PM
    Author     : desyliunardi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/payment_style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Payment Create Page</title>
    </head>
    
    <body>
        
        <form action="Payment_CreateServlet" method="post">
       
        <h1> Order #${orderId} </h1>
        <h2> Total Amount A$${order.getAmount()} </h2>
        
        <div class="body-text"> 
            <h3><label for name="paymentMethod">Payment Method</label></h3>
                <select id="paymentMethod" name="paymentMethod">
                <option value="Credit Card">Credit Card</option></select></div>
 
            <b><label for name="datePaid">Date Paid</label></b>
                <input type="date" id="coloumn-left" name="datePaid" placeholder="Date Paid" required/> 
             
                <div class="form-container">
                <div class="personal-information">
                <h1>Payment Information</h1></div> 
            
             <input type="number" id="input-field" name="cardNumber" placeholder="Card Number" required/> 
             <input type="text" id="input-field" name="expiryDate" placeholder="MM/YY" required/> 
             <input type="number" id="input-field" name="cvv" placeholder="CVV" required/> 
             <input type="text" id="input-field" name="nameOnCard" placeholder="Name on Card" required/> 
             
             <input type="submit" value="Pay">
        </form>
       
             <p><a class= "button" style="center" href="Payment1_OrderCart.jsp">Cancel</a></p>
                
        </div>
       
    </body>
</html>

