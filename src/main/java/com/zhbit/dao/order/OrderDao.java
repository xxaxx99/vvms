package com.zhbit.dao.order;

import com.zhbit.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    List<Order> list() throws SQLException;

    int delete(Integer id) throws SQLException;

    Order findById(Integer id) throws SQLException;

    int updateById(Order order) throws SQLException;

    int create(Order order) throws SQLException;
}
