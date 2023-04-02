package com.zhbit.service.User;

import com.zhbit.pojo.User;

public interface UserService {
    //判断用户登录用的用户名和密码是否正确
    public User login(String userName,String password);

}
