package com.zhbit.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;

    static{

        try{

            InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(is);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            Class.forName(driver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //获取数据库链接
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    //查询公共方法
    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }

        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //增删改公共方法
    public static int update(Connection connection, String sql, Object[] params, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }

        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }

    //关闭连接释放资源
    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        boolean flag = true;

        if(resultSet!=null){
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                flag = false;
                throw new RuntimeException(e);

            }
        }

        if(preparedStatement!=null){
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                flag = false;
                throw new RuntimeException(e);
            }
        }

        if(connection!=null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                flag = false;
                throw new RuntimeException(e);
            }
        }
        return flag;
    }


}
