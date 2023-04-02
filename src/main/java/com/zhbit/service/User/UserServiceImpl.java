package com.zhbit.service.User;

import com.zhbit.dao.user.UserDao;
import com.zhbit.dao.user.UserDaoImpl;
import com.zhbit.pojo.User;
import com.zhbit.util.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{

    //调dao层
    private UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userName, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection  = DBUtils.getConnection();

            // 从 Dao 层获取查询出来的数据
            user  = userDao.getLoginUser(connection, userName);

            // 校验密码是否正确
            if(!password.equals(user.getPassword())){
                user = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtils.closeResource(connection,null,null);
        }
        return user;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User lzh = userService.login("lzh","123456");
        System.out.println(lzh.getPassword());
    }
}
