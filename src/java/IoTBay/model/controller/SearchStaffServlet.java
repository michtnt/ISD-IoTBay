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

// Servlet to Search Staff
public class SearchStaffServlet  extends HttpServlet {
    
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
        
        // Session
        HttpSession session = request.getSession();
        String username = request.getParameter("search_username");
        String position = request.getParameter("search_position");
        
        // Database
        //DBManager manager = ( DBManager) session.getAttribute("manager");
        Staff staff = null;
        
        // Initialise back to null to make it dynamic
        session.setAttribute("searchMessage", null);
        session.setAttribute("searchStaff", null );
        session.setAttribute("fetchMessage", null);
        session.setAttribute("deleteMessage", null);
         
        try{
             staff = manager.searchStaff(username, position);
             // if staff object is found display search resut
            if(staff != null){
                session.setAttribute("searchStaff", staff );
                request.getRequestDispatcher("admin_home.jsp").include(request, response);
            
            // if not, display feedback
            } else {
                session.setAttribute("searchMessage", "Staff not found");
                request.getRequestDispatcher("admin_home.jsp").include(request, response);
            }
            
        } catch (SQLException ex) {
           System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        // redirect to admin_home.jsp
        response.sendRedirect("admin_home.jsp");
    }  
}