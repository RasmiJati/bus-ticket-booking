/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Bus;
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
public class BusRepository extends AbstractRepository<Bus> {

    Connection con = connectDB();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void create(Bus b) {

        try {
            String insert = "insert into bus(bus_number,bus_type,seats) values(?,?,?)";
            stmt = con.prepareStatement(insert);
            stmt.setString(1, b.getNumber());
            stmt.setString(2, b.getType());
            stmt.setString(3, b.getSeats());
            int i = stmt.executeUpdate();
            System.out.println(i + " Inserted successfull!!");

        } catch (SQLException e) {
            System.out.println("Insertion failed!!!");
        }
    }

    @Override
    public List<Bus> findAll() {
        List<Bus> list = new ArrayList<>();
        try {
            String query = "select *from bus";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bus bus = new Bus(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(bus);
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!!");
        }
        return list;

    }

    @Override
    public Bus findById(Long id) {
        Bus bus = new Bus();
        try {
            String query = "select *from bus where id = ?";
            stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                bus = new Bus(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!");
        }
        return bus;
    }

    @Override
    public void delete(Bus b) {
        try {
            String delete = "delete from bus where id = ?";
            stmt = con.prepareStatement(delete);
            stmt.setLong(1, b.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Deleted successfully!!");
        } catch (SQLException e) {
            System.out.println("Deletion Failed!!!!");
        }
    }

    @Override
    public void edit(Bus b) {
        try {
            String edit = "update bus set bus_number = ?, bus_type = ? , seats = ? where id = ?";
            stmt = con.prepareStatement(edit);
            stmt.setString(1, b.getNumber());
            stmt.setString(2, b.getType());
            stmt.setString(3, b.getSeats());
            stmt.setLong(4, b.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Edited Successfully!!");
        } catch (SQLException e) {
            System.out.println("Edition Failed!!");
        }
    }
}
