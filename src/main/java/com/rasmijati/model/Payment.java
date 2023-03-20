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
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.booking);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.total_amount);
        hash = 53 * hash + Objects.hashCode(this.paid_amount);
        hash = 53 * hash + Objects.hashCode(this.due_amount);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Payment)) {
            return false;
        }
        final Payment other = (Payment) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.booking, other.booking)) {
            return false;
        }
        if (!Objects.equals(this.total_amount, other.total_amount)) {
            return false;
        }
        if (!Objects.equals(this.paid_amount, other.paid_amount)) {
            return false;
        }
        return Objects.equals(this.due_amount, other.due_amount);
    }

    @Override
    public String toString() {
        return "id=" + id + ", booking=" + booking + ", date=" + date + ", paid_amount=" + paid_amount + ", total_amount=" + total_amount + ", due_amount=" + due_amount;
    }

}
