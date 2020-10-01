/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.model.dao.DBConnector;
import IoTBay.model.dao.DBManager;
import IoTBay.mvp.model.Staff;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michelle Tanoto
 */

// Servlet to delete staff 
public class DeleteStaffServlet extends HttpServlet {
    
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
        
        // Session 
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        
        // Database
        //DBManager manager = ( DBManager) session.getAttribute("manager");
        Staff staff = null;
        
        // initialise back to null
        session.setAttribute("fetchMessage", null);      
        session.setAttribute("deleteMessage", null);
        session.setAttribute("searchMessage", null);
        session.setAttribute("searchStaff", null);         

        try{
            // Find the staff in database
            staff = manager.findStaff(username);
            
            // If staff is found
            if(staff != null){
                // Delete it from database
                manager.deleteStaff(username);
                session.setAttribute("deleteMessage", "Staff is deleted successfully!");

                // Fetch the UPDATED staff list after deletion
                ArrayList<Staff> temp = new ArrayList();
                temp = manager.fetchStaffs();
                
                // If staff list is not empty display it, if it's empty show message "there is no record yet"
                if(temp != null){
                    session.setAttribute("staffList", temp);
                } else {
                    session.setAttribute("fetchMessage", "There is no record yet");
                }

                request.getRequestDispatcher("admin_home.jsp").include(request, response);
            
            // if it is not successful then display feedback
            } else {
                session.setAttribute("deleteMessage", "Staff is not deleted!");
                request.getRequestDispatcher("admin_home.jsp").include(request, response);
            }
            
            // redirect to home after servlet finish its task
            System.out.println("Redirect to admin home portal");
            response.sendRedirect("admin_home.jsp");
            
        } catch (SQLException ex) {
           System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }  
}
