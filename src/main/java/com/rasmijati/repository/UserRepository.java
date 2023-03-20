/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRepository {

    private List<User> user_list;

    public UserRepository() {
        this.user_list = new ArrayList<>();
    }

    public void create(User u) {
        this.user_list.add(u);
    }

    public List<User> findAll() {
        return this.user_list;
    }

    public User findById(Long id) {
        for (User u : user_list) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void edit(User u) {
        this.user_list.stream()
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
