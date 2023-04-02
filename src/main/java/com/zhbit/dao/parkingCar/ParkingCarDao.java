package com.zhbit.dao.parkingCar;

import com.zhbit.pojo.ParkingCar;

import java.sql.SQLException;
import java.util.List;

public interface ParkingCarDao {
    List<ParkingCar> searchAll() throws SQLException;

    ParkingCar searchByCarNo(String carNo) throws SQLException;

    int addParking(ParkingCar parkingCar) throws SQLException;

    int change(ParkingCar parkingCar) throws  SQLException;

    int deleteParking(String carNo) throws SQLException;
}
