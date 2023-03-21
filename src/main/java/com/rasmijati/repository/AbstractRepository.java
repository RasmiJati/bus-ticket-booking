/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.IEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class AbstractRepository<T extends IEntity> {

    private List<T> list;
    public Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking", "root", "R@smi1234");
            return con;
        } catch (Exception e) {
            System.out.println("Connection failed!!");
        }
        return null;
    }

    public AbstractRepository() {
        this.list = new ArrayList<>();
    }

    public void create(T t) {
        this.list.add(t);
    }

    public List<T> findAll() {
        return this.list;
    }

    public T findById(Long id) {
        for (T t : list) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public void delete(T list) {
        this.list.remove(list);
    }

    public void edit(T e) {

    }
}
