/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desyliunardi
 */
public class Payment1_Validator implements Serializable{ 
    private String usernamePattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";        
    private String passwordPattern = "[a-z0-9A-Z]{4,}";       

    public Payment1_Validator(){    }       


    public boolean validate(String pattern, String input){       
       Pattern regEx = Pattern.compile(pattern);       
       Matcher match = regEx.matcher(input);       
       return match.matches(); 
    }       

    public boolean validateUsername(String username){                       
       return validate(usernamePattern,username);   
    }   

    public boolean validatePassword(String password){
       return validate(passwordPattern,password); 
    }     
    
    public void clear(HttpSession session){
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("usernameErr", "Enter username");
    }
 }
