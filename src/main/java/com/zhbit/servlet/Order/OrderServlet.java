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

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            create(request, response);
        } else if(action.equals("update")) {
            update(request, response);
        } else if(action.equals("findById")) {
            findById(request, response);
        } else if(action.equals("query")) {
            query(request, response);
        } else if(action.equals("delete")) {
            delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            orderService.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/order?action=query");
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orderList;
        try {
            orderList = orderService.list();
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("/jsp/order/index.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            Order order = orderService.findById(id);
            request.setAttribute("order", order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/jsp/order/edit.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        response.sendRedirect(request.getContextPath() + "/order?action=query");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        response.sendRedirect(request.getContextPath() + "/order?action=query");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
