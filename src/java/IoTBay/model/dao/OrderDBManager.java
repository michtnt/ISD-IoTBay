/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.dao;

import IoTBay.mvp.model.Orders;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tayla
 */
public class OrderDBManager {
    private Statement st; //used to execute SQL queries within java code
    
    public OrderDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public Orders findOrder(int oID, int uID) throws SQLException {
        String fetch = "select * from IOTBAY.ORDERS where orderID = " + oID + " and userID='" + uID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them into Strings
            int orderID = rs.getInt(1);
            int userID = rs.getInt(2);
            if (orderID == oID && userID == uID) {
                String orderDate = rs.getString(3);
                double tax = rs.getInt(4);
                double totalPrice = rs.getDouble(5);
                String shippingAddress = rs.getString(6);
                String billingAddress = rs.getString(7);
                return new Orders(orderID, userID, orderDate, tax, totalPrice, shippingAddress, billingAddress);
                
            }
            
        }
        return null;
    }
    
    public void addOrder(int orderID, int userID) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.ORDERS VALUES ("+orderID+", '" +userID+"', null, null, null, null, null)");
              
        
          
    }
    
    public void updateOrder(int orderID, int userID, String orderDate, double tax, double totalPrice, String shippingAddress, String billingAddress) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.ORDERS SET ORDERDATE='"+orderDate+"',TAX="+tax+",TOTALPRICE="+totalPrice+",SHIPPINGADDRESS='"+
                shippingAddress+"',BILLINGADDRESS='"+billingAddress+"' WHERE ORDERID="+orderID + " AND USERID='"+userID+"'");
    }
    
    public void deleteOrder(int orderID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.ORDERS WHERE ORDERID=" +orderID+"");
    }
    
    public ArrayList<Orders> fetchOrders(int userID) throws SQLException {
        String fetch = "select * from ORDERS where USERID='"+userID+"'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Orders> temp = new ArrayList();
        
        while (rs.next()) {
            int orderID = rs.getInt(1);
            String orderDate = rs.getString(3);
            double tax = rs.getDouble(4);
            double totalPrice = rs.getDouble(5);
            String shippingAddress = rs.getString(6);
            String billingAddress = rs.getString(7);
            temp.add(new Orders(orderID, userID, orderDate, tax, totalPrice, shippingAddress, billingAddress));
        }
        return temp;
    }
    
    
    
}