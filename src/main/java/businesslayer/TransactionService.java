/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.ITransactionDao;
import dao.TransactionDAO;

/**
 *
 * @author the_p
 */
public class TransactionService {
    private ITransactionDao transaction = null;
    
    public TransactionService() {
        transaction = new TransactionDAO();
    }
    
}
