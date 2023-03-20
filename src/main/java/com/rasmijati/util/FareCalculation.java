/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.util;

import java.math.BigDecimal;

/**
 *
 * @author admin
 */
public class FareCalculation {

    public static BigDecimal calculateFareByDistance(String distance) {
        final BigDecimal farePerDistance = new BigDecimal("50");
        BigDecimal distanceValue = new BigDecimal(distance);
        BigDecimal price = farePerDistance.multiply(distanceValue);
        return price;
    }

    public static BigDecimal calculateFare(BigDecimal price, String seats) {
        BigDecimal seatsValue = new BigDecimal(seats);
        return price.multiply(seatsValue);
    }

    public static BigDecimal RemainingDue(BigDecimal total_amount, BigDecimal paid_amount) {
        return total_amount.subtract(paid_amount);
    }
}
