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
public class Route {

    private Long id;
    private String starting_point;
    private String destination;
    private String distance;
    private BigDecimal price;

    public Route(Long id, String starting_point, String destination, String distance, BigDecimal price) {
        this.id = id;
        this.starting_point = starting_point;
        this.destination = destination;
        this.distance = distance;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStarting_point() {
        return starting_point;
    }

    public void setStarting_point(String starting_point) {
        this.starting_point = starting_point;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id + ", starting_point=" + starting_point + ", destination=" + destination + ", distance=" + distance + ", price=" + price ;
    }

}
