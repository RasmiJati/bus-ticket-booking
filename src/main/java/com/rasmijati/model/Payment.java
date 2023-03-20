/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.model;

import java.math.BigDecimal;

/**
 *
 * @author admin
 */
public class Payment {

    private Long id;
    private Booking booking;
    private String date;
    private BigDecimal paid_amount;
    private BigDecimal total_amount;
    private BigDecimal due_amount;

    public Payment(Long id, Booking booking, String date, BigDecimal paid_amount, BigDecimal total_amount, BigDecimal due_amount) {
        this.id = id;
        this.booking = booking;
        this.date = date;
        this.paid_amount = paid_amount;
        this.total_amount = total_amount;
        this.due_amount = due_amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(BigDecimal paid_amount) {
        this.paid_amount = paid_amount;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public BigDecimal getDue_amount() {
        return due_amount;
    }

    public void setDue_amount(BigDecimal due_amount) {
        this.due_amount = due_amount;
    }

    @Override
    public String toString() {
        return "id=" + id + ", booking=" + booking + ", date=" + date + ", paid_amount=" + paid_amount + ", total_amount=" + total_amount + ", due_amount=" + due_amount;
    }

}
