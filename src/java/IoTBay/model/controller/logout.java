package IoTBay.model.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.Timestamp;
import IoTBay.mvp.model.Timestampbean;
import IoTBay.model.controller.checkLogin;
import IoTBay.mvp.model.User;
import IoTBay.mvp.model.accessLogs;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bailey
 */
//@WebServlet("/loginCheck")
public class logout extends HttpServlet {
private DBConnector connector; 
private Connection conn;
private DBManager db;


public logout() {}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {    
       try {     
          connector = new DBConnector();
          conn = connector.openConnection();  
          db = new DBManager(conn); 
          checkLogin checker = new checkLogin();
          User user = checker.getInstanceUser(); 
//          accessLogs logs = checker.getInstanceLogs(); 
//          Timestampbean bean = checker.getInstance(); 
          String email = user.getEmail();
          String password = user.getPassword();
          //logoutTime(email,password);   
            HttpSession session = request.getSession();
            user.logoutUser(); 
//            logs.logoutLogs(); 
//            bean.logoutBean(); 
          response.sendRedirect("homePage.jsp");
        } catch (SQLException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
//    private void logoutTime(String email, String password) throws SQLException {
//       String userID = db.findUserID(email,password);
//       long time = System.currentTimeMillis();
//       Timestamp logouttimestamp = new Timestamp(time); 
//       checkLogin checker = new checkLogin();
//       Timestampbean loginTimeBean = checker.getInstance();
//       Timestamp loginTime = loginTimeBean.getTime(); 
//       db.addLogout(userID, logouttimestamp, loginTime);
//       
//       }

}

              

    
  


