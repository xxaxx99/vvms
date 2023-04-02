package com.zhbit.service.Parkcarinfo;

import com.zhbit.pojo.Parkcarinfo;

import java.sql.SQLException;
import java.util.List;

public interface ParkcarinfoService {
    List<Parkcarinfo> list(String keyword) throws SQLException;
    int delete(Integer parkNo) throws SQLException;
    Parkcarinfo findById(Integer parkcarinfo)throws SQLException;
    int updateById(Parkcarinfo parkcarinfo)throws SQLException;
    int create(Parkcarinfo parkcarinfo)throws SQLException;
}
