package IoTBay.model.controller;
import java.sql.*;
import java.util.logging.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IoTBay.model.dao.DBConnector;
import IoTBay.model.dao.DBManager;
 

public class userController  extends HttpServlet {
     //private static final long serialVersionUID = 1L;
private DBConnector connector; 
private Connection conn;
private DBManager db;
 /*public void init() {
 (new userController()).doGet();
 } */
/*public void init(){
         try {
             db = new DBManager(conn);
         } catch (SQLException ex) {
             Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
         }
} */
public userController(){
}

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException { 
            
            try {
              connector = new DBConnector();
              conn = connector.openConnection();  
              db = new DBManager(conn);
              String regiEmail = request.getParameter("email");
              System.out.println(regiEmail);
              boolean emailFalse = db.checkEmail(regiEmail); 
              if (emailFalse != true){
                insert(request,response);
                response.sendRedirect("homePage.jsp"); }
              else {
                 response.sendRedirect("Failregister.jsp");
    }
       
    } catch (SQLException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
    
   private void insert(HttpServletRequest request, HttpServletResponse response) 
       throws SQLException, IOException {
        String regiEmail = request.getParameter("email");
        String regiFirstName = request.getParameter("firstName");
        String regiLastName = request.getParameter("lastName");
        String regiPassword = request.getParameter("password");
        String regiUsername= request.getParameter("username");
        String regiAddress= request.getParameter("address");
        String id = db.userIdinc();
        boolean userActive = true; 
        if (id == null)
        id = "2"; 
        db.addUser(regiUsername, regiFirstName, regiLastName,regiAddress, regiEmail, regiPassword, id, userActive);
        
        connector.closeConnection();
   
   
   }  
}
               



