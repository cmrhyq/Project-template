package com.alan.elastic.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接类
 *
 * @author Alan Huang
 * @version v1
 * @Title DBHelper
 * @date 2021/4/18-8:56
 * @Email cmrhyq@163.com
 */
public class DBHelper {
    public static final String URL = "jdbc:mysql://****:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    public static final String NAME = "****";
    public static final String USER = "****";
    public static final String PASSWORD = "****";
    public static Connection conn = null;

    public static Connection getConn() {
        //获取连接
        try {
            Class.forName(NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}