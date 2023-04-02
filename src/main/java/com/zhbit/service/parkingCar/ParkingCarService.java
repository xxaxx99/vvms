package com.zhbit.service.parkingCar;

import com.zhbit.pojo.ParkingCar;

import java.sql.SQLException;
import java.util.List;

public interface ParkingCarService {
    List<ParkingCar> searchAll() throws SQLException;

    ParkingCar searchByCarNo(String carNo) throws SQLException;

    int addParking(ParkingCar parkingCar) throws SQLException;

    int change(ParkingCar parkingCar) throws  SQLException;

    int deleteParking(String carNo) throws SQLException;
}
