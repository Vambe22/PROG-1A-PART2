/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

/**
 *
 * @author lab_services_student
 */
public class TaskItem {
    
    private String title;
    private String details;
    private String status;
    private String creator;
    private int hoursRequired;

    public TaskItem(String title, String details, String status, String creator, int hoursRequired) {
        this.title = title;
        this.details = details;
        this.status = status;
        this.creator = creator;
        this.hoursRequired = hoursRequired;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public String getCreator() {
        return creator;
    }

    public int getHoursRequired() {
        return hoursRequired;
    }
}

//https://www.w3schools.com/java/java_conditions.asp