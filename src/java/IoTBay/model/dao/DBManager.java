/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.dao;
import IoTBay.mvp.model.Staff;
import IoTBay.mvp.model.Admin;
import IoTBay.mvp.model.Product;
import IoTBay.mvp.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import IoTBay.mvp.model.*;
/**
 *
 * @author Michelle Tanoto
 */

//=====================EVERYTHING AFTER THIS LINE IS STAFF MANAGEMENT FOR MICHELLE TANOTO 13175144==========================

public class DBManager {

    private Statement st;

    public DBManager(Connection conn) throws SQLException {       
       st = conn.createStatement();   
    }

    // Find staff by username in the Staff database  
    public Staff findStaff(String username) throws SQLException {       
       // setup the select sql query string       
       // execute this query using the statement field       
       // add the results to a rs      
       
       // search the rs for a staff using the parameters 
       String fetch = "select * from IOTBAY.STAFFS WHERE STAFFUSERNAME = '" + username + "'";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           String staff_username = rs.getString(6);
           String staff_password = rs.getString(7);
           if(staff_username.equals(username)){
                String staff_first_name = rs.getString(2);
                String staff_email = rs.getString(4);
                String staff_address = rs.getString(5);
                String staff_last_name = rs.getString(3);
                String staff_position = rs.getString(8);
                Boolean staff_active = rs.getBoolean(9);
                return new Staff(staff_first_name, staff_last_name, staff_email, staff_address, staff_username, staff_password, staff_position,staff_active);
           }
       }
       
       return null;   
    }
    
    
    // Find staff by username and position in Staff database
    public Staff searchStaff(String username, String position) throws SQLException {       
       // setup the select sql query string       
       // execute this query using the statement field       
       // add the results to a rs      
       // search the rs for a staff using the parameters 
       
       String fetch = "select * from IOTBAY.STAFFS WHERE STAFFUSERNAME = '" + username + "' AND STAFFPOSITION ='" + position +"'";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           String staff_username = rs.getString(6);
           String staff_position = rs.getString(8);
           if(staff_username.equals(username) || staff_position.equals(position)){
                String staff_password = rs.getString(7);
                String staff_first_name = rs.getString(2);
                String staff_email = rs.getString(4);
                String staff_address = rs.getString(5);
                String staff_last_name = rs.getString(3);
                Boolean staff_active = rs.getBoolean(9);
                return new Staff(staff_first_name, staff_last_name, staff_email, staff_address, staff_username, staff_password, staff_position, staff_active);
           }
       }
       
       return null;   
    }
    
    // Find admin by username and password in Admin Database  
    public Admin findAdmin(String username, String password) throws SQLException {       
       // setup the select sql query string       
       // execute this query using the statement field       
       // add the results to a rs       
       // search the rs for a admin using the parameters 
       String fetch = "select * from IOTBAY.ADMINS WHERE ADMINUSERNAME = '" + username + "' AND ADMINPASSWORD = '" + password + "'";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           String admin_username = rs.getString(1);
           String admin_password = rs.getString(2);
           if(admin_username.equals(username) && admin_password.equals(password)){
                return new Admin(admin_username, admin_password);
           }
       }
       return null;   
    }

    // Add a staff into the staff database   
    public void addStaff(String firstName, String lastName, String email, String address, String username, String password, String position) throws SQLException {                   //code for add-operation      
      st.executeUpdate(
        "INSERT INTO IOTBAY.STAFFS " + "VALUES (DEFAULT, '" + firstName + "','" +
         lastName + "','" + email + "','" + address + "','" + username + "','" +
         password + "','" + position + "', TRUE )");  
    }

    // update a staff details in the staff database   
    public void updateStaff(String firstName, String lastName, String email, String address, String username, String password, String position, String oldUsername, Boolean active) throws SQLException {       
        st.executeUpdate(
         "UPDATE IOTBAY.STAFFS " + "SET STAFFFNAME='" + firstName + "', STAFFLNAME ='" +
         lastName + "', STAFFEMAIL ='" + email + "', STAFFADDRESS ='" + address + "', STAFFUSERNAME ='" 
         + username + "', STAFFPASSWORD ='" + password +  "', STAFFPOSITION='" + position + "', STAFFACTIVE= " + active + " WHERE STAFFUSERNAME='" + oldUsername + "'");    
    }       

    // delete a staff from the staff database   
    public void deleteStaff(String username) throws SQLException{       
        st.executeUpdate("DELETE FROM IOTBAY.STAFFS WHERE STAFFUSERNAME ='" + username +  "'");
            }

    // fetch staffs from staff database
    public ArrayList<Staff> fetchStaffs() throws SQLException {
        String fetch = "SELECT * from IOTBAY.STAFFS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();

        while(rs.next()){
            String staff_first_name = rs.getString(2);
            String staff_email = rs.getString(4);
            String staff_address = rs.getString(5);
            String staff_username = rs.getString(6);
            String staff_password = rs.getString(7);
            String staff_last_name = rs.getString(3);
            String staff_position = rs.getString(8);
            Boolean staff_active = rs.getBoolean(9);
            temp.add(new Staff(staff_first_name, staff_last_name, staff_email, staff_address, staff_username, staff_password, staff_position, staff_active));
        }
        return temp;
    }
    
    // to verify if staff exist ot no
    public boolean checkStaff(String username, String password) throws SQLException {
        String fetch = "SELECT * from IOTBAY.STAFFS WHERE STAFFUSERNAME = '" + username + "' AND STAFFPASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
         String staff_username = rs.getString(6);
         String staff_password = rs.getString(7);
         
         if(staff_username.equals(username) && staff_password.equals(password)){
             return true;
           }
        }
     return false;
    }
    
