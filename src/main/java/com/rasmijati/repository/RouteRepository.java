/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Route;

/**
 *
 * @author admin
 */
public class RouteRepository extends AbstractRepository<Route> {

    @Override
    public void edit(Route r) {
        super.findAll().stream()
                .filter(x -> x.getId()
                .equals(r.getId()))
                .forEach(x -> {
                    x.setDistance(r.getDistance());
                    x.setStarting_point(r.getStarting_point());
                    x.setDestination(r.getDestination());
                    x.setPrice(r.getPrice());
                });
    }
}
