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
public class UserCartServlet extends HttpServlet {

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        int productID = Integer.parseInt(request.getParameter("productID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        String productName = request.getParameter("productName");
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        double price =  Double.parseDouble(request.getParameter("price"));
        OrderLineDBManager manager = (OrderLineDBManager) session.getAttribute("orderLineManager");
        OrderDBManager orderManager = (OrderDBManager) session.getAttribute("orderManager");
        OrderLine orderLine = new OrderLine();
        
        
          
        try {
            orderLine = manager.findOrderLine(orderID, productID);
            if (orderLine == null) {
                orderLine = new OrderLine(orderID, 1, productID, productName, price);
                int orderLineID = orderLine.getOrderlineID();
                manager.addOrderLine(orderLineID,orderID,1,productID,productName, price, price);
                Orders order = orderManager.findOrder(orderID, userID);
                order.updatePrice(price, 1);
                request.getRequestDispatcher("product.jsp").include(request, response);
            }
            else {
                int orderLineID = orderLine.getOrderlineID();
                orderLine.upQuantity();
                manager.updateOrder(orderLineID, orderID, orderLine.getQuantity(), productID, productName, orderLine.getTotalPrice(), price);
                Orders order = orderManager.findOrder(orderID, userID);
                order.updatePrice(price, orderLine.getQuantity());
                request.getRequestDispatcher("Welcome.jsp").include(request, response);
            }
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
           
        
        
        }

}