//=====================EVERYTHING BEFORE THIS LINE IS STAFF MANAGEMENT FOR MICHELLE TANOTO 13175144==========================
    
/**
 *
 * @author Michael
 */

private LinkedList<String> list_data = new LinkedList<String>(); 
   

public LinkedList get_data()
{
    return list_data;//return Linked List 
}

public void listCustomer(String Search) throws SQLException {       
    
 
   String query = "SELECT * FROM IOTBAY.USERDB WHERE USERFNAME like '%"+Search+"%' OR USERLNAME like '%"+Search+"%' OR USEREMAIL like '%"+Search+"%'";
   //show users by a word that is contained in username/userlastname/useremail 
   st.executeQuery(query);  //execute query
   ResultSet rs = st.executeQuery(query);//Query Result
   while(rs.next())//run through all result
    {
   list_data.add(rs.getString("USERID"));
   list_data.add(rs.getString("USERUSERNAME"));
   list_data.add(rs.getString("USERFNAME")); 
   list_data.add(rs.getString("USERLNAME"));
   list_data.add(rs.getString("ADDRESS"));
   list_data.add(rs.getString("USEREMAIL"));
    list_data.add(rs.getString("ACTIVE")); 
    //get the data from query result
   }
}

public Customer findCustomer(int id, String username) throws SQLException {       

   String query = "SELECT * FROM USERDB WHERE USERID ='"+id+"' AND USERUSERNAME ='"+username+"'";
   //find customer using userID nad username because I have set from table so it is generated from system

   st.executeQuery(query);  //execute query
   ResultSet rs = st.executeQuery(query);//set result
   if(!rs.next())//if there is no query result then return null
   {
       return null;
   }
   else//if query have result
   {
   String ID = rs.getString("USERID");
   int UserID = Integer.parseInt(ID);
   String Username = rs.getString("USERUSERNAME");
   String UserFirstName = rs.getString("USERFNAME");
   String UserLastName = rs.getString("USERLNAME");
   String Address = rs.getString("ADDRESS");
   String UserEmail = rs.getString("USEREMAIL");
   String UserPassword = rs.getString("USERPASSWORD");
   boolean Activate = rs.getBoolean("ACTIVE");
   //take all parameter
   
   Customer current = new Customer(UserID,Username,UserFirstName,UserLastName,Address,UserEmail,UserPassword,Activate);
   //save it as Customer object
   return current;   
   //return the object
   }
}

