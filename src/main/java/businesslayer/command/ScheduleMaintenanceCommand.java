/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.command;

import businesslayer.service.MaintenanceService;
import businesslayer.model.MaintenanceTask;

/**
 * Command to schedule a maintenance task.
 *
 * @author Muanda Junior
 */
public class ScheduleMaintenanceCommand implements Command {

    private MaintenanceService maintenanceService;
    private MaintenanceTask task;

    public ScheduleMaintenanceCommand(MaintenanceService maintenanceService, MaintenanceTask task) {
        this.maintenanceService = maintenanceService;
        this.task = task;
    }

    @Override
    public void execute() {
        maintenanceService.scheduleTask(task);
    }
}
