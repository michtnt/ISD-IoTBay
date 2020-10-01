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
import java.util.ArrayList;

/**
 *
 * @author Michelle Tanoto
 */

// Servlet to update the staff details
public class UpdateStaffServlet extends HttpServlet {
    
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
        
        HttpSession session = request.getSession();
        
         // Session
         String firstName = request.getParameter("firstName");
         String lastName = request.getParameter("lastName");
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String email = request.getParameter("email");
         String address = request.getParameter("address");
         String position = request.getParameter("position");    
         String oldUsername = request.getParameter("oldUsername");
         Boolean active = Boolean.parseBoolean(request.getParameter("active"));
         
         // Database
         Staff staff = new Staff(firstName, lastName, email, address, username, password, position, active);
         //DBManager manager = (DBManager) session.getAttribute("manager");
         
         // Initialise back to null in case it shows up again
         session.setAttribute("fetchMessage", null);
         session.setAttribute("updated", null);
         session.setAttribute("searchMessage", null);
         session.setAttribute("deleteMessage", null);
         session.setAttribute("searchStaff", null);
         

         try{
             
             // if staff object is found
             if(staff != null){
                 session.setAttribute("staff", staff);
                 manager.updateStaff(firstName, lastName, email, address, username, password, position, oldUsername, active);
                 
                // fetch the UPDATED staff list after updating
                ArrayList<Staff> temp = new ArrayList();
                temp = manager.fetchStaffs();
                if(temp != null){
                    session.setAttribute("staffList", temp);
                } else {
                    session.setAttribute("fetchMessage", "There is no record yet");
                }
                
                // redirect to admin home portal
                 request.getRequestDispatcher("admin_update_staff.jsp").include(request, response);
                 System.out.println("Redirect to admin home portal");
                 response.sendRedirect("admin_home.jsp");
                 
             } else {
                 // stay in page and display feedback
                 session.setAttribute("updated", "Update was not successful!" );
                 request.getRequestDispatcher("admin_update_staff.jsp").include(request, response);
             }
         } catch ( SQLException ex){
             Logger.getLogger(EditStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
