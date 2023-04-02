package com.zhbit.dao.parkcarinfo;

import com.zhbit.pojo.Parkcarinfo;

import java.sql.SQLException;
import java.util.List;

public interface ParkcarinfoDao {
    //得到数据库已有停车库
    List<Parkcarinfo> list(String keyword) throws SQLException;
    int delete(Integer parkNo) throws SQLException;
    Parkcarinfo findById(Integer parkNo) throws SQLException;
    int updateById(Parkcarinfo parkcarinfo) throws SQLException;
    int create(Parkcarinfo parkcarinfo) throws SQLException;
}
