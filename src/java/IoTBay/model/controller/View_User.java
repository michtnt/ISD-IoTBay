/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IoTBay.model.dao.DBConnector;
import IoTBay.model.dao.DBManager;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "View_User", urlPatterns = {"/View_User"})
public class View_User extends HttpServlet {  
    private DBConnector Connector;
    private DBManager Query;
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    private LinkedList list;
    //set LinkedList to hold all data
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();// get session
        String SEARCH = request.getParameter("SEARCH");//get parameter search
        
        try
        {
            Connector = new DBConnector();//open new connector
            Query = new DBManager(Connector.openConnection());//open new connection  
        }catch (ClassNotFoundException | SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {
        Query.listCustomer(SEARCH);//run query
        list = Query.get_data();//list all data from DBManager function
        Connector.closeConnection();//close connection
        session.setAttribute("List", Query.get_data());//set attribute to be redirected
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Delete_Customer_Servlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("list_customer.jsp");//redirect to list_customer.jsp page
    }

}
