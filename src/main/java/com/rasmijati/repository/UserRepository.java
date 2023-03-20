/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;

/**
 *
 * @author admin
 */
public class UserRepository extends AbstractRepository<User>{

    @Override
    public void edit(User u) {
        super.findAll().stream()
                .filter(x -> x.getId()
                .equals(u.getId()))
                .forEach(user -> {
                    user.setName(u.getName());
                    user.setEmail(u.getEmail());
                    user.setPhone(u.getPhone());
                    user.setPassword(u.getPassword());
                }
                );
    }
}
