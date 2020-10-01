package IoTBay.model.controller;

 

import IoTBay.model.dao.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import IoTBay.mvp.model.Product;

 


public class AddNewItemServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    @Override //Create and instance of DBConnector for the deployment session
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
        
        //collected parameters from the AddNewItem.jsp
        String productname = request.getParameter("productname");
        String brand = request.getParameter("brand");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer stock = Integer.parseInt(request.getParameter("stock"));
        String description = request.getParameter("description");
    
    try {
        if (productname != null) {
            manager.addNewItem(productname, brand, price, stock, description); //call addNewItem and use the inputted values from admin user method in manager
            session.setAttribute("added", "Item has been added to Inventory"); //set the attribute as successful (no error message)

 

            request.getRequestDispatcher("inventory_addNewItem.jsp").include(request, response); //request comes from the addNewItem.jsp
            response.sendRedirect("inventory_addNewItem.jsp"); //the user is redirected back to this page with the success message
        } else {
            session.setAttribute("added", "Item has NOT been added to Inventory");//if form is completed incorrectly, display error message
            request.getRequestDispatcher("inventory_addNewItem.jsp").include(request, response); //the user is redirected back to this page to display error message
        }
    
    } catch (SQLException ex){
        Logger.getLogger(AddNewItemServlet.class.getName()).log(Level.SEVERE, null, ex); //if there is an SQL error, it is logged under this Servlet
    }
    
  }
}