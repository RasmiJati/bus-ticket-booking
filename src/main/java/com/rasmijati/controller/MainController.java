/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.repository.BookingRepository;
import com.rasmijati.repository.BusRepository;
import com.rasmijati.repository.PaymentRepository;
import com.rasmijati.repository.RouteRepository;
import com.rasmijati.repository.UserRepository;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MainController {

    public static void main(String[] args) {
        System.out.println("Success");
        UserController userController = new UserController();
        BusController busController = new BusController();
        RouteController routeController = new RouteController();
        BookingController bookingController = new BookingController();
        PaymentController paymentController = new PaymentController();

        UserRepository userRepository = new UserRepository();
        BusRepository busRepository = new BusRepository();
        RouteRepository routeRepository = new RouteRepository();
        BookingRepository bookingRepository = new BookingRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        Scanner sc = new Scanner(System.in);

        String choice;

        do {
            System.out.println(".................................");
            System.out.println("Choose the operation from below:");
            System.out.println(".................................");
            System.out.println("Enter 1 for User");
            System.out.println("Enter 2 for Bus");
            System.out.println("Enter 3 for Route");
            System.out.println("Enter 4 for Booking");
            System.out.println("Enter 5 for Payment");
            System.out.println("Enter 6 to exit");
            choice = sc.next();
            switch (choice) {
                case "1":
                    userController.crudOption(userRepository);
                    System.out.println("..........................");
                    break;
                case "2":
                    busController.crudOption(busRepository);
                    System.out.println("...........................");
                    break;
                case "3":
                    routeController.crudOption(routeRepository);
                    System.out.println("............................");
                    break;
                case "4":
                    bookingController.crudOption(bookingRepository, userRepository, busRepository, routeRepository);
                    System.out.println(".............................");
                    break;
                case "5":
                    paymentController.crudOption(paymentRepository, bookingRepository);
                    System.out.println(".............................");
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        } while (!choice.equals("0"));
    }
}
