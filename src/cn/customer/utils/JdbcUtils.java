package cn.customer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc连接MySQL数据库的工具类 用于获取连接connection对象
 */
public class JdbcUtils {
    // 通过配置文件来获取数据库连接参数
    private static Properties properties = new Properties();
    // 因为只需要获取一次，所以在静态代码块儿中
    static {
        try {
            // 把配置文件加载到properties对象中
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            // 注册MySQL驱动，只需要注册一次
            Class.forName(properties.getProperty("driver"));
        } catch (Exception e) {
            throw new RuntimeException("初始化错误！");
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
                properties.getProperty("password"));
        return con;
    }

    // 释放资源
    public static void release(ResultSet rs, Statement st,  Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
