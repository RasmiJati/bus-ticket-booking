/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.model;

/**
 *
 * @author admin
 */
public class Bus {

    private Long id;
    private String number;
    private String type;
    private String seats;

    public Bus(Long id, String number, String type, String seats) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "id=" + id + ", number=" + number + ", type=" + type + ", seats=" + seats ;
    }
    
    
}
