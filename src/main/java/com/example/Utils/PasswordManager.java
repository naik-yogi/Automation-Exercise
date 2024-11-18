package com.example.Utils;

import java.util.Random;

public class PasswordManager {
    private String dynamicPassword;

    // Method to generate a random password
    public String generatePassword() {
        int length = 8; // Set the desired password length
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        dynamicPassword = password.toString(); // Save the password for reuse
        return dynamicPassword;
    }

    public String getPassword() {
        return dynamicPassword;
    }
}
