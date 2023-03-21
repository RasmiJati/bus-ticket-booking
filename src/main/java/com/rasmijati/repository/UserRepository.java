/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRepository extends AbstractRepository<User> {

    Connection con = connectDB();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void create(User u) {

        try {
            String insert = "insert into user(name,email,phone, password) values(?,?,?,?)";
            stmt = con.prepareStatement(insert);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getPassword());
            int i = stmt.executeUpdate();
            System.out.println(i + " Inserted successfull!!");

        } catch (SQLException e) {
            System.out.println("Insertion failed!!!");
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            String query = "select *from user";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!!");
        }
        return list;

    }

    @Override
    public User findById(Long id) {
        User user = new User();
        try {
            String query = "select *from user where id = ?";
            stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!");
        }
        return user;
    }

    @Override
    public void delete(User u) {
        try {
            String delete = "delete from user where id = ?";
            stmt = con.prepareStatement(delete);
            stmt.setLong(1, u.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Deleted successfully!!");
        } catch (SQLException e) {
            System.out.println("Deletion Failed!!!!");
        }
    }

    @Override
    public void edit(User u) {
        try {
            String edit = "update user set name = ?, email = ? , phone = ? , password = ? where id = ?";
            stmt = con.prepareStatement(edit);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getPassword());
            stmt.setLong(5, u.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Edited Successfully!!");
        } catch (SQLException e) {
            System.out.println("Edition Failed!!");
        }
    }
}
