/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.mvp.model;
import java.io.Serializable;

/**
 *
 * @author Bailey
 */
public class User implements Serializable{
    
    private String email;
    private String firstName; 
    private String lastName; 
    private String password; 
    private String address;
    private String username;
    private String userId;

    public User(String email, String firstName, String lastName, String password, String address, String username, String userId) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.username = username;
        this.userId = userId; 
    }
    
public User(){}

    public User(String ID, String username, String fName, String lName, String address, String email, String password, String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void logoutUser() {
    setEmail(null); 
    setFirstName(null); 
    setLastName(null); 
    setPassword(null); 
    setAddress(null); 
    setUsername(null); 
    setUserId(null); 
    } 
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
}
