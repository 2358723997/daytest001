package com.gupao.vip.pattern.ToolUtiles;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author wangjixue
 * @date 2019-05-19 15:22
 */
public class JdbcUtil {
    private static  String url;
    private static  String userName;
    private static  String password;
    //1.加载注册驱动
    static {
        try {
            Properties properties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream("db.properties");
            Class.forName(properties.getProperty("driverName"));
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //2.获取数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);

    }
    //3.关闭连接

    public static void close(Connection con, ResultSet rs, Statement st) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {

                con.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
