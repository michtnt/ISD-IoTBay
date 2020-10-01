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
import IoTBay.mvp.model.Admin;
import IoTBay.mvp.model.Staff;
import IoTBay.model.dao.DBManager;
import java.util.ArrayList;

// capture posted data from admin_login.jsp
// validate login credentials using Validator class
public class LoginServlet extends HttpServlet {
    
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
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                
                // Database
                //DBManager manager = (DBManager) session.getAttribute("manager");
                Admin admin = null;
                
                // Validator
                Validator validator = new Validator();
                validator.clear(session);
                
                // initialise back to null
                session.setAttribute("usernameErr", null);
                session.setAttribute("passErr", null);
                session.setAttribute("existErr", null);

                if(!validator.validateName(username)){
                    session.setAttribute("usernameErr", "Error: Username format is incorrect!");
                    request.getRequestDispatcher("admin_login.jsp").include(request, response);
                } 
                if(!validator.validatePassword(password)){
                    session.setAttribute("passErr,", "Error: Password format is incorrect!");
                    request.getRequestDispatcher("admin_login.jsp").include(request, response);
                } else {
                    try {
                        admin = manager.findAdmin(username, password);
                        if(admin != null){
                            
                            // fetch staff list if the admin is logged in 
                            ArrayList<Staff> temp = new ArrayList();
                            temp = manager.fetchStaffs();
                            if(temp != null){
                                session.setAttribute("staffList", temp);
                            } else {
                                session.setAttribute("fetchMessage", "There is no record yet");
                            }
                            
                            session.setAttribute("admin", admin);                            
                            request.getRequestDispatcher("admin_home.jsp").include(request, response);
                            System.out.println("Redirect to option portal");
                            response.sendRedirect("admin_or_customer.jsp");
                        } else {
                            session.setAttribute("existErr", "Error: Admin does not exist in database");
                            request.getRequestDispatcher("admin_login.jsp").include(request, response);
                        }
                    } catch (SQLException | NullPointerException ex) {
                        System.out.println(ex.getMessage() == null ? "Admin does not exist" : "Welcome");
                    }
                }
         }  
 }
