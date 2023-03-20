/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Bus;
import com.rasmijati.repository.BusRepository;
import static com.rasmijati.util.validator.isValidateNumber;
import static com.rasmijati.util.validator.isValidateString;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BusController {

    private static BusRepository busRepository;

    public void crudOption(BusRepository busRepository) {
        this.busRepository = busRepository;
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println(".................................................................");
            System.out.println("Choose an operation from below : ");
            System.out.println("..................................................................");
            System.out.println("Enter 1 to create");
            System.out.println("Enter 2 to list");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to edit");
            System.out.println("Enter 5 to exit");
            System.out.println(".................................................................");
            choice = sc.next();
            switch (choice) {
                case "1":
                    create();
                    System.out.println("..................................................");
                    break;
                case "2":
                    list();
                    System.out.println(".......................................................");
                    break;
                case "3":
                    delete();
                    System.out.println(".......................................................");
                    break;
                case "4":
                    edit();
                    System.out.println(".......................................................");
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option");
            }
        } while (!choice.equals("0"));
    }

    public static void create() {
        Long id = null;
        String number = null;
        String type = null;
        String seats = null;
        Scanner sc = new Scanner(System.in);
        while (id == null) {
            System.out.println("Enter Bus Id : ");
            String bid = sc.next();
            try {
                id = Long.parseLong(bid);
            } catch (Exception e) {
                System.err.println("Error");
                id = null;
            }
        }
        while (number == null || number.isEmpty()) {
            System.out.println("Enter bus number : ");
            number = sc.next();
            if (!isValidateNumber(number)) {
                System.err.println("Invaild Bus Number !!");
                System.err.println("Bus Number should be in number !!");
                number = null;
            }
        }

        while (type == null || type.isEmpty()) {
            System.out.println("Enter bus type:");
            type = sc.next();
            if (!isValidateString(type)) {
                System.err.println("Invaild Bus type !!");
                System.err.println("Bus type should be in string !!");
                type = null;
            }
        }
        while (seats == null || seats.isEmpty()) {
            System.out.println("Enter number of seat: ");
            seats = sc.next();
            if (!isValidateNumber(seats)) {
                System.err.println("Invaild seats !!");
                System.err.println("Seats should be in number !!");
                seats = null;
            }
        }

        Bus bus = new Bus(id, number, type, seats);
        busRepository.create(bus);
        System.out.println("Bus Created Successfully");
    }

    public static void list() {
        System.out.println("....................All Bus List....................");
        busRepository.findAll()
                .stream()
                .forEach(x -> System.out.println(x));
    }

    public static void delete() {
        System.out.println("Enter Id of bus to delete : ");
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        Bus bus = busRepository.findById(id);
        if (bus == null) {
            System.out.println("Bus with id " + id + "not found ");
        } else {
            busRepository.delete(bus);
            System.out.println("Bus with id " + id + "deleted successfully");
        }
    }

    public static void edit() {
        Long id = null;
        String number = null;
        String type = null;
        String seats = null;
        Scanner sc = new Scanner(System.in);
        System.out.println(".........Edit Operation........");
        System.out.println("Enter Bus id : ");
        String bid = sc.next();
        try {
            id = Long.parseLong(bid);
        } catch (NumberFormatException e) {
            System.err.println("Error");
            id = null;
        }
        Bus bus = busRepository.findById(id);
        if (bus == null) {
            System.out.println("Bus of id  " + id + " not found:");
        } else {
            while (number == null || number.isEmpty()) {
                System.out.println("Enter bus number : ");
                number = sc.next();
                if (!isValidateNumber(number)) {
                    System.err.println("Invaild Bus Number !!");
                    System.err.println("Bus Number should be in number !!");
                    number = null;
                }
            }

            while (type == null || type.isEmpty()) {
                System.out.println("Enter bus type:");
                type = sc.next();
                if (!isValidateString(type)) {
                    System.err.println("Invaild Bus type !!");
                    System.err.println("Bus type should be in string !!");
                    type = null;
                }
            }
            while (seats == null || seats.isEmpty()) {
                System.out.println("Enter number of seat: ");
                seats = sc.next();
                if (!isValidateNumber(seats)) {
                    System.err.println("Invaild seats !!");
                    System.err.println("Seats should be in number !!");
                    seats = null;
                }
            }
            Bus b = new Bus(id, number, type, seats);
            busRepository.edit(b);
            System.out.println("Bus Edited Successfully");
        }
    }
}
