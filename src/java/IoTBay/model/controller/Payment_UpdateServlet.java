/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.mvp.model.Payment;
import IoTBay.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desyliunardi
 */

// Update the payment in databse 
public class Payment_UpdateServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         String paymentMethod = request.getParameter("paymentMethod");
         Integer cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
         Integer cvv = Integer.parseInt(request.getParameter("cvv"));
         String nameOnCard = request.getParameter("nameOnCard");
         String expiryDate = request.getParameter("expiryDate");
         String datePaid = request.getParameter("datePaid");    

         Payment payment = new Payment(paymentMethod, cardNumber, cvv, nameOnCard, expiryDate, datePaid);
         DBManager manager = (DBManager) session.getAttribute("manager");

         try{
             if(payment != null){
                 session.setAttribute("payment", payment);
                 manager.updatePayment(manager.getPaymentId(), paymentMethod, cardNumber, cvv, nameOnCard, expiryDate, datePaid);
                 request.getRequestDispatcher("Payment_Update.jsp").include(request, response);
                 response.sendRedirect("Payment_Confirm.jsp");
                 
             } else {
                 request.getRequestDispatcher("Payment_Update.jsp").include(request, response);
             }
         } catch ( SQLException ex){
             Logger.getLogger(Payment_EditServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