public void addUser(String username, String firstname, String lastname,String address, String email, String password) throws SQLException 
{     
    String id = Integer.toString(generateID());
    //generate ID
    String query = "INSERT INTO USERDB (USERID, USERUSERNAME, USERFNAME, USERLNAME, ADDRESS, USEREMAIL, USERPASSWORD, ACTIVE) VALUES ('"+id+"','"+username+"','"+firstname+"', '"+lastname+"','"+address+"','"+email+"','"+password+"','TRUE')";
   //Insert into USERDB using all the parameters  
   st.executeUpdate(query);  
   //execute query

}

//update a user details in the database   
public void updateUser(String userid, String username, String firstname, String lastname,String address, String email) throws SQLException 
{       
   String query = "UPDATE USERDB SET USERUSERNAME ='"+username+"', USERFNAME='"+firstname+"', USERLNAME='"+lastname+"', ADDRESS='"+address+"', USEREMAIL='"+email+"' WHERE USERID='"+userid+"'";
   //update the selected userDB using userID  
   st.executeUpdate(query);  
   //execute query

}   
public void DeactivateUser(String userid) throws SQLException 
{   
   String DeactivateUser = "UPDATE USERDB SET ACTIVE='FALSE' where USERID ='"+userid+"'";
   //selected customer active(bool)column set to false 
   st.executeUpdate(DeactivateUser);  
   //execute query
}  

public void ActivateUser(String userid) throws SQLException 
{   
   String ActivateUser = "UPDATE USERDB SET ACTIVE='TRUE' where USERID ='"+userid+"'";
   //selected customer active(bool)column set to true 
   st.executeUpdate(ActivateUser);  
   //execute query
}       


  
public void deleteUser(String userid) throws SQLException
{       
   String query = "DELETE FROM USERDB WHERE USERID='"+userid+"'";
   //Delete an customer from userID  
   st.executeUpdate(query);  
   //execute query

}
public int generateID() throws SQLException
{
   String query = "SELECT MAX(USERID) as USERID FROM IOTBAY.USERDB";
   //execute this query using the statement field    
   ResultSet rs = st.executeQuery(query);
   //search the ResultSet for a user using the parameters
   if(!rs.next())
   {
       return 2;
   }
   else
   {
   int UserID = rs.getInt("USERID");
   UserID = UserID +1;
   return UserID;  
   }
}


/**
 *
 * @author Rebecca
 */
public void addNewItem(String productname, String brand, double price, int stock, String description) throws SQLException {

    int temp = 0;
    String query = "INSERT INTO IOTBAY.PRODUCT VALUES ("+temp+",'"+productname+"', '"+brand+"', "+price+", "+stock+", '"+description+"')";
    st.executeUpdate(query);

    String getid = "UPDATE IOTBAY.PRODUCT SET PRODUCTID = (SELECT MAX(PRODUCTID) FROM IOTBAY.PRODUCT) + 1 WHERE PRODUCTID = 0";
    st.executeUpdate(getid);
}

public void deleteItem(String productname) throws SQLException {
    String query = "DELETE FROM IOTBAY.PRODUCT WHERE (PRODUCTNAME) = ('"+productname+"')";
    st.executeUpdate(query);
}

public void updateItem(int productid, String productname, String brand, double price, int stock, String description) throws SQLException {        
    String query = "UPDATE IOTBAY.PRODUCT SET PRODUCTNAME = ('"+productname+"'), BRAND = ('"+brand+"'), PRICE = ("+price+"), STOCK = ("+stock+"), DESCRIPTION = ('"+description+"') WHERE PRODUCTID = ("+productid+")";
    st.executeUpdate(query);

}

