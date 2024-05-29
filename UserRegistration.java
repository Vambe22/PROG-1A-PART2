/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;
import javax.swing.*;
/**
 *
 * @author lab_services_student
 */

public class UserRegistration {

    private String firstName;
    private String lastName;
    private String newUsername;
    private String newPassword;
    private String username;
    private String password;

    public void registerUser() {
        firstName = JOptionPane.showInputDialog(null, "Enter Your First Name");
        lastName = JOptionPane.showInputDialog(null, "Enter Your Last Name");
        newUsername = JOptionPane.showInputDialog(null, "Create Username", "Enter Your Username: ");
        newPassword = JOptionPane.showInputDialog(null, "Create Password", "Enter Your Password: ");

        if (validateUsername(newUsername) && validatePassword(newPassword)) {
            username = newUsername;
            password = newPassword;
            JOptionPane.showMessageDialog(null, "Registration Successful! You can now login.");
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed. Please try again.");
        }
    }

    public boolean validatePassword(String password) {
        if (password.length() >= 5) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Password, Must Have A Minimum Of 5 Or More Than 5 Characters ");
            return false;
        }
    }

    public boolean validateUsername(String username) {
        if (username.contains("_")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Username, It Must Contain An Underscore '_' ");
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
//https://www.w3schools.com/java/java_conditions.asp