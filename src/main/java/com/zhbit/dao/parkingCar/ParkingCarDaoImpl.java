package com.zhbit.dao.parkingCar;

import com.zhbit.pojo.ParkingCar;
import com.zhbit.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingCarDaoImpl implements ParkingCarDao{
    public List<ParkingCar> searchAll() throws SQLException {
        // 获取连接
        Connection connection = DBUtils.getConnection();

        PreparedStatement pstm = null;
        ResultSet res = null;
        Object[] params = {};
        List<ParkingCar> parkingCarList = new ArrayList<ParkingCar>();

        res = DBUtils.execute(connection, pstm, res, "select * from in_out_record", params);
        while (res.next()){
            ParkingCar parkingCar = new ParkingCar();
            parkingCar.setCarNo(res.getString("carNo"));
            parkingCar.setInTime(res.getString("In_time"));
            parkingCarList.add(parkingCar);
        }
        return parkingCarList;
    }

    public ParkingCar searchByCarNo(String carNo) throws SQLException {
        // 获取连接
        Connection connection = DBUtils.getConnection();
        PreparedStatement pstm = null;
        ResultSet res = null;
        Object[] params = {carNo};
        List<ParkingCar> parkingCarList = new ArrayList<ParkingCar>();

        res = DBUtils.execute(connection, pstm, res, "select * from `in_out_record` where `carNo`=?", params);
        ParkingCar parkingCar = new ParkingCar();
        while(res.next()){
            parkingCar.setCarNo(res.getString("carNo"));
            parkingCar.setInTime(res.getString("In_time"));
        }
        return parkingCar;
    }

    public int addParking(ParkingCar parkingCar) throws SQLException {
        // 获取连接
        Connection connection = DBUtils.getConnection();

        PreparedStatement pstm = null;
        Object[] params = { parkingCar.getCarNo(), parkingCar.getInTime()};
        String sql = "insert into `in_out_record`(`carNo`,`In_time`) values (?,?)";

        return DBUtils.update(connection,sql,params,pstm);
    }

    public int change(ParkingCar parkingCar) throws  SQLException {
        // 获取连接
        Connection connection = DBUtils.getConnection();

        PreparedStatement pstm = null;
        String sql = "update `in_out_record` set `In_time`=? where `carNo`=?";
        Object[] params = { parkingCar.getInTime(), parkingCar.getCarNo()};

        return DBUtils.update(connection,sql,params,pstm);
    }

    public int deleteParking(String carNo) throws SQLException {
        // 获取连接
        Connection connection = DBUtils.getConnection();

        PreparedStatement pstm = null;
        String sql = "delete from `in_out_record` where `carNo`=?";
        Object[] params = {carNo};

        return DBUtils.update(connection,sql,params,pstm);
    }
}
