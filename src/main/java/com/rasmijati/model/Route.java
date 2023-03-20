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
public class Route implements IEntity{

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
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
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.starting_point);
        hash = 89 * hash + Objects.hashCode(this.destination);
        hash = 89 * hash + Objects.hashCode(this.distance);
        hash = 89 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Route)) {
            return false;
        }
        final Route other = (Route) obj;
        if (!Objects.equals(this.starting_point, other.starting_point)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        if (!Objects.equals(this.distance, other.distance)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "id=" + id + ", starting_point=" + starting_point + ", destination=" + destination + ", distance=" + distance + ", price=" + price;
    }

}
