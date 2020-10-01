/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.mvp.model.Orders;
import IoTBay.model.dao.OrderDBManager;
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
 * @author tayla
 */
public class ShippingServlet extends HttpServlet {

    

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        double totalPrice = (double)session.getAttribute("totalPrice");
        double tax = (double)session.getAttribute("tax");
        OrderDBManager orderManager = (OrderDBManager)session.getAttribute("orderManager");
        try {
            Orders order = orderManager.findOrder(orderID, userID);
            orderManager.updateOrder(orderID, userID, null, tax, totalPrice, null, null);
            request.getRequestDispatcher("shipping.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShippingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
