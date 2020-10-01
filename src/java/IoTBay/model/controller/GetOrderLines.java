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
 * @author tayla
 */
public class GetOrderLines extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(request.getParameter("searchOrderID"));
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        OrderDBManager orderManager = (OrderDBManager)session.getAttribute("orderManager");
        OrderLineDBManager manager = (OrderLineDBManager)session.getAttribute("orderLineManager");
        Orders order;
        
        try {
            order = orderManager.findOrder(orderID, userID);
            request.setAttribute("order", order);
            ArrayList<OrderLine> orderLines = manager.fetchOrders(orderID);
            request.setAttribute("orderLines", orderLines);
            request.getRequestDispatcher("searchOrderID.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GetOrderLines.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

}
