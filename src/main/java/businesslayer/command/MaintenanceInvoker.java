/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.command;

import businesslayer.command.Command;

/**
 * Invoker class that executes maintenance commands.
 *
 * @author Muanda Junior
 */
public class MaintenanceInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command has been set.");
        }
    }
}
