package com.gupao.vip.pattern.jdbctemplate;

import com.gupao.vip.pattern.ToolUtiles.JdbcUtil;
import lombok.Data;
import lombok.Value;

import java.sql.*;

/**
 * @author wangjixue
 * @date 2019-05-19 15:01
 */
public class JDBC {
    private static JdbcUtil jdbcUtil;
    private  Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public void save() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            //1.加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
            //3.设置执行语句
            String sql = "insert into student (name,age)values ('xiaowang',12);";
            PreparedStatement statement = connection.prepareStatement(sql);
            //4.执行
            int i = statement.executeUpdate();
            //5.解析结果
            if(i!=0){
                System.err.println("插入成功");
            }
        }catch (ClassNotFoundException e){
                throw new ClassNotFoundException();
        }catch (SQLException e){
            throw new SQLException();
        }finally {
            //6.关闭连接
            if(connection!=null){
                connection.close();
            }
        }
    }

    public void get(String userName) throws SQLException {
        try {
            con = jdbcUtil.getConnection();
            String sql = "select * from student where username=?;";
            ps = con.prepareStatement(sql);
            ps.setObject(1,"xiaowang");
             rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("userName");
                int age=rs.getInt("age");
                new Student(name,age);
            }
        }finally {
            JdbcUtil.close(con,rs,ps);
        }


    }
}
@Data
class Student{
    private String username;
    private int age;

    public Student(String username, int age) {
        this.username = username;
        this.age = age;
    }
}