/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Booking;
import com.rasmijati.model.Bus;
import com.rasmijati.model.Route;
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
public class BookingRepository extends AbstractRepository<Booking> {

    Connection con = connectDB();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void create(Booking b) {

        try {
            String insert = "insert into booking(user,bus,route,date,seats,fare) values(?,?,?,?,?,?)";
            stmt = con.prepareStatement(insert);
            stmt.setLong(1, b.getUser().getId());
            stmt.setLong(2, b.getBus().getId());
            stmt.setLong(3, b.getRoute().getId());
            stmt.setString(4, b.getDate());
            stmt.setString(5, b.getSeats());
            stmt.setBigDecimal(6, b.getFare());

            int i = stmt.executeUpdate();
            System.out.println(i + " Inserted successfull!!");

        } catch (SQLException e) {
            System.out.println("Insertion failed!!!");
        }
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>();
        try {
            String query = "select *from booking";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking(rs.getLong(1), new User(rs.getLong(2)), new Bus(rs.getLong(3)), new Route(rs.getLong(4)), rs.getString(5), rs.getString(6), rs.getBigDecimal(7));
                list.add(booking);
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!!");
        }
        return list;

    }

    @Override
    public Booking findById(Long id) {
        Booking booking = new Booking();
        try {
            String query = "select *from booking where id = ?";
            stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                booking = new Booking(rs.getLong(1), new User(rs.getLong(2)), new Bus(rs.getLong(3)), new Route(rs.getLong(4)), rs.getString(5), rs.getString(6), rs.getBigDecimal(7));
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!");
        }
        return booking;
    }

    @Override
    public void delete(Booking b) {
        try {
            String delete = "delete from booking where id = ?";
            stmt = con.prepareStatement(delete);
            stmt.setLong(1, b.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Deleted successfully!!");
        } catch (SQLException e) {
            System.out.println("Deletion Failed!!!!");
        }
    }

    @Override
    public void edit(Booking b) {
        try {
            String edit = "update booking set user = ?, bus = ? , route = ? , date = ?, seats = ?, fare = ? where id = ?";
            stmt = con.prepareStatement(edit);
            stmt.setLong(1, b.getUser().getId());
            stmt.setLong(2, b.getBus().getId());
            stmt.setLong(3, b.getRoute().getId());
            stmt.setString(4, b.getDate());
            stmt.setString(5, b.getSeats());
            stmt.setBigDecimal(6, b.getFare());
            stmt.setLong(7, b.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Edited Successfully!!");
        } catch (SQLException e) {
            System.out.println("Edition Failed!!");
        }
    }
}
