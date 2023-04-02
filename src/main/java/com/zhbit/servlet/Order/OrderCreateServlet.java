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

@WebServlet("/order/create")
public class OrderCreateServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        float money = Float.valueOf(request.getParameter("money"));
        String carNumber = request.getParameter("carNumber");
        float time = Float.valueOf(request.getParameter("time"));
        Order order = new Order(0, phone, money, carNumber, time);
        try {
            int create = orderService.create(order);
            request.setAttribute("order", order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/order/query");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
