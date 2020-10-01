/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.model.dao.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
public class SearchItemServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

        session.setAttribute("product", null);
        session.setAttribute("found", null);
        
        String productname = request.getParameter("productname");
        
        try {
            boolean check = manager.checkItem(productname);
            if (check) {
                Product product = manager.fetchItem(productname);
                session.setAttribute("product", product);

                request.getRequestDispatcher("inventory_searchItem.jsp").include(request, response);
                response.sendRedirect("inventory_searchResult.jsp");
            } 
            else {
                request.getRequestDispatcher("inventory_searchItem.jsp").include(request, response);
                session.setAttribute("found", "Item does NOT exist in the Inventory");                
                response.sendRedirect("inventory_searchItem.jsp");
            }
                            
        } catch (SQLException ex){
            Logger.getLogger(SearchItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
