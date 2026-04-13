/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer.model;

/**
 * Represents a maintenance task for a scooter.
 *
 * @author Muanda Junior
 */
public class MaintenanceTask {

    private int taskId;
    private int scooterId;
    private String taskType;
    private String description;
    private String status;
    private String scheduledDate;

    public MaintenanceTask() {
    }

    public MaintenanceTask(int taskId, int scooterId, String taskType, String description, String status, String scheduledDate) {
        this.taskId = taskId;
        this.scooterId = scooterId;
        this.taskType = taskType;
        this.description = description;
        this.status = status;
        this.scheduledDate = scheduledDate;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    @Override
    public String toString() {
        return "MaintenanceTask{" +
                "taskId=" + taskId +
                ", scooterId=" + scooterId +
                ", taskType='" + taskType + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", scheduledDate='" + scheduledDate + '\'' +
                '}';
    }
}
