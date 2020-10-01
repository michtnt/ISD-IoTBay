/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.model.dao.DBManager;
import IoTBay.mvp.model.Payment_Order;
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
public class Payment1_CreateOrderServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Session
         HttpSession session = request.getSession();
         Double amount = Double.parseDouble(request.getParameter("amount"));
         String username =request.getParameter("username");
         String password =request.getParameter("password");
         
         Payment_Order order = new Payment_Order( amount );
         DBManager manager = (DBManager) session.getAttribute("manager");
        
         try {
             if(order != null){
                 session.setAttribute("order", order);
                 Integer userId = manager.getUserId(username, password);                 
                 session.setAttribute("userId", userId);
                 manager.paymentaddOrder(userId, amount);
                 Integer orderId = manager.getOrderId();
                 session.setAttribute("orderId", orderId);
                 request.getRequestDispatcher("Payment1_OrderCart.jsp").include(request, response);
                 response.sendRedirect("Payment1_OrderCart.jsp");
             } else {
                 session.setAttribute("Not Created", "Creating Payment is not successful!" );
                 request.getRequestDispatcher("Payment1_OrderCart.jsp").include(request, response); 
             }
             
         } catch ( SQLException ex){
                 Logger.getLogger(Payment_EditServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}