public boolean checkItem(String productname) throws SQLException {
    String query = "SELECT * FROM IOTBAY.PRODUCT WHERE (PRODUCTNAME) = '"+productname+"'";
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
        String item_productname = rs.getString(2);

        if (item_productname.equals(productname)) {
            return true;
        }
    }
    return false;
}

public int fetchProductid(String productname) throws SQLException {
    String query = "SELECT PRODUCTID FROM IOTBAY.PRODUCT WHERE PRODUCTNAME = '"+productname+"'";
    ResultSet rs = st.executeQuery(query);
    int productid = 0;

    while (rs.next()) {
        productid = rs.getInt(1);
    }
    //return null;
    return productid;
}

public Product fetchItem(String productname) throws SQLException {
    String query = "SELECT * FROM IOTBAY.PRODUCT WHERE (PRODUCTNAME) = '"+productname+"'";
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
        String item_productname = rs.getString(2);
        if (item_productname.equals(productname)) {
            int item_productid = rs.getInt(1);
            String item_brand = rs.getString(3);
            double item_price = rs.getDouble(4);
            int item_stock = rs.getInt(5);
            String item_description = rs.getString(6);
            return new Product(item_productid, item_productname, item_brand, item_price, item_stock, item_description);
        }
    }
    return null;
}

public ArrayList<Product> showInventory() throws SQLException {
    String query = "SELECT * FROM IOTBAY.PRODUCT ORDER BY PRODUCTID";
    ResultSet rs = st.executeQuery(query);
    ArrayList<Product> inventory = new ArrayList();

    while (rs.next()) {
        int item_productid = rs.getInt(1);
        String item_productname = rs.getString(2);
        String item_brand = rs.getString(3);
        double item_price = rs.getDouble(4);
        int item_stock = rs.getInt(5);
        String item_description = rs.getString(6);

        inventory.add(new Product(item_productid, item_productname, item_brand, item_price, item_stock, item_description));
    }

    return inventory;
}

public void decreaseStock(int productid, int quantity) throws SQLException {
    String query = "UPDATE IOTBAY.PRODUCT SET STOCK = (SELECT STOCK FROM IOTBAY.PRODUCT WHERE PRODUCTID = "+productid+") - "+quantity+" WHERE PRODUCTID = "+productid+"";
    st.executeUpdate(query);
}



//=====================EVERYTHING BETWEEN THIS LINE USER MANAGEMENT FOR BAILEY MENDONCA 13202357==========================
public void addLogout(String userID, Timestamp logoutTime, Timestamp loginTime) throws SQLException {
    //String query = ("UPDATE BAILEY.ACCESSLOGDB SET LOGOUTTIME='" + logoutTime + "' WHERE USERID='" + userID + "' AND LOGINTIME='" +loginTime+"'"); 
    String query = ("UPDATE IOTBAY.ACCESSLOGDB SET LOGOUT='" + logoutTime + "' WHERE USERID='" + userID +"' AND LOGIN='"+ loginTime + "'"); 
    //String query = ("UPDATE BAILEY.ACCESSLOGDB SET LOGOUTTIME='" + logoutTime + "' WHERE LOGINTIME='" + loginTime +"'"); 
    st.executeUpdate(query); 
}

public void updateEmail(String email, String userID) throws SQLException{
String query = ("UPDATE IOTBAY.USERDB SET USEREMAIL='" + email + "' WHERE USERID='"+ userID + "'"); 
    st.executeUpdate(query); 
}

