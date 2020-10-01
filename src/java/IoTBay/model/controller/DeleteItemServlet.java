/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

 

import IoTBay.model.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import IoTBay.mvp.model.Product;

 

public class DeleteItemServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

 

        //catch exceptions for the DBConnector
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(AddNewItemServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //catch exceptions for the DBManager
        try
        {       
            manager = new DBManager(Connector.openConnection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(AddNewItemServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        //retrieve the product name that was searched for by the user
        String oldproductname = request.getParameter("oldproductname");
        
        try {
            Boolean exists = manager.checkItem(oldproductname); //check if this item exists in the Inventory
            if (exists) { //if it does...
                manager.deleteItem(oldproductname); //call the delete function - it is removed from Inventory
                session.setAttribute("deleted", "Product has been deleted."); //success message (no error message)
                request.getRequestDispatcher("inventory_deleteItem.jsp").include(request, response); //request comes from deleteitem.jsp
                response.sendRedirect("inventory_deleteConfirmation.jsp");//the user is taken to the delete confirmation page upon successful deletion
            }
            else {
                session.setAttribute("deleted", "Product has NOT been deleted."); //error message if product does not exist in Inventory
                request.getRequestDispatcher("inventory_deleteItem.jsp").include(request, response); //request comes from deleteItem.jsp
            }
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage()); //error is stored as DeleteItemServlet should SQL error occur
        }
    }
}