/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mainapp;
import javax.swing.*;
/**
 *
 * @author lab_services_student
 */


public class MainApp {
    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration();
        UserLogin userLogin = new UserLogin(userRegistration);

        String[] options = {"Register", "Login", "Exit"};
        while (true) {
            String choice = (String) JOptionPane.showInputDialog(null, "User Management System Menu", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case "Register":
                    userRegistration.registerUser();
                    break;
                case "Login":
                    userLogin.adminLogin();
                    break;
                case "Exit":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
//https://www.w3schools.com/java/java_conditions.asp