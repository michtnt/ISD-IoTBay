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
public class OrderLineServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderLineDBManager manager = (OrderLineDBManager) session.getAttribute("orderLineManager");
        OrderDBManager orderManager = (OrderDBManager) session.getAttribute("orderManager");
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        try {
            ArrayList<OrderLine> orderLines = manager.fetchOrders(orderID);
            session.setAttribute("orderLines", orderLines);
            Orders order = orderManager.findOrder(orderID, userID);
            double totalPrice = 0;
            for (OrderLine orderLine : orderLines) {
                totalPrice = totalPrice + orderLine.getTotalPrice();
            }
            double tax = totalPrice/10;
            order.setTotalPrice(totalPrice);
            order.setTax(tax);
            session.setAttribute("order", order);
            request.getRequestDispatcher("cart.jsp").include(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderLineServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
