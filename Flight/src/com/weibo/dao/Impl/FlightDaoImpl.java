package com.weibo.dao.Impl;/*
    @author weibo
    @date 2021/1/28 - 18:55
*/

import com.weibo.dao.FlightDao;
import com.weibo.entity.Flight;
import com.weibo.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class FlightDaoImpl implements FlightDao {
    QueryRunner queryRunner = new QueryRunner();

    @Override
    public int delete(String flight_num) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "delete from tb_flight where flight_num=?;", flight_num);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Flight flight) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "update tb_flight set flight_price=?,flight_total_seats=?,flight_rest_seats=?,flight_from_city=?,flight_to_city=? where flight_num=?;",
                    flight.getFlight_price(),flight.getFlight_total_seats(),flight.getFlight_rest_seats(),flight.getFlight_from_city(),flight.getFlight_to_city(),flight.getFlight_num());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Flight select(String flight_num) {
        try {
            Flight flight = queryRunner.query(DbUtils.getConnection(),"select* from tb_flight where flight_num=?;",new BeanHandler<Flight>(Flight.class),flight_num);
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Flight flight) {
        String sql = "insert into tb_flight values(?,?,?,?,?,?);";
        try {
            queryRunner.update(DbUtils.getConnection(),sql,flight.getFlight_num(),flight.getFlight_price(),flight.getFlight_total_seats(),flight.getFlight_rest_seats(),
                    flight.getFlight_from_city(),flight.getFlight_to_city());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Flight> selectAll() {
        try {
            List<Flight> flights = queryRunner.query(DbUtils.getConnection(),"select* from tb_flight;",new BeanListHandler<Flight>(Flight.class));
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight> selectRoute(String username) {
        try {
            String sql = "select flight_num,flight_price,flight_total_seats,flight_rest_seats,flight_from_city,flight_to_city from tb_flight,tb_reservation where reservation_name=flight_num and user_name=?;";
            List<Flight> flights = queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<Flight>(Flight.class),username);
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
