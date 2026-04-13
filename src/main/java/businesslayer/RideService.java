/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.RidesDAO;
import dao.TransactionDAO;
import model.TransactionDTO;

/**
 *
 * @author the_p
 */
public class RideService {

    private RidesDAO ridesDAO;
    private TransactionDAO transactionDAO;

    private static final double COST_PER_KM = 1.5;
    private static final double COST_PER_MIN = 0.2;

    public RideService(RidesDAO rideDAO, TransactionDAO transactionDAO) {
        this.ridesDAO = rideDAO;
        this.transactionDAO = transactionDAO;
    }

    // User obtains scooter from station
    public int startRide(int userId, int scooterId, int stationId) throws Exception {
        return ridesDAO.startRide(userId, scooterId, stationId);
    }

    // User returns scooter → DEBIT created
    public void endRide(int rideId, int userId, int endStationId, double distanceKm) throws Exception {

        ridesDAO.endRide(rideId, endStationId, distanceKm);

        long duration = ridesDAO.getDurationMinutes(rideId);

        // REQUIREMENT: distance + time outside station
        double debit = (distanceKm * COST_PER_KM) + (duration * COST_PER_MIN);
        
        TransactionDTO transaction = new TransactionDTO();
        transaction.setUserID(userId);
        transaction.setAmount(debit);
        transaction.setType("DEBIT");
        transaction.setDescription("Scooter ride usage");
        
        transactionDAO.addTransaction(transaction);
    }
}
