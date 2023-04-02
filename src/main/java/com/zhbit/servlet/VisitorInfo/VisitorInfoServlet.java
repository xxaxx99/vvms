package com.zhbit.servlet.VisitorInfo;

import com.zhbit.pojo.VisitorInfo;
import com.zhbit.service.VisitorInfo.VisitorinfoService;
import com.zhbit.service.VisitorInfo.VisitorinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/visitorinfo")
public class VisitorInfoServlet extends HttpServlet {

    VisitorinfoService visitorinfoService = new VisitorinfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("进入了doget方法");
        //List<VisitorInfo> visitorInfoList;
        //try {
        //    visitorInfoList = visitorinfoService.list();
        //    req.setAttribute("visitorInfoList", visitorInfoList);
        //    req.getRequestDispatcher("/jsp/visitorinfo/index.jsp").forward(req, resp);
        //} catch (SQLException throwables) {
        //    throwables.printStackTrace();
        //}
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        System.out.println(message);
        if(message.equals("query")){
            query(req,resp);
        }

        if(message.equals("add")){
            add(req,resp);
        }

        if(message.equals("update")){
            update(req,resp);
        }

        if(message.equals("save")){
            save(req,resp);
        }

        if(message.equals("delete")){
            delete(req,resp);
        }

    }

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<VisitorInfo> visitorInfoList;
        try {
            visitorInfoList = visitorinfoService.list();
            req.setAttribute("visitorInfoList", visitorInfoList);
            req.getRequestDispatcher("/jsp/visitorinfo/index.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入了add方法");
        String visPhone = req.getParameter("visPhone");
        String carNo = req.getParameter("carNo");;
        VisitorInfo visitorInfo = new VisitorInfo(0, visPhone, carNo);
        try {
            int add= visitorinfoService.add(visitorInfo);
            req.setAttribute("visitorinfo", visitorInfo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/visitorinfo?message=query");
        System.out.println("出来了");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了update");
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            VisitorInfo visitorInfo = visitorinfoService.select(id);
            req.setAttribute("visitorInfo", visitorInfo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("/jsp/visitorinfo/update.jsp").forward(req, resp);
        System.out.println("出来了");
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入了save");
        Integer id = Integer.valueOf(req.getParameter("id"));
        String visPhone = req.getParameter("visPhone");
        String carNo = req.getParameter("carNo");;
        VisitorInfo visitorInfo = new VisitorInfo(id, visPhone, carNo);
        try {
            int update= visitorinfoService.update(visitorInfo);
            req.setAttribute("visitorinfo", visitorInfo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/visitorinfo?message=query");
        System.out.println("出来了");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        try {
            visitorinfoService.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/visitorinfo?message=query");
    }

}
