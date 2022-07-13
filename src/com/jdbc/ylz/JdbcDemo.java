package com.jdbc.ylz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ylz
 * @date 2022/7/13 10:07
 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");//驱动程序会自动加载，无需自写
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        Connection coon = DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql = "UPDATE user SET u_phone=5555 WHERE u_id=1";
        //4.获取执行sql的对象
        Statement stmt = coon.createStatement();
        //5.执行update语句
        int count =  stmt.executeUpdate(sql);//返回受影响行数
        //6.处理结果
        System.out.println(count);
        //7.释放资源
        stmt.close();
        coon.close();
    }
}
