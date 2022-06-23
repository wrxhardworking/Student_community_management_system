package UI_;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import Mangerdata.MangerClubs;
import Mangerdata.MangerMembers;
import Mangerdata.MangerRelation;
import Mysql.Mysql;
import OBJ.Members;
import Tools.GlobalObject;
import Tools.RenewClubsThrd;


public class UI2 extends JFrame {

    public UI2() {
        //界面二的管理
        setLayout(null);
        setTitle("学生社团管理系统");
        setBounds(400, 0, 1000, 800);
        setLayout(null);
        setResizable(false);
        //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon img = new ImageIcon("imag/8.png");
        JLabel background = new JLabel(img);
        background.setBounds(0, 0, 1000, 800);
        final Container c = getContentPane();
        c.add(background, new Integer(Integer.MIN_VALUE));


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 100);
        JLabel label = new JLabel("学 生 社 团 管 理 系 统", SwingConstants.CENTER);
        label.setBounds(0, 200, 1000, 200);
        label.setFont(new Font("华文琥珀", Font.BOLD, 50));
        panel.add(label);


        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 100, 1000, 500);

        JButton add = new JButton("增加社团");
        JButton delete = new JButton("删除社团");
        JButton updata = new JButton("修改社团");
        JButton find = new JButton("查看社团成员");
        JButton findclubs = new JButton("增加社团成员");
        JButton exit = new JButton("总计");
        add.setSize(200, 200);
        add.setFont(new Font("方正舒体", Font.BOLD, 40));
        delete.setSize(100, 100);
        delete.setFont(new Font("方正舒体", Font.BOLD, 40));
        updata.setSize(100, 100);
        updata.setFont(new Font("方正舒体", Font.BOLD, 40));
        find.setSize(100, 100);
        find.setFont(new Font("方正舒体", Font.BOLD, 40));
        findclubs.setSize(100, 100);
        findclubs.setFont(new Font("方正舒体", Font.BOLD, 40));
        exit.setSize(100, 100);
        exit.setFont(new Font("方正舒体", Font.BOLD, 40));
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 600, 1000, 200);

        add.setContentAreaFilled(false);
        delete.setContentAreaFilled(false);
        updata.setContentAreaFilled(false);
        find.setContentAreaFilled(false);
        findclubs.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);
        add.setFocusPainted(false);//去边框
        delete.setFocusPainted(false);
        updata.setFocusPainted(false);
        find.setFocusPainted(false);
        findclubs.setFocusPainted(false);
        exit.setFocusPainted(false);
        panel2.add(add);
        panel2.add(delete);
        panel2.add(find);
        panel2.add(updata);
        panel2.add(findclubs);
        panel2.add(exit);



        Vector Head = new Vector();
        Vector Msg = new Vector();
        Head.add("ID");
        Head.add("社团名称");
        Head.add("社团信息");
        MangerClubs.ClubsInit(Msg);//java中地址副本的传递（引用传递）

        DefaultTableModel model = new DefaultTableModel(Msg, Head);//表格样式
        JTable table = new JTable(model){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        table.setOpaque(false);
        table.getTableHeader().setFont(new Font("华文楷体", Font.BOLD, 20));

        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.LEFT);
        //表格设置透明
        cr.setOpaque(false);
        table.setOpaque(false);
        table.setDefaultRenderer(Object.class, cr);

        //设置选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);


        table.setFont(new Font("华文楷体", Font.BOLD, 20));
        table.setRowHeight(40);//改变高度
        table.getColumnModel().getColumn(0).setMaxWidth(35);
        table.getColumnModel().getColumn(1).setMinWidth(170);
        table.getColumnModel().getColumn(1).setMaxWidth(170);


        JScrollPane jScrollPane = new JScrollPane(table) {//设置其大小
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 500);
            }
        };
//设置拉动条为透明
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        panel1.add(jScrollPane, BorderLayout.CENTER);


//实时更新表 拿到了地址的副本
        GlobalObject.setjTable(table);


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI3 ui3 = new UI3();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                System.out.println(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()));
                System.out.println("sadjbad");

                Mysql mysql=new Mysql();

                if(MangerClubs.DeleteClub(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()))>0)
                {
                    Mysql mysql1=new Mysql();
                    Vector v= MangerMembers.FindMembersID();
                    for(int i=0;i<v.size();++i)
                    {
                        Mysql mysql2=new Mysql();
                        if(!MangerRelation.IDisExist(Integer.parseInt(v.get(i).toString())))
                        {
                            Mysql mysql3=new Mysql();
                            MangerMembers.DeleteMembers(Integer.parseInt(v.get(i).toString()));
                        }
                    }
                    Thread thread=new Thread(new RenewClubsThrd());
                    thread.start();
                    JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        updata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI5 ui5=new UI5();
            }
        });
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                GlobalObject.setIndex(index);
                System.out.println(index);
                Mysql mysql=new Mysql();
                List<Members>list=new ArrayList<Members>();
                list=MangerRelation.FindMembers(index);
                UI7 ui7=new UI7(list);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"社团总数为："+table.getRowCount(),"信息",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        findclubs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI6 ui6=new UI6();
            }
        });

        panel.setBackground(null);
        panel1.setBackground(null);
        panel2.setBackground(null);
        panel.setOpaque(false);
        panel1.setOpaque(false);
        panel2.setOpaque(false);

        background.add(panel);
        background.add(panel1);
        background.add(panel2);

        setVisible(true);
    }
}
class test2
{
    public static void main(String[] args) {
        UI2 ui2=new UI2();
    }
}