public boolean isActive(String email, String password) throws SQLException{
    boolean active = false; 
   String fetch = "select * from IOTBAY.USERDB where USEREMAIL= '" + email + "' and USERPASSWORD= '" + password + "'"; 
   st.executeUpdate(fetch); 
   ResultSet rs = st.executeQuery(fetch);
       while (rs.next()){ 
          active= rs.getBoolean(7);
           if(active == true)
               break; 
       }
           return active; 
}

        
public void updateFName(String fName, String userID)throws SQLException {
String query = ("UPDATE IOTBAY.USERDB SET USERFNAME='" + fName + "' WHERE USERID='"+ userID + "'"); 
    st.executeUpdate(query); 
}
public void updateLName(String lName, String userID)throws SQLException {
String query = ("UPDATE IOTBAY.USERDB SET USERLNAME='" + lName + "' WHERE USERID='"+ userID + "'"); 
    st.executeUpdate(query); 
}
public void updatePassword(String password, String userID)throws SQLException{
String query = ("UPDATE IOTBAY.USERDB SET USERPASSWORD='" + password + "' WHERE USERID='"+ userID + "'"); 
    st.executeUpdate(query); 
}
public void updateUsername(String username, String userID)throws SQLException {
String query = ("UPDATE IOTBAY.USERDB SET USERUSERNAME='" + username + "' WHERE USERID='"+ userID + "'"); 
    st.executeUpdate(query); 
}
public void updateAddress(String address, String userID)throws SQLException {
    String query = ("UPDATE IOTBAY.USERDB SET USEREMAIL='" + address + "' WHERE USERID='"+ userID + "'"); 
    st.executeUpdate(query); 
}

// =======================Everything above this is updateUser=======================


// ======================Everything below this is deleteUser======================

public void deleteUserBM(String Id) throws SQLException{       
   //code for delete-operation   
   st.executeUpdate("DELETE FROM IOTBAY.USERDB WHERE USERID='" + Id + "'");
}

// =======================Everything above this is deleteUser=======================


// ======================Everything between this is createUser======================
public void addLog(String userID, Timestamp logoutTime) throws SQLException
{
String query = "INSERT INTO IOTBAY.ACCESSLOGDB (USERID, LOGINTIME) VALUES ('"+userID+"', '"+logoutTime+"')"; 
st.executeUpdate(query); 
}

public void addUser( String userUsername, String userFName, String userLName, String userAddress, String userEmail, String userPassword, String userID, boolean userActive) throws SQLException { 
    //code for add-operation       
 String query = "INSERT INTO IOTBAY.USERDB (USERUSERNAME, USERFNAME, USERLNAME, USEREMAIL, USERPASSWORD, USERID, ACTIVE, USERADDRESS) VALUES ('"+userUsername+"', '"+userFName+"','"+userLName+"', '"+userEmail+"', '"+ userPassword+"', '"+userID+"', '"+userActive+"', '"+userAddress+"')"; 
st.executeUpdate(query); 
}

// =======================Everything above this is createUser=======================


// ======================Everything between this is readUser======================
//Basically is just stuff that isn't directly CRUD
public boolean checkUser(String email, String password) throws SQLException { 
   boolean c = false; 
       String fetch = "select * from IOTBAY.USERDB where USEREMAIL= '" + email + "' and USERPASSWORD= '" + password + "'"; 
       ResultSet rs = st.executeQuery(fetch);
       while (rs.next()){ 
           String emailCheck= rs.getString(5);
           String passwordCheck = rs.getString(6);
           boolean check = rs.getBoolean(7);
           
           if(emailCheck != null && passwordCheck != null && check != false) {
               c = true;
               break; 
           }
   }
         return c; 
 }

