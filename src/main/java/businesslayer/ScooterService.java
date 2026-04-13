/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.IScooterDao;
import dao.ScooterDAO;

/**
 *
 * @author the_p
 */
public class ScooterService {
    
    private IScooterDao scooter = null;
    
    public ScooterService() {
        scooter = new ScooterDAO();
    }
}
