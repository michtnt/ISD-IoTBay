/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.mvp.model.OrderLine;
import IoTBay.mvp.model.Orders;
import IoTBay.model.dao.OrderDBManager;
import IoTBay.model.dao.OrderLineDBManager;
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
 * This servlet creates the orderID for the session
 */
public class OrderServlet extends HttpServlet{
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(session.getAttribute("userID").toString()); // Get the userID
        
        OrderDBManager manager = (OrderDBManager) session.getAttribute("orderManager");
        Orders order = new Orders(userID); //Use the userID to create a unique orderID
        int orderID = order.getOrderID();
        try {
            manager.addOrder(orderID, userID);
        } 
        catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("orderID", orderID);
        request.getRequestDispatcher("product.jsp").include(request, response);
        
    }

}