/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;

/**
 *
 * @author admin
 */
public class UserController {

    public static void main(String[] args) {
        User u = new User(1L, "rasmi", "rasmi@gmail.com", "9841526378", "rasmi");
        System.out.println("user : " + u.toString());
        System.out.println("user : " + u);
    }
}
