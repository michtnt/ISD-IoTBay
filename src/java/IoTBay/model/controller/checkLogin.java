package IoTBay.model.controller;

 

 

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import IoTBay.mvp.model.User;
import IoTBay.mvp.model.Timestampbean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IoTBay.model.dao.DBConnector;
import IoTBay.model.dao.DBManager;
import IoTBay.model.dao.OrderDBManager;
import IoTBay.mvp.model.Orders;
import IoTBay.mvp.model.accessLogs;
import java.sql.Timestamp;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

 

 

 

/**
 *
 * @author Bailey
 */
public class checkLogin extends HttpServlet {
private DBConnector connector; 
private Connection conn;
private DBManager db;

 

 

 

//Author Bailey Mendonca 13202357
public checkLogin() {} 
private static final User sessionU = new User(); 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        HttpSession session = request.getSession();        
       try {
                String email= request.getParameter("loginemail"); //gets string
                String password= request.getParameter("loginpass"); //gets login
                connector = new DBConnector();
                conn = connector.openConnection();  
                db = new DBManager(conn); 
                //creates the db connector 
                boolean userTrue = db.checkUser(email, password); //checks the user true
                boolean adminTrue = db.checkAdmin(email, password);  //checks the admin true 
           if(userTrue == true) { //checks to see if  the user is active and adds them to session bean
                
                

                 //makes a login time in the accesslog
                  //gets a user to input into the user session bean
                //below is user session bean

                User user =  db.setUser(email, password); 
                String username = user.getUsername();
                String fname = user.getFirstName(); 
                String lName = user.getLastName(); 
                String address = user.getAddress(); 
                String id = user.getUserId(); 
                session.setAttribute("userID", id);
                session.setAttribute("username", username);
                sessionU.setUsername(username);
                sessionU.setFirstName(fname);
                sessionU.setLastName(lName);
                sessionU.setAddress(address);
                sessionU.setUserId(id);
                sessionU.setEmail(email); 
                sessionU.setPassword(password); 
                session.setAttribute("user", sessionU);
           } else  //checks if admin is true
            if(adminTrue == true)
                 response.sendRedirect("admin_home.jsp"); //takes to admin home
            else //redirects to register if no account
                response.sendRedirect("Register.jsp");    
    } catch (SQLException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);}
       // author Tayla Ward to line 110
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        OrderDBManager manager = (OrderDBManager) session.getAttribute("orderManager");
        Orders order = new Orders(userID);
        int orderID = order.getOrderID();
        try {
            System.out.println(orderID);
            System.out.println(userID);
            manager.addOrder(orderID, userID);
        } 
        catch (SQLException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("userID", userID);
        session.setAttribute("orderID", orderID);
        request.getRequestDispatcher("Welcome.jsp").include(request, response);  
    
             
} //saves the login time as a bean
    private static final Timestampbean instance = new Timestampbean();
    
        //Sets the login and userid into the database
        private void loginTime(String email, String password) throws SQLException {
            
            String userID = db.findUserID(email,password);
            System.out.println("userid: "+userID);
            long time = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(time); 
            db.addLog(userID, timestamp);
            instance.setTime(timestamp); 


        }
      // gets the timestamp bean
        public static Timestampbean getInstance() {
            return instance; 
     }  
     //gets the user session 
        public static User getInstanceUser() { 
            return sessionU;
     }
        
         public void logs(String id, HttpServletRequest request, HttpServletResponse response) throws SQLException {
         String hold;
         HttpSession session = request.getSession();
          LinkedList<String> logs; //used a linkedlist to get all logs from the user
          logs = db.findLog(id); //finds the logs for the user
          session.setAttribute("logs", logs);
        int num = 0; //uses an iterator to get all logs
         while (logs.size() > num) {
        hold = (String) logs.get(num);
        ++num;
        logBean.setLogs(hold);
      }
         }
     private static final accessLogs logBean = new accessLogs();
     
     public static accessLogs getInstanceLogs() {
      return logBean;
  }
 
   }