package com.zhbit.servlet.Parkcarinfo;

import com.zhbit.pojo.Parkcarinfo;
import com.zhbit.service.Parkcarinfo.ParkcarinfoService;
import com.zhbit.service.Parkcarinfo.ParkcarinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/parkcarinfo")
public class ParkcarinfoServlet extends HttpServlet {

    ParkcarinfoService parkcarinfoService = new ParkcarinfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case  "create":
                Integer allspace = Integer.valueOf(req.getParameter("allspace"));
                Integer occupied = Integer.valueOf(req.getParameter("occupied"));
                Parkcarinfo parkcarinfo = new Parkcarinfo();
                try {
                    parkcarinfo.setAllspace(allspace);
                    parkcarinfo.setOccupied(occupied);
                    int create = parkcarinfoService.create(parkcarinfo);
                    req.setAttribute("parkcarinfo",parkcarinfo);
                } catch (SQLException throwables){
                    throwables.printStackTrace();
                }
                resp.sendRedirect(req.getContextPath()+"/parkcarinfo?method=query");
                return;
            case "update":
                Integer parkNo = Integer.valueOf(req.getParameter("parkNo"));
                allspace = Integer.valueOf(req.getParameter("allspace"));
                occupied = Integer.valueOf(req.getParameter("occupied"));
                parkcarinfo = new Parkcarinfo();
                try {
                    parkcarinfo.setParkNo(parkNo);
                    parkcarinfo.setAllspace(allspace);
                    parkcarinfo.setOccupied(occupied);
                    int update = parkcarinfoService.updateById(parkcarinfo);
                    req.setAttribute("parkcarinfo",parkcarinfo);
                }catch (SQLException throwables){
                    throwables.printStackTrace();
                }
                resp.sendRedirect(req.getContextPath()+"/parkcarinfo?method=query");
                return;
            case "get":
                parkNo = Integer.valueOf(req.getParameter("parkNo"));
                try {
                    parkcarinfo = parkcarinfoService.findById(parkNo);
                    req.setAttribute("parkcarinfo",parkcarinfo);
                }
                catch (SQLException throwables){
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/jsp/parkcarinfo/modify.jsp").forward(req,resp);
                return;
            case "delete":
                parkNo = Integer.valueOf(req.getParameter("parkNo"));
                try{
                    parkcarinfoService.delete(parkNo);
                }catch (SQLException throwables){
                    throwables.printStackTrace();
                }
                resp.sendRedirect(req.getContextPath()+"/parkcarinfo?method=query");
                break;
            case "query":
                List<Parkcarinfo> parkcarinfoList;
                try {
                    String keyword = req.getParameter("keyword");
                    parkcarinfoList=parkcarinfoService.list(keyword);

                    req.setAttribute("keyword",keyword);
                    req.setAttribute("parkcarinfoList",parkcarinfoList);
                    req.getRequestDispatcher("/jsp/parkcarinfo/index.jsp").forward(req,resp);


                }
                catch (SQLException throwables){
                    throwables.printStackTrace();
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
