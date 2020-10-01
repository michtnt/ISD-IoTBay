/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.mvp.model;
import java.sql.Timestamp;

/**
 *
 * @author Bailey
 */
public class Timestampbean {
    Timestamp time; 

    public Timestampbean(Timestamp time) {
        this.time = time;
    }
    
    public Timestampbean() {}

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    public void logoutBean() {
        this.time = null; 
    }
    
}
