/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import dto.StationDTO;

/**
 *
 * @author the_p
 */
public interface IStationDao {
    List<StationDTO> getAllStations();
    void createStation(String name, String location);
    
}
