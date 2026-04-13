/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.service;

import dao.IStationDao;
import dao.StationDAO;
import java.util.List;
import dto.StationDTO;

/**
 *
 * @author the_p
 */
public class StationService {
    private IStationDao station = null;
    
    public StationService() {
        station = new StationDAO();        
    }
    
    public List<StationDTO> getAllStations() {
        return station.getAllStations();
    }    
    
    public void createStation(String name, String location) {
        station.createStation(name, location);
    }
}

