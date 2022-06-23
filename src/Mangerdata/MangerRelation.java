package Mangerdata;

import Mysql.Mysql;
import OBJ.Clubs;
import OBJ.Members;
import OBJ.Releation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MangerRelation {
    public MangerRelation()
    {
        Mysql mysql=new Mysql();
    }
    public static int AddRelation(Releation releation)
    {
        Connection conn= Mysql.conn;
        String sql = "insert into club_member_relations values(?,?)";
        int result=0;
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(1, releation.getClub_Id());
            pps.setInt(2, releation.getMember_Id());
            result = pps.executeUpdate();
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static int DeleteRelation(int Id)
    {
        Connection conn=Mysql.conn;
        String sql = "delete FROM club_member_relations WHERE Clubs_ID = ? OR Members_ID=?";
        int result=0;
        // 预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(1,Id);
            pps.setInt(2,Id);
            result = pps.executeUpdate();
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static List<Members> FindMembers(int ID)
    {
        List<Members>list=new ArrayList<>();
        Members members=null;
        // 1、获得数据库的连接对象
        Connection conn = Mysql.conn;
        // 2、书写SQL语句操作数据表
        //String sql = "select club_members.ID,club_members.姓名,club_members.年龄,club_members.专业,club_members.兴趣爱好 from club_members,clubs,club_member_relations  WHERE club_member_relations.Clubs_ID =? and club_members.ID=club_member_relations.Members_ID  ";
        String sql="select  club_members.ID,club_members.姓名,club_members.性别,club_members.年龄,club_members.专业,club_members.兴趣爱好 from club_members  LEFT JOIN club_member_relations ON  club_members.ID = club_member_relations.Members_ID LEFT JOIN clubs ON club_member_relations.Clubs_ID=clubs.ID WHERE clubs.ID=? ";
        // 3、预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            // 4、给SQL语句占位符赋值
            pps.setInt(1, ID);
            // 5、执行查询命令
            ResultSet resultSet = pps.executeQuery();
            // 6、循环读取结果集中的数据
            while (resultSet.next()) {   // 如果结果集中有数据返回true
                // 7、 把结果集中的数据读取出来赋值给用户的属性
                members= new Members(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
                list.add(members);
            }
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return list;
    }


    public static List<Clubs> FindClubs(int ID)
    {
        List<Clubs>list=new ArrayList<>();
        Members members=null;
        // 1、获得数据库的连接对象
        Connection conn = Mysql.conn;
        // 2、书写SQL语句操作数据表
        //String sql = "select club_members.ID,club_members.姓名,club_members.年龄,club_members.专业,club_members.兴趣爱好 from club_members,clubs,club_member_relations  WHERE club_member_relations.Clubs_ID =? and club_members.ID=club_member_relations.Members_ID  ";
        String sql="select  clubs.ID,clubs.社团名称,clubs.社团简介 from club_members  LEFT JOIN club_member_relations ON  club_members.ID = club_member_relations.Members_ID LEFT JOIN clubs ON club_member_relations.Clubs_ID=clubs.ID WHERE club_members.ID=? ";
        // 3、预编译SQL语句
        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            // 4、给SQL语句占位符赋值
            pps.setInt(1, ID);
            // 5、执行查询命令
            ResultSet resultSet = pps.executeQuery();
            // 6、循环读取结果集中的数据
            while (resultSet.next()) {
                Clubs clubs=new Clubs(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                list.add(clubs);
            }
            pps.close();
            Mysql.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static boolean IDisExist(int Member_ID)
    {
        Connection conn = Mysql.conn;
        String sql="(SELECT * from club_member_relations where Members_ID=?)";

        try {
            PreparedStatement pps = conn.prepareStatement(sql);
            pps.setInt(1, Member_ID);
            ResultSet resultSet = pps.executeQuery();
            boolean res=resultSet.next();
            pps.close();
            Mysql.conn.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
class test1{
    public static void main(String[] args) {
        Mysql mysql=new Mysql();
//       List<Clubs>list=MangerRelation.FindClubs(1);
//        System.out.println(list.size());
//       for(int i=0;i<list.size();++i)
//       {
//           System.out.println(list.get(i).getClub());
//           System.out.println(list.get(i).getId());
//       }
        if(MangerRelation.IDisExist(1))
        {
            System.out.println("bdshab");
        }
        else
        {
            System.out.println("sdka");
        }
    }
}
