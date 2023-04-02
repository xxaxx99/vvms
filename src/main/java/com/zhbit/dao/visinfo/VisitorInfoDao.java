package com.zhbit.dao.visinfo;

import com.zhbit.pojo.VisitorInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VisitorInfoDao {

    //查询返回集合
    List<VisitorInfo> list() throws SQLException;

    //增
    int add(VisitorInfo visitorInfo) throws SQLException;

    //删
    int delete(int id) throws SQLException;

    //改
    int update(VisitorInfo visitorInfo) throws SQLException;

    //查
    VisitorInfo select(int id) throws SQLException;


}
