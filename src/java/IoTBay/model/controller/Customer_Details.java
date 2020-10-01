package IoTBay.model.controller;

import IoTBay.mvp.model.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import IoTBay.model.dao.DBManager;
import IoTBay.model.dao.DBConnector;


/**
 *
 * @author ASUS
 */
@WebServlet(name = "Customer_Details", urlPatterns = {"/Customer_Details"})
public class Customer_Details extends HttpServlet 
    {
    private DBConnector Connector;
    private DBManager Query;
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    protected Customer current;//add new Customer class here
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();//request session
        String stringid = request.getParameter("ID");//String get id
        int id = Integer.parseInt(stringid);//to int
        String username = request.getParameter("USERNAME");//get username
       
        try
        {
            Connector = new DBConnector();// open connector
            Query = new DBManager(Connector.openConnection());  //open connection
        }catch (ClassNotFoundException | SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        try
        {
        current = Query.findCustomer(id,username);//run query
        Connector.closeConnection();//close connection
        session.setAttribute("Firstname", current.getFirstname());//set attribute Firstname
        session.setAttribute("Lastname", current.getLastname());//set attribute Lastname
        session.setAttribute("Email", current.getEmail());//set attribute Email
        session.setAttribute("Address", current.getAddress());//set attribute Username
        session.setAttribute("ID", current.getId());//set attribute ID
        session.setAttribute("Username", current.getUsername());//set attribute Username
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Delete_Customer_Servlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("customer_details.jsp"); //redirect to customer_details.jsp pagae
    }
}
