/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.mvp.model.Orders;
import IoTBay.model.dao.OrderDBManager;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
public class FinishOrderServlet extends HttpServlet {

    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        OrderDBManager orderManager = (OrderDBManager)session.getAttribute("orderManager");
        String billingAddress = request.getParameter("billingAddress");
        String shippingAddress = request.getParameter("shippingAddress");
        try {
            Orders order = orderManager.findOrder(orderID, userID);
            order.setShippingAddress(shippingAddress);
            order.setBillingAddress(billingAddress);
            

            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

            order.setOrderDate(date);
            orderManager.updateOrder(orderID, userID, date, order.getTax(), order.getTotalPrice(), shippingAddress, billingAddress);
            session.setAttribute("order", order);
            request.getRequestDispatcher("finalOrder.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FinishOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
