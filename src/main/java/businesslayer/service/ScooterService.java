/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.service;

import dao.IScooterDao;
import dao.ScooterDAO;
import java.util.List;
import dto.ScooterDTO;

/**
 *
 * @author the_p
 */
public class ScooterService {
    
    private IScooterDao scooter = null;
    
    public ScooterService() {
        scooter = new ScooterDAO();
    }
    
    public List<ScooterDTO> getAllScooters() {
        return scooter.getAllScooters();
    }
}
