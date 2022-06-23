package Mangerdata;

import Mysql.Mysql;
import OBJ.Users;
import org.junit.Test;

public class test {
    @Test
    public void testUsersFind()
    {

        Mysql mysql=new Mysql();
        if(MangerUser.FindMangerUsers(new Users("a",122223)))
        {System.out.println("yes");}
        else
            System.out.println("no");
    }
    @Test
    public void testUsersAdd()
    {
        Mysql mysql=new Mysql();
        MangerUser.AddMangerUser(new Users("jj",123));
    }
}
