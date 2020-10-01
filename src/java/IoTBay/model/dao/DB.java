/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.dao;
import java.sql.Connection;

/**
 *
 * @author Michelle Tanoto
 */

//public abstract class DB {
//        
//protected String URL = "jdbc:derby://localhost:1527/TesterDB";//replace this string with your jdbc:derby local host url   
//protected String db = "BAILEY";//name of the database   
//protected String dbuser = "Bailey";//db root user   
//protected String dbpass = "13202357"; //db root password   
//protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
//protected Connection conn; //connection null-instance to be initialized in sub-classes
//}

public abstract class DB {
        protected String URL = "jdbc:derby://localhost:1527/IOTBAY";//replace this string with your jdbc:derby local host url   
        protected String db = "IOTBAY";//name of the database   
        protected String dbuser = "iotbay";//db root user   
        protected String dbpass = "iotbayisd"; //db root password   
        protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
        protected Connection conn; //connection null-instance to be initialized in sub-classes
}