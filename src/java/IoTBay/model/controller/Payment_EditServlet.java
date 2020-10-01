package IoTBay.model.controller;


import IoTBay.mvp.model.Payment;
import IoTBay.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author desyliunardi
 */
public class Payment_EditServlet extends HttpServlet {
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // session 
        HttpSession session = request.getSession();
        Integer paymentId = Integer.parseInt(request.getParameter("paymentId"));
        DBManager manager = ( DBManager) session.getAttribute("manager");
        
        Payment payment = null;
        try{
            //find the paymnetId to edit the details
            payment = manager.foundedPaymentId(paymentId);
            System.out.println(paymentId);
            if(payment != null){
                session.setAttribute("payment", payment);
                request.getRequestDispatcher("Payment_Confirm.jsp").include(request, response);
                response.sendRedirect("Payment_Update.jsp");
            } else {
                session.setAttribute("existErr", "Payment does not exist in database");
                request.getRequestDispatcher("Payment_Update.jsp").include(request, response);
            }
        } catch (SQLException ex) {
           System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }  
}
