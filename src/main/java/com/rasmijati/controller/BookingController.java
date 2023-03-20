/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Booking;
import com.rasmijati.model.Bus;
import com.rasmijati.model.Route;
import com.rasmijati.model.User;
import com.rasmijati.repository.BookingRepository;
import com.rasmijati.repository.BusRepository;
import com.rasmijati.repository.RouteRepository;
import com.rasmijati.repository.UserRepository;
import com.rasmijati.util.FareCalculation;
import static com.rasmijati.util.validator.isValidateNumber;
import static com.rasmijati.util.validator.isvalidateDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BookingController {

    private static BookingRepository bookingRepository;
    private static UserRepository userRepository;
    private static BusRepository busRepository;
    private static RouteRepository routeRepository;

    public void crudOption(BookingRepository bookingRepository, UserRepository userRepository, BusRepository busRepository, RouteRepository routeRepository) {

//        BookingController.BookingRepository = BookingRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
        Scanner sc = new Scanner(System.in);
        FareCalculation calc = new FareCalculation();
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
        User user = null;
        Bus bus = null;
        Route route = null;
        String date = null;
        String seats = null;
        BigDecimal fare = null;
        Scanner sc = new Scanner(System.in);
        FareCalculation calc = new FareCalculation();
        while (id == null) {
            System.out.println("Enter Booking id : ");
            String bid = sc.next();
            try {
                id = Long.parseLong(bid);
            } catch (Exception e) {
                System.err.println("Error");
            }
        }

        List<User> users = userRepository.findAll();
        while (user == null) {
            System.out.println("--------User Info----------- : ");
            System.out.println(users);
            Long user_id = null;
            while (user_id == null) {
                System.out.println("Enter user id : ");
                user_id = sc.nextLong();
            }
            user = userRepository.findById(user_id);
        }

        List<Bus> buses = busRepository.findAll();
        while (bus == null) {
            System.out.println("--------Bus Info----------- : ");
            System.out.println(buses);
            Long bus_id = null;
            while (bus_id == null) {
                System.out.println("Enter bus id : ");
                bus_id = sc.nextLong();
            }
            bus = busRepository.findById(bus_id);
        }

        List<Route> routes = routeRepository.findAll();
        while (route == null) {
            System.out.println("--------Route Info----------- : ");
            System.out.println(routes);
            Long route_id = null;
            while (route_id == null) {
                System.out.println("Enter route id : ");
                route_id = sc.nextLong();
            }
            route = routeRepository.findById(route_id);
        }

        while (date == null || date.isEmpty()) {
            System.out.println("Enter date : ");
            date = sc.next();
            if (!isvalidateDate(date)) {
                System.err.println("Invaild date !!");
                System.err.println("Date should be in yyyy-mm-dd format !!");
                date = null;
            }
        }

        while (seats == null || seats.isEmpty()) {
            System.out.println("Enter seats : ");
            seats = sc.next();
            if (!isValidateNumber(seats)) {
                System.err.println("Invaild seats !!");
                System.err.println("Seats should be in number !!");
                seats = null;
            }
        }

        fare = calc.calculateFare(route.getPrice(), seats);
        System.out.println("Total fare : " + fare);

        Booking book = new Booking(id, user, bus, route, date, seats, fare);

        book.setUser(user);

        book.setBus(bus);

        book.setRoute(route);

        bookingRepository.create(book);

        System.out.println(
                "Booking created successfully");
    }

    public static void list() {
        System.out.println("...........Booking List...........");
        bookingRepository.findAll()
                .stream()
                .forEach(x -> System.out.println(x));
    }

    public static void delete() {
        Long id = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to delete boking: ");
        id = sc.nextLong();
        Booking b = bookingRepository.findById(id);
        if (b == null) {
            System.out.println("Booking of Id" + id + " not found ");
        } else {
            bookingRepository.delete(b);
            System.out.println("Booking deleted successfully");
        }
    }

    public static void edit() {
        Long id = null;
        User user = null;
        Bus bus = null;
        Route route = null;
        String date = null;
        String seats = null;
        BigDecimal fare = null;
        Scanner sc = new Scanner(System.in);
        FareCalculation calc = new FareCalculation();
        System.out.println("Enter id to edit booking: ");
        id = sc.nextLong();
        Booking b = bookingRepository.findById(id);
        if (b == null) {
            System.out.println("Booking of Id" + id + " not found ");
        } else {
            List<User> users = userRepository.findAll();
            while (user == null) {
                System.out.println("--------User Info----------- : ");
                System.out.println(users);
                Long user_id = null;
                while (user_id == null) {
                    System.out.println("Enter user id : ");
                    user_id = sc.nextLong();
                }
                user = userRepository.findById(user_id);
            }

            List<Bus> buses = busRepository.findAll();
            while (bus == null) {
                System.out.println("--------Bus Info----------- : ");
                System.out.println(buses);
                Long bus_id = null;
                while (bus_id == null) {
                    System.out.println("Enter bus id : ");
                    bus_id = sc.nextLong();
                }
                bus = busRepository.findById(bus_id);
            }

            List<Route> routes = routeRepository.findAll();
            while (route == null) {
                System.out.println("--------Route Info----------- : ");
                System.out.println(routes);
                Long route_id = null;
                while (route_id == null) {
                    System.out.println("Enter route id : ");
                    route_id = sc.nextLong();
                }
                route = routeRepository.findById(route_id);
            }

            while (date == null || date.isEmpty()) {
                System.out.println("Enter date : ");
                date = sc.next();
                if (!isvalidateDate(date)) {
                    System.err.println("Invaild date !!");
                    System.err.println("Date should be in yyyy-mm-dd format !!");
                    date = null;
                }
            }

            while (seats == null || seats.isEmpty()) {
                System.out.println("Enter seats : ");
                seats = sc.next();
                if (!isValidateNumber(seats)) {
                    System.err.println("Invaild seats !!");
                    System.err.println("Seats should be in number !!");
                    seats = null;
                }
            }
            fare = calc.calculateFare(route.getPrice(), seats);
            System.out.println("Total fare : " + fare);

            Booking book = new Booking(id, user, bus, route, date, seats, fare);
            bookingRepository.edit(book);
            System.out.println("Booking edited successfully");
        }
    }
}
