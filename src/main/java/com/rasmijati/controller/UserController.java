/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.controller;

import com.rasmijati.model.User;
import com.rasmijati.repository.UserRepository;

/**
 *
 * @author admin
 */
public class UserController {

    private static UserRepository userRepository;

    public static void main(String[] args) {
        User u = new User(1L, "rasmi", "rasmi@gmail.com", "9841526378", "rasmi");
        userRepository.create(u);
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findById(2L));

    }
}
