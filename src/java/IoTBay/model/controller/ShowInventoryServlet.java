/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.model.dao.*;
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
import IoTBay.mvp.model.Product;

/**
 *
 * @author rebeccagalletta
 */
public class ShowInventoryServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(SearchItemServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(Connector.openConnection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(SearchItemServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        try {
            ArrayList<Product> inventory = manager.showInventory();
            if (inventory != null) {
                session.setAttribute("inventory", inventory);
                request.getRequestDispatcher("inventory_showInventory.jsp").include(request, response);
                session.setAttribute("show", "IoTBayInventory");
                response.sendRedirect("inventory_showInventory.jsp");
            }
            else{
                request.getRequestDispatcher("inventory_showInventory.jsp").include(request, response);
                session.setAttribute("show", "Inventory does not exist");
                response.sendRedirect("inventory_manageInventory.jsp");
            }
            
                            
        } catch (SQLException ex){
            Logger.getLogger(ShowInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
