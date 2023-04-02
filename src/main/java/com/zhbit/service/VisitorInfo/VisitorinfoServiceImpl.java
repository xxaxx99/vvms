package com.zhbit.service.VisitorInfo;

import com.zhbit.dao.visinfo.VisitorInfoDao;
import com.zhbit.dao.visinfo.VisitorInfoDaoImpl;
import com.zhbit.pojo.VisitorInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VisitorinfoServiceImpl implements VisitorinfoService {

    //调dao层
    private VisitorInfoDao visitorInfoDao;

    public VisitorinfoServiceImpl(){
        visitorInfoDao = new VisitorInfoDaoImpl();
    }
    @Override
    public List<VisitorInfo> list() throws SQLException {
        return visitorInfoDao.list();
    }

    @Override
    public int add(VisitorInfo visitorInfo) throws SQLException {
        return visitorInfoDao.add(visitorInfo);
    }

    @Override
    public int delete(int id) throws SQLException {
        return visitorInfoDao.delete(id);
    }

    @Override
    public int update(VisitorInfo visitorInfo) throws SQLException {
        return visitorInfoDao.update(visitorInfo);
    }

    @Override
    public VisitorInfo select(int id) throws SQLException {
        return visitorInfoDao.select(id);
    }
}
