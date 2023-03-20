/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Payment;

/**
 *
 * @author admin
 */
public class PaymentRepository extends AbstractRepository<Payment> {

    @Override
    public void edit(Payment p) {
        super.findAll().stream()
                .filter(x -> x.getId()
                .equals(p.getId()))
                .forEach(x -> {
                    x.setBooking(p.getBooking());
                    x.setDate(p.getDate());
                    x.setPaid_amount(p.getPaid_amount());
                    x.setTotal_amount(p.getTotal_amount());
                    x.setDue_amount(p.getDue_amount());
                });
    }
}
