/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.command;

import businesslayer.service.MaintenanceService;
import businesslayer.model.MaintenanceTask;
import businesslayer.command.Command;

/**
 * Command to complete a maintenance task.
 *
 * @author Muanda Junior
 */
public class CompleteMaintenanceCommand implements Command {

    private MaintenanceService maintenanceService;
    private MaintenanceTask task;

    public CompleteMaintenanceCommand(MaintenanceService maintenanceService, MaintenanceTask task) {
        this.maintenanceService = maintenanceService;
        this.task = task;
    }

    @Override
    public void execute() {
        maintenanceService.completeTask(task);
    }
}