public boolean checkEmail(String email) throws SQLException {
     boolean c = false; 
      String fetch = "select * from IOTBAY.USERDB where USEREMAIL= '" + email + "'"; 
      ResultSet rs = st.executeQuery(fetch);
      while (rs.next()){ 
          String emailCheck = rs.getString(5); 
          if (emailCheck != null) {
              c = true; 
              break; 
          }
      }
      return c; 
 }
  public User setUser(String email, String password) throws SQLException {
      User user = null;
      String fetch = "select * from IOTBAY.USERDB where USEREMAIL= '" + email + "' and USERPASSWORD= '" + password + "'"; 
      ResultSet rs = st.executeQuery(fetch);
       while (rs.next()){ 
           String userEmail = rs.getString(5);
           String userFName = rs.getString (3); 
           String userLName = rs.getString(4);
           String userPass = rs.getString(6);
           String userAddress = rs.getString(8); 
           String userUsername = rs.getString(2); 
           String userID = rs.getString(1); 
           User temp = new User(userEmail, userFName, userLName, userPass, userAddress, userUsername, userID); 
           user = temp; 
       }
       return user; 
 }
  
  public String findUserID(String email, String password) throws SQLException {
      String userID = null; 
       String fetch = "select * from IOTBAY.USERDB where USEREMAIL= '" + email + "' and USERPASSWORD= '" + password + "'"; 
       ResultSet rs = st.executeQuery(fetch);
       while (rs.next()){ 
       userID= rs.getString(1);
           
     
 }
       return userID; 
 }
  
public boolean checkAdmin(String email, String password) throws SQLException {
   boolean c = false;
       String fetch = "select * from IOTBAY.ADMINS where ADMINUSERNAME= '" + email + "' and ADMINPASSWORD= '" + password + "'";
       ResultSet rs = st.executeQuery(fetch);
       while (rs.next()){
           String emailCheck= rs.getString(1);
           String passwordCheck = rs.getString(2);
           //boolean check = rs.getBoolean(8);
           if(emailCheck != null && passwordCheck != null) {
               c = true;
               break;
           }
   }
         return c;
 }
  public boolean findPassword (String email) throws SQLException{
String fetch = "select  * from IOTBAY.USERDB where USEREMAIL = '" + email  + "'";  
  ResultSet rs = st.executeQuery(fetch);
 String passwordCheck = rs.getString(6);
 if (passwordCheck != null) {
     return true; }
 else {
     return false; 
 } 
 }
 
  public static String newline = System.getProperty("line.separator");
 
  public LinkedList findLogSearch(String id, Timestamp time) throws SQLException{
  LinkedList<String> logs = new LinkedList<String>(); 
  String fetch = "select  * from IOTBAY.ACCESSLOGDB where USERID = '" + id  + "' and LOGINTIME= ' " + time  + "'";  
  ResultSet rs = st.executeQuery(fetch);
  while (rs.next()){ 
      String login = "" + rs.getTimestamp(2); 
      Timestamp check = rs.getTimestamp(3);
      String logout = "" + rs.getTimestamp(3);
      if(check != null){
      } else {
          logout = "Unexpected closure, No official logout";
      }     
      String temp = "Logged in at: " + login + " Logged out at:  "+ logout; 
      logs.add(temp); 
  }
  return logs;
  }
  
  
  public LinkedList findLog(String id) throws SQLException{
  LinkedList<String> logs = new LinkedList<String>(); 
  String fetch = "select  * from IOTBAY.ACCESSLOGDB where USERID = '" + id  + "'";  
  ResultSet rs = st.executeQuery(fetch);
  while (rs.next()){ 
      String login = "" + rs.getTimestamp(2).toString(); 
      Timestamp check = rs.getTimestamp(1);
      String logout = "" + rs.getTimestamp(1).toString();
      if(check != null){
      } else {
          logout = "Unexpected closure, No official logout";
      }     
      String temp = "Logged in at: " + login + " Logged out at:  "+ logout; 
      logs.add(temp); 
  }
  return logs;
  }
  
  public User findUser(String userID, String userUsername, String userFName, String userLName, String userAddress, String userEmail, String userPassword) throws SQLException {       
  String fetch = "select  * from IOTBAY.USERDB where USEREMAIL = '" + userEmail  + "' and USERPASSWORD '" + userPassword + "'";  
  ResultSet rs = st.executeQuery(fetch);
  
  while (rs.next()) { 
      String email = rs.getString(6);
      String password = rs.getString(7);
      if (email.equals(userEmail) && password.equals(userPassword)) { 
            String ID = rs.getString(1);
            String username = rs.getString(2);
            String fName = rs.getString(3);
            String lName = rs.getString(4);
            String address = rs.getString(5);
            return new User(ID, username, fName, lName,  address,  email, password);
            
      }
  }
   return null;   
} 
  
  
  public String userIdinc() throws SQLException {
int id = 0;
String ids = null; 
String fetch = "SELECT * FROM IOTBAY.USERDB ORDER BY LENGTH(USERID), USERID ASC";
st.executeQuery(fetch);
ResultSet rs = st.executeQuery(fetch);
while (rs.next()) {
String intCheck = rs.getString(1);
id = Integer.parseInt(intCheck);
System.out.println(id);
id = id + 1; 
ids = Integer.toString(id); 
System.out.println(ids);
        
}
return ids; 
}
//Basically is just stuff that isn't directly CRUD
// =======================Everything above this is readUser=======================
   



