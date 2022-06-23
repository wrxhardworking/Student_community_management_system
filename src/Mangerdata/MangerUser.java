package Mangerdata;

import Mysql.Mysql;
import OBJ.Clubs;
import OBJ.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MangerUser {
    public static int AddMangerUser(Users users)
    {
        Connection conn= Mysql.conn;
        String sql = "insert into users values(?,?)";
        int result=0;
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setString(1,users.getAccount());
            pps.setInt(2, users.getPassward());
            result = pps.executeUpdate();
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static boolean FindMangerUsers(Users users)
    {
        Clubs c=null;
        // 1、获得数据库的连接对象
        Connection conn = Mysql.conn;
        // 2、书写SQL语句操作数据表
        String sql = "select * from users WHERE 用户名 = ? AND 密码 = ? ";
        // 3、预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            // 4、给SQL语句占位符赋值
            pps.setString(1, users.getAccount());
            pps.setInt(2, users.getPassward());
            // 5、执行查询命令
            ResultSet resultSet = pps.executeQuery();

            if(resultSet.next())
            {   pps.close();
                Mysql.conn.close();
                return true;}
            else{pps.close();
                Mysql.conn.close();
                return false;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
