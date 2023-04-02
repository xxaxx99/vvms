package com.zhbit.servlet.ParkingCar;

import com.zhbit.pojo.ParkingCar;
import com.zhbit.pojo.VisitorInfo;
import com.zhbit.service.parkingCar.ParkingCarService;
import com.zhbit.service.parkingCar.ParkingCarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/parkingCar")
public class ParkingCarServlet extends HttpServlet {
    ParkingCarService parkingCarService = new ParkingCarServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String message = req.getParameter("message");
        if(message.equals("query")){
            try {
                query(req,res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(message.equals("add")){
            try {
                add(req,res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(message.equals("update")){
            try {
                update(req,res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(message.equals("save")){
            try {
                save(req,res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(message.equals("delete")){
            try {
                delete(req,res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void query(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        List<ParkingCar> parkingCarList = parkingCarService.searchAll();

        // 发送数据
        req.setAttribute("parkingCarList", parkingCarList);
        // 转跳
        req.getRequestDispatcher("/jsp/parkingCar/index.jsp").forward(req, res);
    }

    public void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String carNo = req.getParameter("carNo");
        // 查库
        ParkingCar parkingCar = parkingCarService.searchByCarNo(carNo);
        // 发送数据
        req.setAttribute("parkingCar",parkingCar);
        // 转跳
        req.getRequestDispatcher("/jsp/parkingCar/update.jsp").forward(req, res);
    }

    public void add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String carNo = req.getParameter("carNo");
        String inTime = req.getParameter("inTime");

        ParkingCar parkingCar = new ParkingCar(carNo,inTime);

        // 添库
        int re = parkingCarService.addParking(parkingCar);
        // 转跳
        res.sendRedirect(req.getContextPath() + "/parkingCar?message=query");
    }

    public void save(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String carNo = req.getParameter("carNo");
        String inTime = req.getParameter("inTime");

        ParkingCar parkingCar = new ParkingCar(carNo,inTime);

        // 添库
        int re = parkingCarService.change(parkingCar);
        // 转跳
        res.sendRedirect(req.getContextPath() + "/parkingCar?message=query");
    }

    public void delete(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException {
        String carNo = req.getParameter("carNo");

        int re = parkingCarService.deleteParking(carNo);
        // 转跳
        res.sendRedirect(req.getContextPath() + "/parkingCar?message=query");
    }
}
