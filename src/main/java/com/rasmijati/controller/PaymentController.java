/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Booking;
import com.rasmijati.model.Payment;
import com.rasmijati.repository.BookingRepository;
import com.rasmijati.repository.PaymentRepository;
import com.rasmijati.util.FareCalculation;
import static com.rasmijati.util.validator.isvalidateDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class PaymentController {

    private static PaymentRepository paymentRepository;
    private static BookingRepository bookingRepository;

    public void crudOption(PaymentRepository paymentRepository, BookingRepository bookingRepository) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
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
        Booking booking = null;
        String date = null;
        BigDecimal total_amount = null;
        BigDecimal paid_amount = null;
        BigDecimal due_amount = null;
        Scanner sc = new Scanner(System.in);
        FareCalculation calc = new FareCalculation();
        while (id == null) {
            System.out.println("Enter Payment id : ");
            String bid = sc.next();
            try {
                id = Long.parseLong(bid);
            } catch (Exception e) {
                System.err.println("Error");
            }
        }

        List<Booking> bookings = bookingRepository.findAll();
        while (booking == null) {
            System.out.println("--------Booking Info----------- : ");
            System.out.println(bookings);
            Long booking_id = null;
            while (booking_id == null) {
                System.out.println("Enter Booking id : ");
                booking_id = sc.nextLong();
            }
            booking = bookingRepository.findById(booking_id);
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

        total_amount = booking.getFare();
        System.out.println("Total Amount : " + total_amount);

        while (paid_amount == null) {
            System.out.println("Enter amount to be paid : ");
            paid_amount = sc.nextBigDecimal();
            if (paid_amount.compareTo(total_amount) <= 0) {
                break;
            } else {
                System.err.println("Paid amount is more than total amount !! Payment failed!!!!");
                return;
            }
        }

        due_amount = calc.RemainingDue(total_amount, paid_amount);
        System.out.println("Remaining due : " + due_amount);

        Payment p = new Payment(id, booking, date, total_amount, paid_amount, due_amount);
        p.setBooking(booking);
        paymentRepository.create(p);
        System.out.println("Payment Done successfully");
    }

    public static void list() {
        System.out.println("...........Payment List...........");
        paymentRepository.findAll()
                .stream()
                .forEach(x -> System.out.println(x));
    }

    public static void delete() {
        Long id = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to delete payment: ");
        id = sc.nextLong();
        Payment p = paymentRepository.findById(id);
        if (p == null) {
            System.out.println("Payment of Id" + id + " not found ");
        } else {
            paymentRepository.delete(p);
            System.out.println("Payment deleted successfully");
        }
    }

    public static void edit() {
        Long id = null;
        Booking booking = null;
        String date = null;
        BigDecimal total_amount = null;
        BigDecimal paid_amount = null;
        BigDecimal due_amount = null;
        Scanner sc = new Scanner(System.in);
        FareCalculation calc = new FareCalculation();
        System.out.println("Enter id to edit payment: ");
        id = sc.nextLong();
        Payment p = paymentRepository.findById(id);
        if (p == null) {
            System.out.println("Payment of Id" + id + " not found ");
        } else {

            List<Booking> bookings = bookingRepository.findAll();
            while (booking == null) {
                System.out.println("--------Booking Info----------- : ");
                System.out.println(bookings);
                Long booking_id = null;
                while (booking_id == null) {
                    System.out.println("Enter booking id : ");
                    booking_id = sc.nextLong();
                }
                booking = bookingRepository.findById(booking_id);
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

            total_amount = booking.getFare();
            System.out.println("Total Amount : " + total_amount);

            while (paid_amount == null) {
                System.out.println("Enter amount to be paid : ");
                paid_amount = sc.nextBigDecimal();
                if (paid_amount.compareTo(total_amount) <= 0) {
                    break;
                } else {
                    System.err.println("Paid amount is more than total amount !! Payment failed!!!!");
                    return;
                }
            }

            due_amount = calc.RemainingDue(total_amount, paid_amount);
            System.out.println("Remaining due : " + due_amount);

            Payment pay = new Payment(id, booking, date, total_amount, paid_amount, due_amount);

            pay.setBooking(booking);
            paymentRepository.edit(pay);
            System.out.println("Payment edited successfully");
        }
    }
}
