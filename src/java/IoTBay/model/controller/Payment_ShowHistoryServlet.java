/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Payment_ShowHistoryServlet extends HttpServlet {
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession();
       Integer userId = Integer.parseInt(request.getParameter("userId")); 
       DBManager manager = ( DBManager) session.getAttribute("manager");
       String username = ( String) session.getAttribute("username");
           
       if(username != null){
           ArrayList<String> temp = new ArrayList();
           try {
               System.out.println(userId);
               temp = manager.fetchPayment(userId);
           } catch (SQLException ex) {
               Logger.getLogger(Payment_ShowHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
                if(temp != null){
                    session.setAttribute("paymentList", temp);
                }  else {
                    session.setAttribute("fetchMessage", "There is no record in database");
                }
                response.sendRedirect("Payment_UserHistory.jsp");
           
       } else {
            request.getRequestDispatcher("Payment_AnonHistory.jsp").include(request, response);
       }
    }  
}
