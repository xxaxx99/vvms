package com.zhbit.servlet.Order;

import com.zhbit.pojo.Order;
import com.zhbit.service.Order.OrderService;
import com.zhbit.service.Order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/order/query")
public class OrderListServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orderList;
        try {
            orderList = orderService.list();
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("/jsp/order/index.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
