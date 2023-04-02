package com.zhbit.servlet.Login;

import com.zhbit.pojo.User;
import com.zhbit.service.User.UserServiceImpl;
import com.zhbit.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    //VisitorCreateServlet:控制层：调Service层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserServiceImpl userService = new UserServiceImpl();
        //String message = req.getParameter("message");
        //System.out.println(message);
        String userName = req.getParameter("username");
        String userPassword = req.getParameter("password");

        User user = userService.login(userName, userPassword);

        if(user != null){
            // 给登录成功的用户发 Session
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            // 重定向，转跳到登录后的页面
            resp.sendRedirect("./jsp/homePage.jsp");
        } else{
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
