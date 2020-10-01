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
 */
public class QuantityDown extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderLineID = Integer.parseInt(request.getParameter("orderLineID"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        OrderLineDBManager manager = (OrderLineDBManager) session.getAttribute("orderLineManager");
        OrderDBManager orderManager = (OrderDBManager) session.getAttribute("orderManager");
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        try {
            OrderLine orderLine = manager.findOrderLine(orderID, productID);
            int quant = orderLine.downQuantity();
            if (quant > 0) {
                orderLine.setTotalPrice();
                manager.updateOrder(orderLineID, orderLine.getOrderID(), orderLine.getQuantity(), productID, orderLine.getProductName(), orderLine.getTotalPrice(), orderLine.getPrice());
                Orders order = orderManager.findOrder(orderID, userID);
                order.updatePrice(orderLine.getPrice(), orderLine.getQuantity());
                request.getRequestDispatcher("OrderLineServlet").include(request, response);
            } else {
                manager.deleteOrder(orderLineID);
                Orders order = orderManager.findOrder(orderID, userID);
                order.deleteOrderLine(orderLine.getTotalPrice());
                request.getRequestDispatcher("OrderLineServlet").include(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuantityUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
