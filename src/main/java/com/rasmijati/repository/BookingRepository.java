/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Booking;

/**
 *
 * @author admin
 */
public class BookingRepository extends AbstractRepository<Booking> {

    @Override
    public void edit(Booking b) {
        super.findAll().stream()
                .filter(x -> x.getId()
                .equals(b.getId()))
                .forEach(x -> {
                    x.setBus(b.getBus());
                    x.setRoute(b.getRoute());
                    x.setUser(b.getUser());
                    x.setDate(b.getDate());
                    x.setSeats(b.getSeats());
                    x.setFare(b.getFare());
                });
    }
}
