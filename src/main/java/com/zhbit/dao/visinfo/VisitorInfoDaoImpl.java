package com.zhbit.dao.visinfo;

import com.zhbit.pojo.VisitorInfo;
import com.zhbit.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitorInfoDaoImpl implements VisitorInfoDao{


    @Override
    public List<VisitorInfo> list() throws SQLException {
        PreparedStatement pstm = null;
        Connection connection = DBUtils.getConnection();
        ResultSet rs =null;

        String sql = "select * from `visitor_info`";
        Object[] params = {};
        rs = DBUtils.execute(connection, pstm, rs, sql, params);
        List<VisitorInfo> list = new ArrayList<VisitorInfo>();
        while (rs.next()){
            VisitorInfo visitorInfo = new VisitorInfo();
            visitorInfo.setId(rs.getInt("id"));
            visitorInfo.setVisPhone(rs.getString("visPhone"));
            visitorInfo.setCarNo(rs.getString("carNo"));
            list.add(visitorInfo);
        }
        return list;
    }

    @Override
    public int add(VisitorInfo visitorInfo) throws SQLException {

        PreparedStatement pstm= null;
        Connection connection = DBUtils.getConnection();

        String sql = "insert into `visitor_info`(`visPhone`,`carNo`) values (?,?)";
        Object[] params = {visitorInfo.getVisPhone(),visitorInfo.getCarNo()};

        int add = DBUtils.update(connection, sql, params, pstm);
        return add;


    }

    @Override
    public int delete(int id) throws SQLException {
        PreparedStatement pstm = null;
        Connection connection = DBUtils.getConnection();

        String sql = "delete from `visitor_info` where id = ?";
        Object[] params = {id};

        int delete = DBUtils.update(connection, sql, params, pstm);
        return delete;
    }

    @Override
    public int update(VisitorInfo visitorInfo) throws SQLException {
        PreparedStatement pstm = null;
        Connection connection = DBUtils.getConnection();

        String sql = "update `visitor_info` set `visPhone` = ?,`carNo` = ? where `id` = "+ visitorInfo.getId();
        Object[] params = {visitorInfo.getVisPhone(),visitorInfo.getCarNo()};

        int update = DBUtils.update(connection, sql, params, pstm);
        return update;

    }

    @Override
    public VisitorInfo select(int id) throws SQLException {
        PreparedStatement pstm = null;
        Connection connection = DBUtils.getConnection();
        ResultSet rs = null;

        String sql = "select * from `visitor_info` where id = ? ";
        Object[] params = {id};
        rs = DBUtils.execute(connection, pstm, rs, sql, params);

        if(rs.next()){
            VisitorInfo visitorInfo = new VisitorInfo();
            visitorInfo.setId(rs.getInt("id"));
            visitorInfo.setVisPhone(rs.getString("visPhone"));
            visitorInfo.setCarNo(rs.getString("carNo"));
            return visitorInfo;
        }
        return null;
    }
}
