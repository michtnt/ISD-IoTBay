/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.mvp.model;

/**
 *
 * @author Michelle Tanoto
 */

public class Staff {
    private String staffFName;
    private String staffLName;
    private String staffEmail;
    private String staffAddress;
    private String staffUsername;
    private String staffPassword;
    private String staffPosition;
    private Boolean active;

    public Staff(String staffFName, String staffLName, String staffEmail, String staffAddress, String staffUsername, String staffPassword, String staffPosition, Boolean active) {
        this.staffFName = staffFName;
        this.staffLName = staffLName;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
        this.staffPosition = staffPosition;
        this.active = active;
    }

    public String getStaffFName() {
        return staffFName;
    }

    public String getStaffLName() {
        return staffLName;
    }
    
    public String getStaffEmail() {
        return staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public String getStaffPosition() {
        return staffPosition;
    }
    
    public Boolean getActive(){
        return active;
    }

    public void setStaffFName(String staffFName) {
        this.staffFName = staffFName;
    }

    public void setStaffLName(String staffLName) {
        this.staffLName = staffLName;
    }
    
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }
    
    public void setActive(Boolean active){
        this.active = active;
    }
}
