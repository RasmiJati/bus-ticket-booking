/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Bus;

/**
 *
 * @author admin
 */
public class BusRepository extends AbstractRepository<Bus> {

    @Override
    public void edit(Bus b) {
        super.findAll().stream()
                .filter(x -> x.getId()
                .equals(b.getId()))
                .forEach(x -> {
                    x.setNumber(b.getNumber());
                    x.setSeats(b.getSeats());
                    x.setType(b.getType());
                }
                );
    }

}
