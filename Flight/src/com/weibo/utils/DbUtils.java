package com.weibo.utils;
/*
    @author weibo
    @date 2021/1/28 - 10:27
*/

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
    private static DruidDataSource ds;  //数据库连接池
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();//事务控制的thread_local

    //静态代码块,做一些初始操作
    static {
        Properties properties = new Properties();//给一个proaperties集合
        InputStream is = DbUtils.class.getResourceAsStream("/database.properties");//拿到一个字节输入流
        try {
            properties.load(is);//通过字节流,把配置文件进行加载
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);//创建数据库连接池
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = THREAD_LOCAL.get();//创建一个connection
        try {
            if(connection == null){
                connection = ds.getConnection();
                THREAD_LOCAL.set(connection);//把connection存进去
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //开启事务
    public static void begin(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);//关闭自动提交
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commit(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }

    //回滚
    public static void rollback(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }

    //释放资源
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
                THREAD_LOCAL.remove();//把这个对象在THREAD_LOCAL进行移除
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
