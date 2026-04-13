/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.model;

/**
 * Represents a maintenance or system alert.
 *
 * @author Muanda Junior
 */
public class Alert {

    private int scooterId;
    private String message;
    private String alertType;

    public Alert() {
    }

    public Alert(int scooterId, String message, String alertType) {
        this.scooterId = scooterId;
        this.message = message;
        this.alertType = alertType;
    }

    public int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "scooterId=" + scooterId +
                ", message='" + message + '\'' +
                ", alertType='" + alertType + '\'' +
                '}';
    }
}