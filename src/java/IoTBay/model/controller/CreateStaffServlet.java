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
 * @author misel
 */
// to create new staff
public class CreateStaffServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
//        connector = new DBConnector();
//        conn = connector.openConnection();
//        db = new DBManager(conn);
        
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
         String firstName = request.getParameter("firstName");
         String lastName = request.getParameter("lastName");
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String email = request.getParameter("email");
         String address = request.getParameter("address");
         String position = request.getParameter("position");  
         Boolean active = Boolean.parseBoolean(request.getParameter("active"));
         
//         System.out.println(firstName);
//             System.out.println(lastName);
//             System.out.println(email);
//             System.out.println(address);
//             System.out.println(username);
//             System.out.println(password);
//             System.out.println(position);

 

         
         // Database 
         Staff staff = new Staff(firstName, lastName, email, address, username, password, position, active);
         //DBManager manager = (DBManager) session.getAttribute("manager");
         
         // initialise back to null in case it shows up again
         session.setAttribute("fetchMessage", null);
         session.setAttribute("searchMessage", null);
         session.setAttribute("deleteMessage", null);
         session.setAttribute("created", null);
         session.setAttribute("searchStaff", null);
         
         try {
             if(staff != null){
                 session.setAttribute("staff", staff);
                 manager.addStaff(firstName, lastName, email, address, username, password, position);
                 
                // fetch UPDATED staff list to show at main page
                ArrayList<Staff> temp = new ArrayList();
                temp = manager.fetchStaffs();
                if(temp != null){
                    session.setAttribute("staffList", temp);
                } else {
                    session.setAttribute("fetchMessage", "There is no record yet");
                }
                  
                 // send redirect to home
                 System.out.println("Redirect to admin home portal.");
                 response.sendRedirect("admin_home.jsp");
             } else {
                 // stay at admin_create_staff and display feedback
                 session.setAttribute("created", "Creating staff is not successful!" );
                 request.getRequestDispatcher("admin_create_staff.jsp").include(request, response);
             }
         } catch ( SQLException ex){
             Logger.getLogger(CreateStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
             
         }
         
         
    }
}