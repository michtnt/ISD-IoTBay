package IoTBay.model.controller;

 

import IoTBay.model.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 

public class UpdateItemServlet extends HttpServlet {
    
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
            java.util.logging.Logger.getLogger(SearchItemServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        //catch exceptions for the DBManager
        try
        {       
            manager = new DBManager(Connector.openConnection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(SearchItemServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        //retrieve inputted values from the user
        String oldproductname = request.getParameter("oldproductname");
        String productname = request.getParameter("productname");
        String brand = request.getParameter("brand");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer stock = Integer.parseInt(request.getParameter("stock"));
        String description = request.getParameter("description");
        String oldProductname = request.getParameter("oldProductname");
        
        
        //database
        session.setAttribute("product", null);
        session.setAttribute("updated", null);
        
        try{
            Boolean exists = manager.checkItem(oldproductname); //check if item exists in the Inventory
            if (exists) {
                manager.updateItem(manager.fetchProductid(oldproductname), productname, brand, price, stock, description);//update the item
                session.setAttribute("updated", "Item has now been updated"); //success message (no error message)

 

                request.getRequestDispatcher("inventory_updateItem.jsp").include(request, response); //request coming from updateItem.jsp
                response.sendRedirect("inventory_updateItem.jsp");//user is redirected back to this page with the success
            }
            else {
                session.setAttribute("updated", "Item has NOT been updated");//error message if item is not found in the Inventory
                request.getRequestDispatcher("inventory_updateItem.jsp").include(request, response);//request is from updateItem.jsp
                response.sendRedirect("inventory_updateItem.jsp");//user is redirected back to the page with the error message displayed
            }  
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());//SQL error is printed should an error occur
        }
    }
}