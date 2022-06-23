package Mangerdata;

import OBJ.Members;
import Mysql.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class MangerMembers {
    public MangerMembers()
    {
        Mysql mysql =new Mysql();
    }

    public static int AddMembers(Members members)
    {
        Connection conn= Mysql.conn;
        String sql = "insert into club_members values(?,?,?,?,?,?)";
        int result=0;
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(1, members.getId());
            pps.setString(2, members.getName());
            pps.setString(3, members.getSex());
            pps.setInt(4, members.getAge());
            pps.setString(5, members.getProfesion());
            pps.setString(6, members.getHobby());
            result = pps.executeUpdate();
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static int DeleteMembers(int Id)
    {
        Connection conn=Mysql.conn;
        String sql = "delete FROM club_members WHERE ID = ? ";
        int result=0;
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(1,Id);
            result = pps.executeUpdate();
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static int UpdateMembers(Members members)
    {
        int result = 0;
        // 获得数据库的连接对象
        Connection conn =Mysql.conn;
        // 书写SQL语句操作数据库
        String sql = "UPDATE club_members set 姓名=?,年龄=?,专业=?,兴趣爱好=?,性别=？ WHERE ID=?";
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(6, members.getId());
            pps.setString(1, members.getName());
            pps.setInt(2, members.getAge());
            pps.setString(3, members.getProfesion());
            pps.setString(4, members.getHobby());
            pps.setString(5, members.getSex());
            result = pps.executeUpdate();
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Members FindMembers(int Id)
    {
        Members members=null;
        // 1、获得数据库的连接对象
        Connection conn = Mysql.conn;
        // 2、书写SQL语句操作数据表
        String sql = "select * from club_members WHERE ID=?";
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
               members= new Members(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
            }
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public static Vector FindMembersID()
    {
        Vector res=new Vector<>();
        Connection conn = Mysql.conn;
        String sql = "select ID from club_members";
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            ResultSet resultSet = pps.executeQuery();

            while (resultSet.next()) {
              res.add(resultSet.getInt(1));
            }
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static void initTable(Vector Msg, Vector Head, List<Members> list)
    {
        Head.add("ID");
        Head.add("姓名");
        Head.add("性别");
        Head.add("年龄");
        Head.add("专业");
        Head.add("兴趣爱好");
        for(int i=0;i<list.size();++i)
        {
            Vector temp=new Vector();
            temp.add(list.get(i).getId());
            temp.add(list.get(i).getName());
            temp.add(list.get(i).getSex());
            temp.add(list.get(i).getAge());
            temp.add(list.get(i).getProfesion());
            temp.add(list.get(i).getHobby());
            Msg.add(temp);
        }
    }
}



class  test3
{
    public static void main(String[] args) {
//        Mysql mysql=new Mysql();
//        MangerMembers mangerMembers=new MangerMembers();
//        Members members=new Members(5,"小吴","女",18,"科教","爱好王仁鑫");
//        mangerMembers.AddMembers(members);
        Mysql mysql=new Mysql();
        Vector v=MangerMembers.FindMembersID();


        System.out.println(v.size());
        System.out.println(Integer.parseInt(v.get(0).toString()));
    }
}
