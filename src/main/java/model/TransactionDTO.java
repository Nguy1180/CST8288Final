/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * DTO of Transaction, containing getters and setters.
 * @author tomye
 */
public class TransactionDTO {
    private int transactionID;
    private int userID;
    private double amount;
    private String type;
    private String description;

    // Getters and setters
    public int getTransactionID() {
        return transactionID;
    }

    public int getUserID() {
        return userID;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
    
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
