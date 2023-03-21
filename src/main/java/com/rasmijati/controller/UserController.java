/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;
import static com.rasmijati.util.validator.isValidateEmail;
import static com.rasmijati.util.validator.isValidatePassword;
import static com.rasmijati.util.validator.isValidatePhoneNumber;
import static com.rasmijati.util.validator.isValidateString;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class UserController {

    private static UserRepository userRepository;

    public void crudOption(UserRepository userRepository) {
        this.userRepository = userRepository;
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println(".................................................................");
            System.out.println("Choose an operation from below : ");
            System.out.println("..................................................................");
            System.out.println("Enter 1 to create");
            System.out.println("Enter 2 to list ");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to edit");
            System.out.println("Enter 5 to Exit");
            choice = sc.next();
            switch (choice) {
                case "1":
                    create();
                    System.out.println("..................................................................");
                    break;
                case "2":
                    list();
                    System.out.println("..................................................................");
                    break;
                case "3":
                    delete();
                    System.out.println("..................................................................");
                    break;
                case "4":
                    edit();
                    System.out.println("..................................................................");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!choice.equals("0"));
    }

    public static void create() {   // static methods beacuse the method can be called using the class name in other class
        Long id = null;
        String name = null;
        String email = null;
        String phone = null;
        String password = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter User id : ");
            String uid = sc.next();
            try {
                id = Long.valueOf(uid);
            } catch (NumberFormatException e) {
                System.err.println("Error");
                id = null;
            }
        }

        while (name == null || name.isEmpty()) {
            System.out.println("Enter user name : ");
            name = sc.next();
            if (!isValidateString(name)) {
                System.err.println("Invaild Name !!");
                name = null;
            }
        }

        while (email == null || email.isEmpty()) {
            System.out.println("Enter user email : ");
            email = sc.next();
            if (!isValidateEmail(email)) {
                System.err.println("Invaild Email !!");
                email = null;
            }
        }

        while (phone == null || phone.isEmpty()) {
            System.out.println("Enter phone number: ");
            phone = sc.next();
            if (!isValidatePhoneNumber(phone)) {
                System.err.println("Invaild Phone Number !!");
                phone = null;
            }
        }

        while (password == null || password.isEmpty()) {
            System.out.println("Enter password : ");
            password = sc.next();
            if (!isValidatePassword(password)) {
                System.err.println("Password must contain at least eight characters, at least one number and both lower and uppercase letters and special characters ");
                password = null;
            }
        }

        User u = new User(id, name, email, phone, password);
        userRepository.create(u);  // create method of UserRepository
        System.out.println("User Inserted Successfilly!!");
    }

    public static void list() {
        userRepository.findAll().stream().forEach(x -> System.out.println("All Users List : " + x)); //1st load the user list in stream and fetch one value at a time using for each
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User's Id: ");
        Long id = sc.nextLong();
        User user = userRepository.findById(id);
        if (user == null) {
            System.out.println("User's ID " + id + " not found");
        } else {
            userRepository.delete(user);
            System.out.println("User of id " + id + " deleted succesfully!!");
            list();
        }
    }

    public static void edit() {
        Long id = null;
        String name = null;
        String email = null;
        String phone = null;
        String password = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter User id : ");
            String uid = sc.next();
            try {
                id = Long.valueOf(uid);
            } catch (NumberFormatException e) {
                System.err.println("Error");
                id = null;
            }
        }

        while (name == null || name.isEmpty()) {
            System.out.println("Enter user name : ");
            name = sc.next();
            if (!isValidateString(name)) {
                System.err.println("Invaild Name !!");
                name = null;
            }
        }

        while (email == null || email.isEmpty()) {
            System.out.println("Enter user email : ");
            email = sc.next();
            if (!isValidateEmail(email)) {
                System.err.println("Invaild Email !!");
                email = null;
            }
        }

        while (phone == null || phone.isEmpty()) {
            System.out.println("Enter phone number: ");
            phone = sc.next();
            if (!isValidatePhoneNumber(phone)) {
                System.err.println("Invaild Phone Number !!");
                phone = null;
            }
        }

        while (password == null || password.isEmpty()) {
            System.out.println("Enter password : ");
            password = sc.next();
            if (!isValidatePassword(password)) {
                System.err.println("Password must contain at least eight characters, at least one number and both lower and uppercase letters and special characters ");
                password = null;
            }
        }

        User u = new User(id, name, email, phone, password);
        userRepository.edit(u);
        System.out.println("User Edited Successfully");
        list();
    }
}
