package Mangerdata;
import OBJ.Clubs;
import Mysql.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MangerClubs {
    public MangerClubs()
    {
        Mysql mysql=new Mysql();
    }
    public static int  AddClub(Clubs c)
    {
        Connection conn=Mysql.conn;
        String sql = "insert into clubs values(?,?,?)";
        int result=0;
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(1, c.getId());
            pps.setString(2, c.getClub());
            pps.setString(3, c.getClubMesg());
            result = pps.executeUpdate();
            pps.close();
//            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public  static int DeleteClub(int id)
    {
        Connection conn=Mysql.conn;
        String sql = "delete FROM clubs WHERE ID = ? ";
        int result=0;
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(1,id);
            result = pps.executeUpdate();

            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int UpdateClubs(Clubs c)
    {
        int result = 0;
        // 获得数据库的连接对象
        Connection conn =Mysql.conn;
        // 书写SQL语句操作数据库
        String sql = "UPDATE clubs set 社团名称=?,社团简介=? WHERE ID=?";
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(3, c.getId());
            pps.setString(1, c.getClub());
            pps.setString(2, c.getClubMesg());
            result = pps.executeUpdate();
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Clubs FindClubs(int Id) {

        Clubs c=null;
        // 1、获得数据库的连接对象
        Connection conn = Mysql.conn;
        // 2、书写SQL语句操作数据表
        String sql = "select * from clubs WHERE ID=?";
        // 3、预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            // 4、给SQL语句占位符赋值
            pps.setInt(1, Id);
            // 5、执行查询命令
            ResultSet resultSet = pps.executeQuery();
            // 6、循环读取结果集中的数据
            while (resultSet.next()) {   // 如果结果集中有数据返回true
                // 7、 把结果集中的数据读取出来赋值给用户的属性
                c= new Clubs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
            pps.close();
//            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void  ClubsInit(Vector Msg)
    {
        //数据库
        Mysql mysql = new Mysql();
        //数据库查询操作
        try {
            PreparedStatement preparedStatement = mysql.conn.prepareStatement("select *from clubs");//sql语句编译预处理
            ResultSet res = preparedStatement.executeQuery();//获取ResultSet结果集
            while (res.next()) {
                Vector temp = new Vector<>();
                temp.add(res.getInt("ID"));
                temp.add(res.getString("社团名称"));
                temp.add(res.getString("社团简介"));
                Msg.add(temp);
            }
           preparedStatement.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


class test2
{

    public static void main(String[] args) {
        Mysql s=new Mysql();

    }
}