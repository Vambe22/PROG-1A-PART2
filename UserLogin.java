/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author lab_services_student
 */

public class UserLogin {

    private UserRegistration userRegistration;
    private int taskCounter = 0;
    private Map<String, List<TaskItem>> taskStatusMap;

    public UserLogin(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
        taskStatusMap = new HashMap<>();
        taskStatusMap.put("To Do", new ArrayList<>());
        taskStatusMap.put("Doing", new ArrayList<>());
        taskStatusMap.put("Done", new ArrayList<>());
    }

    public void adminLogin() {
        String inputUsername = JOptionPane.showInputDialog(null, "Enter Your Username:");
        String inputPassword = JOptionPane.showInputDialog(null, "Enter Your Password:");

        if (inputUsername.equals(userRegistration.getUsername()) && inputPassword.equals(userRegistration.getPassword())) {
            JOptionPane.showMessageDialog(null, "Welcome " + userRegistration.getFirstName() + " " + userRegistration.getLastName() + "! It Is Great To See You Again.");
            loggedInMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }

    private void loggedInMenu() {
        String[] loggedInOptions = {"Add Tasks", "Show Report", "Quit"};
        String loggedInChoice = (String) JOptionPane.showInputDialog(null, "Logged In Menu", "Menu", JOptionPane.PLAIN_MESSAGE, null, loggedInOptions, loggedInOptions[0]);

        switch (loggedInChoice) {
            case "Add Tasks":
                addTasks();
                break;
            case "Show Report":
                showTaskStatus();
                break;
            case "Quit":
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Quit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                loggedInMenu();
                break;
        }
    }

    private void addTasks() {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of tasks you wish to enter:"));

        for (int i = 0; i < numberOfTasks; i++) {
            String taskTitle = JOptionPane.showInputDialog(null, "Enter Task Title:");
            String taskDetails = JOptionPane.showInputDialog(null, "Enter Task Details (max 50 characters):");

            while (taskDetails.length() > 50) {
                taskDetails = JOptionPane.showInputDialog(null, "Details should not exceed 50 characters. Please re-enter Task Details:");
            }

            if (taskDetails.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No details were added. Task not captured.");
                continue;
            }

            String creator = JOptionPane.showInputDialog(null, "Enter Task Creator:");
            int hoursRequired = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Task Duration (in hours):"));

            String[] statuses = {"To Do", "Doing", "Done"};
            String selectedStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.PLAIN_MESSAGE, null, statuses, statuses[0]);

            taskCounter++;
            String taskID = generateTaskID(taskTitle, taskCounter, userRegistration.getLastName());
            TaskItem taskItem = new TaskItem(taskTitle, taskDetails, selectedStatus, creator, hoursRequired);
            taskStatusMap.get(selectedStatus).add(taskItem);

            StringBuilder taskInfo = new StringBuilder("Task ID: " + taskID + "\n");
            taskInfo.append("Title: ").append(taskItem.getTitle()).append("\n");
            taskInfo.append("Details: ").append(taskItem.getDetails()).append("\n");
            taskInfo.append("Status: ").append(taskItem.getStatus()).append("\n");
            taskInfo.append("Creator: ").append(taskItem.getCreator()).append("\n");
            taskInfo.append("Duration: ").append(taskItem.getHoursRequired()).append(" hours\n");

            JOptionPane.showMessageDialog(null, "Task successfully captured!\n\n" + taskInfo.toString());
        }
        loggedInMenu();
    }

    private void showTaskStatus() {
        String[] statuses = {"To Do", "Doing", "Done"};
        String selectedStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.PLAIN_MESSAGE, null, statuses, statuses[0]);

        List<TaskItem> tasks = taskStatusMap.get(selectedStatus);
        StringBuilder taskList = new StringBuilder("Tasks in " + selectedStatus + ":\n");

        for (TaskItem task : tasks) {
            taskList.append(task.getTitle()).append("\n");
        }

        JOptionPane.showMessageDialog(null, taskList.toString());
        loggedInMenu();
    }

    private String generateTaskID(String taskTitle, int taskNumber, String lastName) {
        return taskTitle.substring(0, Math.min(taskTitle.length(), 3)).toUpperCase() + ":" + taskNumber + ":" + lastName.substring(Math.max(0, lastName.length() - 3)).toUpperCase();
    }
}
//https://www.w3schools.com/java/java_conditions.asp