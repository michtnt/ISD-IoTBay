/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.mvp.model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Bailey
 */
public class accessLogs {
String logs; 
  
    public accessLogs() {}

    public accessLogs(String logs) {
        this.logs = logs;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }
    
    public void logoutLogs() { 
        this.logs = null; 
    }
    
}