package Mysql;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mysql {

    public static Connection conn;

    public Mysql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?useSSL=FALSE&serverTimezone=UTC", "root", "123456");
            //得到执行sql语句的Statement对象
//                stmt = conn.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



