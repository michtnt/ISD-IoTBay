/**
 *
 * @author Michael
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
import IoTBay.model.dao.*;


@WebServlet(name = "Update_Customer_Servlet", urlPatterns = {"/Update_Customer_Servlet"})
public class Update_Customer_Servlet extends HttpServlet 
{
    private DBConnector Connector;
    private DBManager Query;
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ID = request.getParameter("ID");
        String USERNAME = request.getParameter("USERNAME");
        String FNAME = request.getParameter("FNAME");
        String LNAME = request.getParameter("LNAME");
        String ADDRESS = request.getParameter("ADDRESS");
        String EMAIL = request.getParameter("EMAIL");
        //take all parameter needed here
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            Connector = new DBConnector();//set new connector
            Query = new DBManager(Connector.openConnection());//open connection
        }catch (ClassNotFoundException | SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        try
        {
        Query.updateUser(ID,USERNAME,FNAME,LNAME,ADDRESS,EMAIL);//run query
        Connector.closeConnection();//close connection
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Delete_Customer_Servlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("index.html");//redirect to html
    }
}
