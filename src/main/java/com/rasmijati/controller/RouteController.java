/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Route;
import com.rasmijati.repository.RouteRepository;
import com.rasmijati.util.FareCalculation;
import static com.rasmijati.util.validator.isValidateNumber;
import static com.rasmijati.util.validator.isValidateString;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class RouteController {

    private static RouteRepository routeRepository;

    public void crudOption(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        Scanner sc = new Scanner(System.in);

        String choice;

        do {
            System.out.println(".................................");
            System.out.println("Choose the operation from below:");
            System.out.println(".................................");
            System.out.println("Enter 1 to create");
            System.out.println("Enter 2 to list");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to edit");
            System.out.println("Enter 5 to exit");
            choice = sc.next();
            switch (choice) {
                case "1":
                    create();
                    System.out.println("..........................");
                    break;
                case "2":
                    list();
                    System.out.println("...........................");
                    break;
                case "3":
                    delete();
                    System.out.println("............................");
                    break;
                case "4":
                    edit();
                    System.out.println(".............................");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        } while (!choice.equals("0"));
    }

    public static void create() {
        Long id = null;
        String starting_point = null;
        String destination = null;
        String distance = null;
        BigDecimal price = null;
        FareCalculation calc = new FareCalculation();
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter Route id : ");
            String rid = sc.next();
            try {
                id = Long.parseLong(rid);
            } catch (Exception e) {
                System.err.println("Error");
            }
        }

        while (starting_point == null || starting_point.isEmpty()) {
            System.out.println("Enter Starting point : ");
            starting_point = sc.next();
            if (!isValidateString(starting_point)) {
                System.err.println("Invaild starting point !!");
                System.err.println("Starting point should be in string !!");
                starting_point = null;
            }
        }
        while (destination == null || destination.isEmpty()) {
            System.out.println("Enter destination : ");
            destination = sc.next();
            if (!isValidateString(destination)) {
                System.err.println("Invaild destination !!");
                System.err.println("Destination should be in string !!");
                destination = null;
            }
        }
        while (distance == null || distance.isEmpty()) {
            System.out.println("Enter distance : ");
            distance = sc.next();
            if (!isValidateNumber(distance)) {
                System.err.println("Invaild Distance !!");
                System.err.println("Distance should be in number !!");
                distance = null;
            }
        }

        price = calc.calculateFareByDistance(distance);
        System.out.println("Price based on the distance : " + price);

        Route route = new Route(id, starting_point, destination, distance, price);

        routeRepository.create(route);

        System.out.println(
                "Route Created Successfuly");
    }

    public static void list() {
        System.out.println("...........Route List...........");
        routeRepository.findAll()
                .stream()
                .forEach(x -> System.out.println(x));
    }

    public static void delete() {
        Long id = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to delete route: ");
        id = sc.nextLong();
        Route r = routeRepository.findById(id);
        if (r == null) {
            System.out.println("Route of Id" + id + " not found ");
        } else {
            routeRepository.delete(r);
            System.out.println("Route deleted successfully");
        }
    }

    public static void edit() {
        Long id = null;
        String starting_point = null;
        String destination = null;
        String distance = null;
        BigDecimal price = null;
        FareCalculation calc = new FareCalculation();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to edit route: ");
        id = sc.nextLong();
        Route r = routeRepository.findById(id);
        if (r == null) {
            System.out.println("Route of Id " + id + " not found");
        } else {
            while (starting_point == null || starting_point.isEmpty()) {
                System.out.println("Enter Starting point : ");
                starting_point = sc.next();
                if (!isValidateString(starting_point)) {
                    System.err.println("Invaild starting point !!");
                    System.err.println("Starting point should be in string !!");
                    starting_point = null;
                }
            }
            while (destination == null || destination.isEmpty()) {
                System.out.println("Enter destination : ");
                destination = sc.next();
                if (!isValidateString(destination)) {
                    System.err.println("Invaild destination !!");
                    System.err.println("Destination should be in string !!");
                    destination = null;
                }
            }
            while (distance == null || distance.isEmpty()) {
                System.out.println("Enter distance : ");
                distance = sc.next();
                if (!isValidateNumber(distance)) {
                    System.err.println("Invaild Distance !!");
                    System.err.println("Distance should be in number !!");
                    distance = null;
                }
            }
            price = calc.calculateFareByDistance(distance);
            System.out.println("Price based on the distance : " + price);

            Route route = new Route(id, starting_point, destination, distance, price);
            routeRepository.edit(route);
            System.out.println("Route Edited Successfully");
        }
    }
}
