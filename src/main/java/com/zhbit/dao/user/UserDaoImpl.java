package com.zhbit.dao.user;
import com.zhbit.pojo.User;
import com.zhbit.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    @Override
    public User getLoginUser(Connection connection, String useName) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs =null;
        User user = null;

        //判断数据库连接对象是否为空（即连接成功）
        if(connection!=null){
            String sql = "select * from user where userName = ?";
            Object[] params = {useName};

            rs = DBUtils.execute(connection, pstm, rs, sql, params);

            if(rs.next()){
                user = new User();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAdPhone(rs.getString("ad_phone"));
                user.setAdmin(rs.getInt("admin"));
            }
            DBUtils.closeResource(null,pstm,rs);
        }

        return  user;

    }
}
