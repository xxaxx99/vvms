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

@WebServlet("/order/update")
public class OrderUpdateServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了dopost");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String phone = request.getParameter("phone");
        float money = Float.valueOf(request.getParameter("money"));
        String carNumber = request.getParameter("carNumber");
        float time = Float.valueOf(request.getParameter("time"));
        Order order = new Order(id, phone, money, carNumber, time);
        try {
            int update = orderService.updateById(order);
            request.setAttribute("order", order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/order/query");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了doget");
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            Order order = orderService.findById(id);
            request.setAttribute("order", order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/jsp/order/modify.jsp").forward(request, response);
        System.out.println("出来了");
    }
}
