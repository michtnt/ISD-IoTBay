package IoTBay.model.controller;
import IoTBay.model.controller.checkLogin;
import IoTBay.model.controller.userController;
import IoTBay.mvp.model.User;
import java.sql.*;
import java.util.logging.*;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IoTBay.model.dao.DBConnector;
import IoTBay.model.dao.DBManager;
import IoTBay.mvp.model.Timestampbean;
import IoTBay.mvp.model.accessLogs;
import java.util.Iterator;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

 

public class updateController  extends HttpServlet {
     //private static final long serialVersionUID = 1L;
private DBConnector connector; 
private Connection conn;
private DBManager db;
public updateController(){
}

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException { 
            
            try {
                connector = new DBConnector();
                conn = connector.openConnection();  
             db = new DBManager(conn);
             checkLogin Cherker = new checkLogin(); 
             User user = Cherker.getInstanceUser(); 
             String id = user.getUserId(); 
        if (request.getParameter("email") != null) {
            email(request,response,id);
        } else if (request.getParameter("firstName") != null) {
            firstName(request,response, id);
        } else if (request.getParameter("lastName") != null) {
            lastName(request,response, id);
        } else if (request.getParameter("password") != null) {
            password(request,response, id);
        } else if (request.getParameter("username") != null) {
            username(request,response, id);
        } else if (request.getParameter("address") != null) {
            address(request,response, id);
        } else if (request.getParameter("delete") != null) {
            delete(request,response, id);
        } else if (request.getParameter("done") != null) {
            done(request,response);
        } else {
         
        }
             
    } catch (SQLException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
    }
            checkLogin Cherker = new checkLogin(); 
            User user = Cherker.getInstanceUser(); 
            String search = user.getUserId(); 
  
    }
    
     private void email(HttpServletRequest request, HttpServletResponse response, String id) throws SQLException, IOException {
     String regiEmail = request.getParameter("regiEmail");
     checkLogin Cherker = new checkLogin(); 
     User user = Cherker.getInstanceUser(); 
     user.setEmail(regiEmail);
     db.updateEmail(regiEmail, id);
     response.sendRedirect("userUpdate.jsp");
     }
     private void firstName(HttpServletRequest request, HttpServletResponse response, String id) throws SQLException, IOException {
     String regiFirstname = request.getParameter("regiFirstName");
     checkLogin Cherker = new checkLogin(); 
     User user = Cherker.getInstanceUser(); 
     user.setFirstName(regiFirstname);
     db.updateFName(regiFirstname, id);
     response.sendRedirect("userUpdate.jsp");
     }
     private void lastName(HttpServletRequest request, HttpServletResponse response, String id) throws SQLException, IOException {
     String regiLastname = request.getParameter("regiLastName");
     checkLogin Cherker = new checkLogin(); 
     User user = Cherker.getInstanceUser(); 
     user.setLastName(regiLastname);
     db.updateLName(regiLastname, id);
     response.sendRedirect("userUpdate.jsp");
     }
     private void password(HttpServletRequest request, HttpServletResponse response, String id) throws SQLException, IOException {
     String regiPassword = request.getParameter("regiPassword");
     checkLogin Cherker = new checkLogin(); 
     User user = Cherker.getInstanceUser(); 
     user.setPassword(regiPassword);
     db.updatePassword(regiPassword, id);
     response.sendRedirect("userUpdate.jsp");
     }
     private void username(HttpServletRequest request, HttpServletResponse response, String id) throws SQLException, IOException {
     String regiUsername = request.getParameter("regiUsername");
     checkLogin Cherker = new checkLogin(); 
     User user = Cherker.getInstanceUser(); 
     user.setUsername(regiUsername);
     db.updateUsername(regiUsername, id);
     response.sendRedirect("userUpdate.jsp");
     }
     private void address(HttpServletRequest request, HttpServletResponse response, String id) throws SQLException, IOException {
     String regiAddress = request.getParameter("regiAddress");
     checkLogin Cherker = new checkLogin(); 
     User user = Cherker.getInstanceUser(); 
     user.setAddress(regiAddress);
     db.updateAddress(regiAddress, id);
     response.sendRedirect("userUpdate.jsp");
     }
     public void searchLog(String id, HttpServletRequest request, HttpServletResponse response) throws SQLException {
         String work; 
         HttpSession session = request.getSession();
     LinkedList<String> logs;
          logs = db.findLog(id);
          session.setAttribute("logs", logs);
     }
     private void delete(HttpServletRequest request, HttpServletResponse response, String id) throws SQLException, IOException {
     db.deleteUserBM(id);
     response.sendRedirect("index.html");
     }
     private void done(HttpServletRequest request, HttpServletResponse response) throws IOException {
     response.sendRedirect("Welcome.jsp");
     }
     private static final accessLogs logBean = new accessLogs();
     
   
   
     
     public static accessLogs getInstanceUser() { 
      return logBean;
  }
     
  
}
               



