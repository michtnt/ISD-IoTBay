package IoTBay.model.controller;

import IoTBay.model.dao.DBManager;
import IoTBay.model.dao.DBConnector;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Delete_Customer_Servlet", urlPatterns = {"/Delete_Customer_Servlet"})
public class Delete_Customer_Servlet extends HttpServlet 
{
    private DBConnector Connector;
    private DBManager Query;
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ID = request.getParameter("ID");//take String ID
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            Connector = new DBConnector();//new connector
            Query = new DBManager(Connector.openConnection());  //open connection
        }catch (ClassNotFoundException | SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        try
        {
        Query.deleteUser(ID);//run query
        Connector.closeConnection();//close connection
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Delete_Customer_Servlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("index.html");//redirect to index.html page
    }
}
