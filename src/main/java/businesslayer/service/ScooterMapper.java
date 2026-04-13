/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.service;

import businesslayer.model.Scooter;
import dto.ScooterDTO;

/**
 * Connects DTO to the Model.
 * @author tomye
 */
public class ScooterMapper {

    public static Scooter toModel(ScooterDTO dto) {

        if (dto == null) {
            return null;
        }

        return new Scooter.Builder()
                .setScooterId(dto.getScooterID())
                .setVehicleNumber(dto.getVehicleNumber())
                .setMake(dto.getManufacturer())
                .setModel(dto.getModel())
                .setColor(dto.getColor())
                .setBatteryCapacity(dto.getBatteryCapacity())
                .setCurrentChargeLevel(dto.getCurrentChargeLevel())
                .setGpsLatitude(dto.getGpsLatitude())
                .setGpsLongitude(dto.getGpsLongitude())
                .setStatus(dto.getStatus())
                .setLastStationId(dto.getStationID())
                .setTotalUsageHours(dto.getTotalUsageHours())
                .setBrakeWearLevel(dto.getBrakeWearLevel())
                .setTireWearLevel(dto.getTireWearLevel())
                .build();
    }
}
