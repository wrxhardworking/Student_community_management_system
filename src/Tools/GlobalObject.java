package Tools;
import Mangerdata.MangerClubs;
import Mangerdata.MangerMembers;
import Mangerdata.MangerRelation;
import Mysql.Mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class GlobalObject {
    private static JTable jTable;
    private static JTable jTable1;
    private static  int index;

    public static JTable getjTable() {
        return jTable;
    }
    public static void setjTable(JTable jTable) {GlobalObject.jTable = jTable;}

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        GlobalObject.index = index;
    }

    public static JTable getjTable1() {
        return jTable1;
    }

    public static void setjTable1(JTable jTable1) {
        GlobalObject.jTable1 = jTable1;
    }

    public static void setDate(JTable table)
    {
        Vector Head = new Vector();
        Vector Msg = new Vector();
        Head.add("ID");
        Head.add("社团名称");
        Head.add("社团信息");
        MangerClubs.ClubsInit(Msg);
        DefaultTableModel model=new DefaultTableModel(Msg,Head);
        table.setModel(model);
        table.getColumnModel().getColumn(0).setMaxWidth(35);
        table.getColumnModel().getColumn(1).setMinWidth(170);
        table.getColumnModel().getColumn(1).setMaxWidth(170);
    }

    public static void setDate2(JTable table)
    {
        Vector Head = new Vector();
        Vector Msg = new Vector();
        Mysql mysql=new Mysql();
        MangerMembers.initTable(Msg,Head,MangerRelation.FindMembers(GlobalObject.getIndex()));
        DefaultTableModel model = new DefaultTableModel(Msg, Head);
        table.setModel(model);
    }

}
