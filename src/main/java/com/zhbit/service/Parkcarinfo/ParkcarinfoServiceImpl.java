package com.zhbit.service.Parkcarinfo;

import com.zhbit.dao.parkcarinfo.ParkcarinfoDao;
import com.zhbit.dao.parkcarinfo.ParkcarinfoDaoImpl;
import com.zhbit.pojo.Parkcarinfo;

import java.sql.SQLException;
import java.util.List;

public class ParkcarinfoServiceImpl implements ParkcarinfoService{
    ParkcarinfoDao parkcarinfoDao = new ParkcarinfoDaoImpl();



    @Override
    public int create(Parkcarinfo parkcarinfo) throws SQLException {
        return parkcarinfoDao.create(parkcarinfo);
    }
    @Override
    public List<Parkcarinfo> list(String keyword) throws SQLException {
        return parkcarinfoDao.list(keyword);
    }

    @Override
    public int delete(Integer parkNo) throws SQLException {
        return parkcarinfoDao.delete(parkNo);
    }

    @Override
    public Parkcarinfo findById(Integer parkNo) throws SQLException {
        return parkcarinfoDao.findById(parkNo);
    }

    @Override
    public int updateById(Parkcarinfo parkcarinfo) throws SQLException {
        return parkcarinfoDao.updateById(parkcarinfo);
    }
}
