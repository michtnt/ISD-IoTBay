/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import IoTBay.model.dao.*;

/**
 *
 * @author misel
 */

// create a database connection
// share a database manager
// close a database connection 
public class ConnServlet extends HttpServlet {
    private DBConnector db;
    private DBManager manager;
    private OrderDBManager orderManager;
    private OrderLineDBManager orderLineManager;
    private Connection conn;
    
    //Create and instance of DBConnector for the deployment session
    @Override 
    public void init() {
        try {
            // create a database connection when the application starts
            db = new DBConnector(); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    //Add the DBConnector, DBManager, Connection instances to the session
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
        HttpSession session = request.getSession();
        // create a DB connection
        conn = db.openConnection(); 
        try {
            // create a DB Manager
            manager = new DBManager(conn); 
            orderManager = new OrderDBManager(conn);
            orderLineManager = new OrderLineDBManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //export the DB manager to the view-session (JSPs)
        session.setAttribute("manager", manager);      
        session.setAttribute("orderManager", orderManager);  
        session.setAttribute("orderLineManager", orderLineManager);
    }   

     //Destroy the servlet and release the resources of the application (terminate also the db connection)
    @Override
     public void destroy() {
        try {
            // close DB connection when session is terminated
            db.closeConnection(); 
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}