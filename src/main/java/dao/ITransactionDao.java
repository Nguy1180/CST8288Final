/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.RideDTO;
import model.TransactionDTO;

/**
 *
 * @author the_p
 */
public interface ITransactionDao {
    void addTransaction(TransactionDTO t);
    double getUserBalance(int userId);
    boolean hasUnpaidBalance(int userId);
}
