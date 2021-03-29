package com.weibo.dao.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:07
*/

import com.weibo.dao.ReservationDao;
import com.weibo.entity.Reservation;
import com.weibo.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<Reservation> selectAll() {
        try {
            List<Reservation> reservations = queryRunner.query(DbUtils.getConnection(),"select* from tb_reservation;",new BeanListHandler<Reservation>(Reservation.class));
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reservation select(String reservation_name, int reservation_type) {
        try {
            Reservation reservation = queryRunner.query(DbUtils.getConnection(), "select* from tb_reservation where reservation_name=? and reservation_type=?;", new BeanHandler<Reservation>(Reservation.class), reservation_name, reservation_type);
            return reservation;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Reservation reservation) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "update user_name=? where reservation_name=? and reservation_type=?;", reservation.getUser_name(), reservation.getReservation_name(), reservation.getReservation_type());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String reservation_name, int reservation_type) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "delete from tb_reservation where reservation_name=? and reservation_type=?;", reservation_name, reservation_type);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void insert(Reservation reservation) {
        try {
            String sql = "insert into tb_reservation values(?,?,?);";
            queryRunner.update(DbUtils.getConnection(),sql,reservation.getReservation_name(),reservation.getReservation_type(),reservation.getUser_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
