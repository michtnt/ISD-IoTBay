/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;
import IoTBay.model.dao.DBConnector;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import IoTBay.mvp.model.Staff;
import IoTBay.model.dao.DBManager;
/**
 *
 * @author Michelle Tanoto
 */

// Servlet to direct to the right user for updating 
public class EditStaffServlet extends HttpServlet {
    
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
        
        // Initialise back to null to make it dynamic
        session.setAttribute("existErr", null);
        
        try{
            staff = manager.findStaff(username);
            // if staff is found, redirect to update staff portal
            if(staff != null){
                session.setAttribute("staff", staff);
                session.setAttribute("oldUsername", username);
                request.getRequestDispatcher("admin_update_staff.jsp").include(request, response);
                System.out.println("Redirect to Update Staff Portal");
                response.sendRedirect("admin_update_staff.jsp");
                
            // if not found then display feedback
            } else {
                session.setAttribute("existErr", "Staff does not exist in database");
                request.getRequestDispatcher("admin_home.jsp").include(request, response);
            }
            
        } catch (SQLException ex) {
           System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }  
}
