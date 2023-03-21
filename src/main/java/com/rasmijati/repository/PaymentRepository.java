/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Booking;
import com.rasmijati.model.Payment;
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
public class PaymentRepository extends AbstractRepository<Payment> {

    Connection con = connectDB();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void create(Payment p) {

        try {
            String insert = "insert into payment(booking,date,total_amount, paid_amount, due_amount) values(?,?,?,?,?)";
            stmt = con.prepareStatement(insert);
            stmt.setLong(1, p.getBooking().getId());
            stmt.setString(2, p.getDate());
            stmt.setBigDecimal(3, p.getTotal_amount());
            stmt.setBigDecimal(4, p.getPaid_amount());
            stmt.setBigDecimal(5, p.getDue_amount());
            int i = stmt.executeUpdate();
            System.out.println(i + " Inserted successfull!!");

        } catch (SQLException e) {
            System.out.println("Insertion failed!!!");
        }
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> list = new ArrayList<>();
        try {
            String query = "select *from payment";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment(rs.getLong(1), new Booking(rs.getLong(2)), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getBigDecimal(6));
                list.add(payment);
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!!");
        }
        return list;

    }

    @Override
    public Payment findById(Long id) {
        Payment payment = new Payment();
        try {
            String query = "select *from payment where id = ?";
            stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                payment = new Payment(rs.getLong(1), new Booking(rs.getLong(2)), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getBigDecimal(6));
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!");
        }
        return payment;
    }

    @Override
    public void delete(Payment p) {
        try {
            String delete = "delete from payment where id = ?";
            stmt = con.prepareStatement(delete);
            stmt.setLong(1, p.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Deleted successfully!!");
        } catch (SQLException e) {
            System.out.println("Deletion Failed!!!!");
        }
    }

    @Override
    public void edit(Payment p) {
        try {
            String edit = "update booking set booking = ?, date = ? , total_amount = ? , paid_amount = ?, due_amount = ? where id = ?";
            stmt = con.prepareStatement(edit);
            stmt.setLong(1, p.getBooking().getId());
            stmt.setString(2, p.getDate());
            stmt.setBigDecimal(3, p.getTotal_amount());
            stmt.setBigDecimal(4, p.getPaid_amount());
            stmt.setBigDecimal(5, p.getDue_amount());
            stmt.setLong(6, p.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Edited Successfully!!");
        } catch (SQLException e) {
            System.out.println("Edition Failed!!");
        }
    }
}
