/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.mvp.model.Payment_User;
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
public class Payment1_CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Session
         HttpSession session = request.getSession();
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         Payment_User user = new Payment_User( username, password );
         DBManager manager = (DBManager) session.getAttribute("manager");
        
         try {
             if(user != null){
                 session.setAttribute("user", user);
                 manager.paymentaddUser(username, password);
                 Integer userId = manager.getUserId(username, password);
                 session.setAttribute("userId", userId);
                 session.setAttribute("username", username);
                 session.setAttribute("password", password);
                 request.getRequestDispatcher("Payment1_Order.jsp").include(request, response);
                 response.sendRedirect("Payment1_Order.jsp");
             } else {
                 request.getRequestDispatcher("Payment1_Register.jsp").include(request, response);
             }
         } catch ( SQLException ex){
                 Logger.getLogger(Payment_EditServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}