//=====================EVERYTHING BETWEEN THIS LINE USER MANAGEMENT FOR BAILEY MENDONCA 13202357==========================

  
  


//===================== Everything below this line is PAYMENT MANAGEMENT for DESY LIUNARDI 13411576 ============================//
  
  
    //get the last paymentId in the database - used in Payment_CreateServlet
    public int getPaymentId() throws SQLException {
       int paymentId;
       String fetch = "select MAX(PAYMENTID) FROM IOTBAY.PAYMENTS" ;
       ResultSet rs = st.executeQuery(fetch);
       if (rs.next()) {
            paymentId = rs.getInt(1);
            return paymentId;
       } else {
           return 0;
       }
    }
    
     //Find the paymentId in database -- used in Payment_DeleteServlet and Payment_EditServlet
     public Payment foundedPaymentId(Integer paymentId) throws SQLException {       
       String fetch = "select * from IOTBAY.PAYMENTS WHERE PAYMENTID = "+paymentId+" ";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           Integer payment_Id = rs.getInt(1);
           if(payment_Id.equals(paymentId)){
                String paymentMethod  = rs.getString(3);
                Integer cardNumber = rs.getInt(4);
                Integer cvv = rs.getInt(5);
                String nameOnCard = rs.getString(6);
                String expiryDate = rs.getString(7);
                String datePaid = rs.getString(8);
                return new Payment(paymentMethod, cardNumber, cvv, nameOnCard, expiryDate, datePaid );
                }
           }
       return null;   
    }
     
    //Search paymnet by ID and datepaid in the database - Read one row in the database table - used in Payment_SearchServlet
    public Payment searchPayment(Integer paymentId, String datePaid) throws SQLException {       
       String fetch = "select * from IOTBAY.PAYMENTS WHERE PAYMENTID= "+paymentId+" and DATEPAID ='" + datePaid +"' ";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()){
           Integer payment_Id = rs.getInt(1);
           String date_Paid = rs.getString(8);
           if(payment_Id.equals(paymentId) && date_Paid.equals(datePaid)){
                Integer orderId = rs.getInt(2);
                String paymentMethod  = rs.getString(3);
                Integer cvv = rs.getInt(5);
                String expiryDate = rs.getString(7);
                Integer cardNumber = rs.getInt(4);
                String nameOnCard = rs.getString(6);
                return new Payment( paymentMethod, cardNumber, cvv, nameOnCard, expiryDate, datePaid );
                }
           }
       return null;   
    }
    
    //Add a payment-data into the database - used in Payment_CreateServlet
    public void addPayment( Integer OrderId, String paymentMethod, Integer cardNumber, Integer cvv, String nameOnCard, String expiryDate, String datePaid) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.PAYMENTS " + "VALUES (DEFAULT , " + OrderId + ",'" + paymentMethod + "', " + cardNumber + ", " + cvv + ",'" + nameOnCard + "', '" + expiryDate + "', '" + datePaid + "') ");
    }
    
    //Update a payment details in the database - used in Payment_UpdateServlet
    public void updatePayment(Integer paymentId, String paymentMethod, Integer cardNumber,
            Integer cvv, String nameOnCard, String expiryDate, String datePaid) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.PAYMENTS SET paymentMethod='" + paymentMethod + "', cardNumber=" + 
                cardNumber + ", cvv =" + cvv + ",  nameOnCard='" + nameOnCard + "', expiryDate='" + 
                expiryDate + "',  datePaid='" + datePaid + "' WHERE paymentId = " + paymentId +" ");
    }
    
    //delete a payment from database - used in Payment_DeleteServlet
    public void deletePayment (Integer paymentId) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.PAYMENTS WHERE paymentId = " + paymentId + " ");
    }

    //shows the list of payment based on userId -- Used in Payment_ShowHistoryServlet
    public ArrayList<String> fetchPayment(Integer userId) throws SQLException {
        String fetch = "select * from payments p join orderspayment o on o.ORDERIDPAYMENT = p.ORDERIDPAYMENT join userspayment u on u.useridpayment = o.USERIDpayment where o.USERIDpayment = "+userId+"  ";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<String> temp = new ArrayList();
        while(rs.next()) {
            temp.add(Integer.toString(rs.getInt(1)));
            temp.add(Integer.toString(rs.getInt(2)));
            temp.add(rs.getString(3));
            temp.add(Integer.toString(rs.getInt(4)));
            temp.add(Integer.toString(rs.getInt(5)));
            temp.add(rs.getString(6));
            temp.add(rs.getString(7));
            temp.add(rs.getString(8));
        }
        return temp;
    }
     
  //====This part belong to PAYMENT MANAGEMENT(DESY LIUNARDI 13411576). Contains dummy function of order and user to get the IDs==============//
 
    //get the last orderId from database - used in Payment1_CreateOrderServlet, Payment_CreateServlet
    public int getOrderId() throws SQLException {
       int orderId;
       String fetch = "select max(ORDERIDpayment) FROM IOTBAY.ORDERSPAYMENT" ;
       ResultSet rs = st.executeQuery(fetch);
       if (rs.next()) {
            orderId = rs.getInt(1);
            return orderId;
       } else {
           return 0;
       }
    }
    // add order to the database - used in Payment1_CreateOrderServlet
    public void paymentaddOrder( Integer userId, Double amount) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.ORDERSpayment " + "VALUES (DEFAULT ," + userId + ", "+amount+")");
    }
    // get the userId based on username and password from database - used in Payment1_CreateOrderServlet,Payment1_CreateUserServlet
    public int getUserId(String username, String password) throws SQLException {
       int userId;
       String fetch = "select USERIDpayment FROM IOTBAY.USERSpayment where usernamepayment = '"+username+"' and passwordpayment ='"+password+"' " ;
       ResultSet rs = st.executeQuery(fetch);
       if (!rs.next()) {
           return 1;
       } else {  
            userId = rs.getInt(1);
            return userId;
       }
    } 
    // add user to the database - used in Payment1_CreateOrderServlet
    public void paymentaddUser( String username, String password) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.USERSpayment " + "VALUES (DEFAULT ,'" + password + "', '" + username+"' ) ");
    }    
    // find the user based on their username and password - Used in Payment1_LoginServlet
    public Payment_User paymentfindUser (String username, String password) throws SQLException {
        String fetch = "select * from IOTBAY.USERSpayment where usernamepayment ='" + username +"' and PASSWORDpayment = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String user_name = rs.getString(3);
            String pass_word = rs.getString(2);
            if(user_name.equals(username) && pass_word.equals(password)) {
                return new Payment_User(user_name, pass_word);
            }
        }
        return null;
    }
    
}
///======================================End of PAYMENT MANAGEMENT (DESY LIUNARDI-13411576)===========================================//