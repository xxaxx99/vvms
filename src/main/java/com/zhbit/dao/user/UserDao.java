package com.zhbit.dao.user;
import com.zhbit.pojo.User;
import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {

    public User getLoginUser(Connection connection, String useName) throws SQLException;

}
