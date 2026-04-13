/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.time.LocalDate;
import java.time.YearMonth;
import model.RideDTO;

/**
 *
 * @author the_p
 */
public class BillingService {
    private static final double COST_PER_KM = 1.5;
    private static final double COST_PER_MINUTE = 0.2;

    public double calculateDebit(RideDTO ride) {
        double distanceCost = ride.getDistanceKm() * COST_PER_KM;
        double timeCost = ride.getDurationMinutes() * COST_PER_MINUTE;

        return distanceCost + timeCost;
    }
    
    public LocalDate getDueDate(YearMonth month) {
        return month.atEndOfMonth().plusDays(10);
    }

    public boolean isOverdue(YearMonth month) {
        return LocalDate.now().isAfter(getDueDate(month));
    }
    
}
