/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.Bus;

/**
 *
 * @author admin
 */
public class BusController {
    public static void main(String[] args) {
        Bus b = new Bus(1L, "2528", "mini", "20");
        System.out.println("Bus : " + b);
    }
}
