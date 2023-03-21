/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasmijati.repository;

import com.rasmijati.model.Route;
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
public class RouteRepository extends AbstractRepository<Route> {

    Connection con = connectDB();
    PreparedStatement stmt;
    ResultSet rs;

    @Override
    public void create(Route r) {
        try {
            String insert = "insert into route(starting_point,destination,distance,price) values (?,?,?,?)";
            stmt = con.prepareStatement(insert);
            stmt.setString(1, r.getStarting_point());
            stmt.setString(2, r.getDestination());
            stmt.setString(3, r.getDistance());
            stmt.setBigDecimal(4, r.getPrice());
            int i = stmt.executeUpdate();
            System.out.println(i + " Inserted successfull!!");
        } catch (SQLException e) {
            System.out.println("Insertion Failed!!!");
        }
    }

    @Override
    public List<Route> findAll() {
        List<Route> list = new ArrayList<>();
        try {
            String query = "select *from route";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Route user = new Route(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!!");
        }
        return list;
    }

    @Override
    public Route findById(Long id) {
        Route route = new Route();
        try {
            String query = "select *from route where id = ?";
            stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                route = new Route(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5));
            }
        } catch (SQLException e) {
            System.out.println("Record Display Failed!!");
        }
        return route;
    }

    @Override
    public void delete(Route r) {
        try {
            String delete = "delete from route where id = ?";
            stmt = con.prepareStatement(delete);
            stmt.setLong(1, r.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Deleted successfully!!");
        } catch (SQLException e) {
            System.out.println("Deletion Failed!!!!");
        }
    }

    @Override
    public void edit(Route r) {
        try {
            String edit = "update route set starting_point = ?, destination = ? , distance = ? , price = ? where id = ?";
            stmt = con.prepareStatement(edit);
            stmt.setString(1, r.getStarting_point());
            stmt.setString(2, r.getDestination());
            stmt.setString(3, r.getDistance());
            stmt.setBigDecimal(4, r.getPrice());
            stmt.setLong(5, r.getId());
            int i = stmt.executeUpdate();
            System.out.println(i + " Edited Successfully!!");
        } catch (SQLException e) {
            System.out.println("Edition Failed!!");
        }
    }

}
