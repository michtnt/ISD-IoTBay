/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import IoTBay.mvp.model.Payment_User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import IoTBay.model.dao.DBManager;


public class Payment1_LoginServlet extends HttpServlet {
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {       
                
                // Session 
                HttpSession session = request.getSession();
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                
                // Database
                DBManager manager = (DBManager) session.getAttribute("manager");
                Payment_User user = null;
                
                // Validator
                Payment1_Validator validator = new Payment1_Validator();
                validator.clear(session);
                
                // initialise back to null
                session.setAttribute("usernameErr", null);
                session.setAttribute("passErr", null);
                session.setAttribute("existErr", null);
                
                    try {
                        user = manager.paymentfindUser(username, password);
                        if (username == null && password == null) {
                            response.sendRedirect("Payment1_Order.jsp");
                        }
                        if(user != null){
                            session.setAttribute("user", user);        
                            session.setAttribute("username", username);      
                            session.setAttribute("password", password); 
                            response.sendRedirect("Payment1_Order.jsp");
                           
                        } else {
                            System.out.println("Redirect to portal");
                            session.setAttribute("existErr", "Error: User does not exist in database");
                            request.getRequestDispatcher("Payment1_Login.jsp").include(request, response);
                        }
                    } catch (SQLException | NullPointerException ex) {
                        System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcome");
                    }
                }
         }  

