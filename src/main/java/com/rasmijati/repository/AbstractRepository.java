/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.IEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class AbstractRepository<T extends IEntity> {

    private List<T> list;

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
