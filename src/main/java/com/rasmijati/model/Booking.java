/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class Booking implements IEntity{

    private Long id;
    private User user;
    private Bus bus;
    private Route route;
    private String date;
    private String seats;
    private BigDecimal fare;

    public Booking(Long id, User user, Bus bus, Route route, String date, String seats, BigDecimal fare) {
        this.id = id;
        this.user = user;
        this.bus = bus;
        this.route = route;
        this.date = date;
        this.seats = seats;
        this.fare = fare;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.user);
        hash = 47 * hash + Objects.hashCode(this.bus);
        hash = 47 * hash + Objects.hashCode(this.route);
        hash = 47 * hash + Objects.hashCode(this.date);
        hash = 47 * hash + Objects.hashCode(this.seats);
        hash = 47 * hash + Objects.hashCode(this.fare);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Booking)) {
            return false;
        }
        final Booking other = (Booking) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.bus, other.bus)) {
            return false;
        }
        if (!Objects.equals(this.route, other.route)) {
            return false;
        }
        if (!Objects.equals(this.seats, other.seats)) {
            return false;
        }
        return Objects.equals(this.fare, other.fare);
    }

    @Override
    public String toString() {
        return "id=" + id + ", user=" + user + ", bus=" + bus + ", route=" + route + ", date=" + date + ", seats=" + seats + ", fare=" + fare;
    }

}
