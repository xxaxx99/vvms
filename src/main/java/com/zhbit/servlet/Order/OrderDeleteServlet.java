package com.zhbit.servlet.Order;

import com.zhbit.service.Order.OrderService;
import com.zhbit.service.Order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/order/delete")
public class OrderDeleteServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            orderService.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/order/query");
    }
}
