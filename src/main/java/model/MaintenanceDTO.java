/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *  DTO of Maintenance, containing getters and setters.
 * @author tomye
 */
public class MaintenanceDTO {
    private int maintenanceID;
    private int scooterID;
    private String issue;
    private String status;
    private String scheduledDate;
    
    // Getters and Setters
    public int getMaintenanceID() {
        return maintenanceID;
    }

    public int getScooterID() {
        return scooterID;
    }

    public String getIssue() {
        return issue;
    }

    public String getStatus() {
        return status;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setMaintenanceID(int maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public void setScooterID(int scooterID) {
        this.scooterID = scooterID;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
    
    
}
