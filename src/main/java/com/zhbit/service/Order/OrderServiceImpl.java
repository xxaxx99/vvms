package com.zhbit.service.Order;

import com.zhbit.dao.order.OrderDao;
import com.zhbit.dao.order.OrderDaoImpl;
import com.zhbit.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<Order> list() throws SQLException {
        return orderDao.list();
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return orderDao.delete(id);
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        return orderDao.findById(id);
    }

    @Override
    public int updateById(Order order) throws SQLException {
        return orderDao.updateById(order);
    }

    @Override
    public int create(Order order) throws SQLException {
        return orderDao.create(order);
    }
}
