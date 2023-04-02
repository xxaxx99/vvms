package com.zhbit.dao.order;

import com.zhbit.pojo.Order;
import com.zhbit.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao{
    @Override
    public List<Order> list() throws SQLException {
        String sql = "select * from `order`";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs =null;
        Object[] params = {};
        rs = DBUtils.execute(connection, pstm, rs, sql, params);
        List<Order> list = new ArrayList<Order>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setPhone(rs.getString("phone"));
            order.setMoney(rs.getFloat("money"));
            order.setCarNumber(rs.getString("car_number"));
            order.setTime(rs.getFloat("time"));
            list.add(order);
        }
        return list;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        String sql = "delete from `order` where id = ?";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        Object[] params = {id};
        int delete = DBUtils.update(connection, sql, params, pstm);
        return delete;
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        String sql = "select * from `order` where id = ?";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs =null;
        Object[] params = {id};
        rs = DBUtils.execute(connection, pstm, rs, sql, params);
        if (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setPhone(rs.getString("phone"));
            order.setMoney(rs.getFloat("money"));
            order.setCarNumber(rs.getString("car_number"));
            order.setTime(rs.getFloat("time"));
            return order;
        }
        return null;
    }

    @Override
    public int updateById(Order order) throws SQLException {
        String sql = "UPDATE `order` SET `phone` = ?, `money` = ?, `car_number` = ?, `time` = ? WHERE `id` = ?";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        Object[] params = {order.getPhone(), order.getMoney(), order.getCarNumber(), order.getTime(), order.getId()};
        int update = DBUtils.update(connection, sql, params, pstm);
        return update;
    }

    @Override
    public int create(Order order) throws SQLException {
        String sql = "INSERT INTO `order`(`phone`, `money`, `car_number`, `time`) VALUES (?, ?, ?, ?)";
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        Object[] params = {order.getPhone(), order.getMoney(), order.getCarNumber(), order.getTime()};
        int create = DBUtils.update(connection, sql, params, pstm);
        return create;
    }
}
