package com.zhbit.service.parkingCar;

import com.zhbit.dao.parkingCar.ParkingCarDao;
import com.zhbit.dao.parkingCar.ParkingCarDaoImpl;
import com.zhbit.pojo.ParkingCar;

import java.sql.SQLException;
import java.util.List;

public class ParkingCarServiceImpl implements ParkingCarService{
    ParkingCarDao parkingCarDao = new ParkingCarDaoImpl();

    public List<ParkingCar> searchAll() throws SQLException {
        return parkingCarDao.searchAll();
    }

    public ParkingCar searchByCarNo(String carNo) throws SQLException {
        return parkingCarDao.searchByCarNo(carNo);
    }

    public int addParking(ParkingCar parkingCar) throws SQLException {
        return parkingCarDao.addParking(parkingCar);
    }

    public int change(ParkingCar parkingCar) throws  SQLException {
        return parkingCarDao.change(parkingCar);
    }

    public int deleteParking(String carNo) throws SQLException {
        return parkingCarDao.deleteParking(carNo);
    }
}
